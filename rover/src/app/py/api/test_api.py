import pytest
import requests
import json
from read_csv_payload import csv_to_json
from read_csv_payload import pandas_to_json

base_url = "https://restful-booker.herokuapp.com/booking"
auth_url = "https://restful-booker.herokuapp.com/auth"

#@pytest.mark.parametrize("json_payload", read_csv_file("csv/create_payload.csv"))
@pytest.fixture()
def create_booking():
    json_payload = pandas_to_json("csv/create_payload.csv")[0]
    response = requests.post(base_url, json=json_payload)
    assert response.status_code == 200
    assert "bookingid" in response.json()
    yield response.json()["bookingid"]

@pytest.fixture(scope="module")
def auth_token():
    auth_data = {"username": "admin", "password": "password123"}
    response = requests.post(auth_url, json=auth_data)
    token = response.json()["token"]
    assert response.status_code == 200
    print(token)
    yield token

def test_update_booking(auth_token, create_booking):
    payload = pandas_to_json("csv/update_payload.csv")[0]
    headers = {"Cookie": f"token={auth_token}"}
    url = f'{base_url}/{create_booking}'
    print(url)
    response = requests.put(url, json=payload, headers=headers)
    assert response.status_code == 200
    response_2 = requests.get(url)
    assert response_2.status_code == 200
    assert response_2.json()["additionalneeds"] == "Lunch"

@pytest.fixture(scope="session")
def booking_id():
    payload = pandas_to_json("csv/payload.csv")[0]
    response = requests.post(base_url, json=payload)
    assert response.status_code == 200
    assert "bookingid" in response.json()
    yield response.json()["bookingid"]
