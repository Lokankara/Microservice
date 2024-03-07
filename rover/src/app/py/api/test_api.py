from read_csv_payload import pandas_to_json
import requests
import pytest
import json

base_url = "https://restful-booker.herokuapp.com/booking"
auth_url = "https://restful-booker.herokuapp.com/auth"

@pytest.fixture(scope="module")
def auth_token():
    auth_data = {
        "username": "admin",
        "password": "password123"
    }
    response = requests.post(auth_url, json=auth_data)
    token = response.json()["token"]
    print(token)
    assert response.status_code == 200
    yield token

@pytest.fixture
def headers(auth_token):
    return {
        "Content-Type": "application/json",
        "Accept": "application/json",
        "Cookie": f"token={auth_token}"
    }    

#@pytest.mark.parametrize("json_payload", read_csv_file("csv/create_payload.csv"))
@pytest.fixture()
def create_booking():
    json_payload = pandas_to_json("csv/create_payload.csv")[0]
    response = requests.post(base_url, json=json_payload)
    assert response.status_code == 200
    assert "bookingid" in response.json()
    yield response.json()["bookingid"]


def test_update_booking(headers, create_booking):
    payload = pandas_to_json("csv/update_payload.csv")[0]
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

@pytest.fixture
def test_create_booking():
    payload = {
        "firstname": "Jake",
        "lastname": "Smith",
        "totalprice": 111,
        "depositpaid": True,
        "bookingdates": {
            "checkin": "2024-02-02",
            "checkout": "2025-02-02"
        },
        "additionalneeds": "Breakfast"
    }

    response = requests.post(base_url, json=payload)
    booking_id = response.json()['bookingid']
    assert response.status_code == 200
    return booking_id

def test_check_created_booking_by_id(test_create_booking):
    response = requests.get(f'{base_url}/{test_create_booking}')
    json_data = response.json()
    assert response.status_code == 200
    assert json_data['firstname'] == "Jake"

def test_update_booking(headers, test_create_booking):
    payload = {
        "firstname": "James",
        "lastname": "Brown",
        "totalprice": 156,
        "depositpaid": False,
        "bookingdates": {
            "checkin": "2024-01-01",
            "checkout": "2024-02-01"
        },
        "additionalneeds": "Lunch"
    }

    response = requests.put(f'{base_url}/{test_create_booking}', json=payload, headers=headers)
    assert response.status_code == 200
    updated_booking = requests.get(f'{base_url}/{test_create_booking}')
    assert updated_booking.status_code == 200
    updated_data = updated_booking.json()
    assert updated_data['firstname'] == "James"
    assert updated_data['lastname'] == "Brown"
    assert updated_data['totalprice'] == 156
    assert updated_data['depositpaid'] is False
    assert updated_data['bookingdates']['checkin'] == "2024-01-01"
    assert updated_data['bookingdates']['checkout'] == "2024-02-01"
    assert updated_data['additionalneeds'] == "Lunch"
