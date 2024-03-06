import requests
import pytest

auth_url = 'https://restful-booker.herokuapp.com/auth'
base_url = 'https://restful-booker.herokuapp.com/booking'

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

    headers = {
        "Content-Type": "application/json"
    }

    response = requests.post(base_url, json=payload, headers=headers)
    booking_id = response.json()['bookingid']
    assert response.status_code == 200
    return booking_id

def test_check_created_booking_by_id(test_create_booking):
    booking_id = test_create_booking
    response = requests.get(f'{base_url}/{booking_id}')
    json_data = response.json()
    assert response.status_code == 200
    assert json_data['firstname'] == "Jake"

@pytest.fixture(scope='module')
def auth_token():
    auth_data = {
        "username": "admin",
        "password": "password"
    }
    response = requests.post(auth_url, json=auth_data)
    token = response.json().get("token")  # Using .get() to avoid KeyError
    assert response.status_code == 200
    return token

def test_update_booking(auth_token, test_create_booking):
    token = auth_token
    booking_id = test_create_booking

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

    headers = {
        "Content-Type": "application/json",
        "Cookie": f"token={token}"
    }

    response = requests.put(f'{base_url}/{booking_id}', json=payload, headers=headers)
    assert response.status_code == 200

    updated_booking = requests.get(f'{base_url}/{booking_id}')
    assert updated_booking.status_code == 200
    updated_data = updated_booking.json()

    assert updated_data['firstname'] == "James"
    assert updated_data['lastname'] == "Brown"
    assert updated_data['totalprice'] == 156
    assert updated_data['depositpaid'] is False
    assert updated_data['bookingdates']['checkin'] == "2024-01-01"
    assert updated_data['bookingdates']['checkout'] == "2024-02-01"
    assert updated_data['additionalneeds'] == "Lunch"
