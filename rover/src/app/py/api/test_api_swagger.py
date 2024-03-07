import os
import pprint
import pytest
import random
import requests
import unittest
from file_manager import save_json
from file_manager import read_json

pet_id = random.randint(10000, 10000000)
base_url = 'https://petstore.swagger.io/v2'
create_pet = '/pet'
path = '/pet/'
ids = '/ids/'
created_files = []   

def check_status_code(response, code: int):
    status_code = response.status_code
    assert status_code == code, f'Unexpected status code. Expect: {code}. Actual: {status_code}'

class TestFileCreation(unittest.TestCase):

    def test_invalid_create_pet(self):
        url = f'{base_url}{create_pet}'
        response = requests.post(url)
        self.assertEqual(response.status_code, 415, "Expected status code 405, but received {}".format(response.status_code))

    def test_create_pet(self):
        url = f'{base_url}{create_pet}'
        data =  read_json(f'./json{path}create.json')
        data["id"] = pet_id
        response = requests.post(url, json=data)
        check_status_code(response, 200)
        body = response.json()
        expected_keys = {"id", "name", "status", "category", "photoUrls", "tags"}
        response_keys = set(body.keys())
        self.assertSetEqual(expected_keys, response_keys, "Response body does not contain correct keys")        

    def test_get_pet_by_id(self):
        url = f'{base_url}{path}{pet_id}'
        response = requests.get(url)
        check_status_code(response, 200)        
        filename = f'./json{path}{ids}{pet_id}.json'
        save_json(response.json(), filename)
        created_files.append(filename)

    def test_update_pet(self):
        url = f'{base_url}{create_pet}'
        data =  read_json(f'./json{path}create.json')
        data["id"] = pet_id
        response = requests.put(url, json=data)
        check_status_code(response, 200)

    def test_z_delete_pet_by_id(self):
        url = f'{base_url}{path}{pet_id}'
        response = requests.delete(url)
        check_status_code(response, 200)
        response = requests.get(url)
        check_status_code(response, 404)

def teardown_module():
    for file in created_files:
        try: os.remove(file)
        except FileNotFoundError: pass

if __name__ == '__main__':
    unittest.main()
