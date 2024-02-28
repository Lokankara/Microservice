import requests
import pytest

base_url = "https://restful-booker.herokuapp.com/booking"
auth_url = "https://restful-booker.herokuapp.com/auth"

@pytest.fixture(scope="module")
def auth_token():
    auth_data = {"username": "admin", "password": "password123"}
    response = requests.post(auth_url, json=auth_data)
    token = response.json()["token"]
    print(token)
    yield token

@pytest.fixture(scope="session")
def create_booking():
    payload = {
        "firstname": "James",
        "lastname": "Brown",
        "totalprice": 150,
        "depositpaid": True,
        "bookingdates": {
            "checkin": "2024-01-01",
            "checkout": "2024-02-01"
        },
        "additionalneeds": "Breakfast"
    }
    response = requests.post(base_url, json=payload)
    yield response.json()["bookingid"]


def test_update_booking(auth_token, create_booking):
    payload = {
        "firstname": "James",
        "lastname": "Brown",
        "totalprice": 150,
        "depositpaid": False,
        "bookingdates": {
            "checkin": "2024-01-01",
            "checkout": "2024-01-01" 
        },
        "additionalneeds": "Lunch"
    }
    headers = {"Cookie": f"token={auth_token}"}
    booking_id = create_booking 
    print(booking_id)
    response = requests.put(f'{base_url}/{booking_id}', json=payload, headers=headers)
    assert response.status_code == 200
    response_2 = requests.get(f'{base_url}/{booking_id}')
    assert response_2.json()["additionalneeds"] == "Lunch"
    print(response_2.json())

@pytest.fixture(scope="session")
def booking_id():
    payload = {
        "firstname": "James",
        "lastname": "Brown",
        "totalprice": 150,
        "depositpaid": True,
        "bookingdates": {
            "checkin": "2024-01-01",
            "checkout": "2024-02-01"
        },
        "additionalneeds": "Breakfast"
    }
    response = requests.post(base_url, json=payload)
    booking_id = response.json()["bookingid"]
    assert response.status_code == 200
    return booking_id

@pytest.fixture(scope="session")
def booking_id():
    payload = {
        "firstname": "James",
        "lastname": "Brown",
        "totalprice": 150,
        "depositpaid": True,
        "bookingdates": {
            "checkin": "2024-01-01",
            "checkout": "2024-02-01"
        },
        "additionalneeds": "Breakfast"
    }
    response = requests.post(base_url, json=payload)
    booking_id = response.json()["bookingid"]
    assert response.status_code == 200
    yeild booking_id

