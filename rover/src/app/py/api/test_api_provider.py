from read_csv_payload import read_csv_file
from file_manager import save_json
from file_manager import read_json
from pprint import pprint
import requests
import pytest

base_url = "https://restful-booker.herokuapp.com/booking"

created_files = []

@pytest.fixture(scope="module")
def auth_token():
    auth_data = {"username": "admin", "password": "password123"}
    response = requests.post("https://restful-booker.herokuapp.com/auth", json=auth_data)
    assert response.status_code == 200
    token = response.json()["token"]
    print(token)
    return token

@pytest.fixture
def headers(auth_token):
    return {
        "Content-Type": "application/json",
        "Accept": "application/json",
        "Cookie": f"token={auth_token}"
    }    

@pytest.mark.parametrize("payload", read_json("json/booking/create_payload.json"))
def test_create_booking(headers, payload):
    response = requests.post(base_url, json=payload, headers=headers)
    assert response.status_code == 200

@pytest.mark.parametrize("booking_id", [row["bookingid"] for row in read_csv_file("csv/booking_ids.csv")])
def test_read_booking(booking_id):
    response = requests.get(f"{base_url}/{booking_id}")
    if response.status_code == 404: pprint(404)
    else: 
        assert response.status_code == 200
        save_json(response.json(), f'json/booking/payload_{booking_id}.json')
        created_files.append(booking_id)

# @pytest.mark.parametrize("payload", read_csv_file("csv/update_payload.csv"))
# @pytest.mark.parametrize("booking_id", [row["bookingid"] for row in read_csv_file("csv/booking_ids.csv")])
# def test_update_booking(headers, booking_id, payload):
#     response = requests.put(f"{base_url}/{booking_id}", json=payload, headers=headers)
#     assert response.status_code == 200

@pytest.mark.parametrize("booking_id", [row["bookingid"] for row in read_csv_file("csv/booking_ids.csv")])
def test_delete_booking(headers, booking_id):
    response = requests.delete(f"{base_url}/{booking_id}", headers=headers)
    assert response.status_code == 201
