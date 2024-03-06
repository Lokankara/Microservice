import requests
import pytest
import csv

base_url = "https://restful-booker.herokuapp.com/booking"

@pytest.fixture(scope="module")
def auth_token():
    auth_data = {"username": "admin", "password": "password123"}
    response = requests.post("https://restful-booker.herokuapp.com/auth", json=auth_data)
    token = response.json()["token"]
    return token

def read_csv_file(file_path):
    data = []
    with open(file_path, "r") as file:
        reader = csv.DictReader(file)
        for row in reader:
            data.append(row)
    return data

@pytest.mark.parametrize("payload", read_csv_file("csv/create_payload.csv"))
def test_create_booking(auth_token, payload):
    headers = {"Content-Type": "application/json", "Accept": "application/json", "Cookie": f"token={auth_token}"}
    response = requests.post(base_url, json=payload, headers=headers)
    assert response.status_code == 200

@pytest.mark.parametrize("booking_id", [row["booking_id"] for row in read_csv_file("csv/booking_ids.csv")])
def test_read_booking(booking_id):
    response = requests.get(f"{base_url}/{booking_id}")
    assert response.status_code == 200

@pytest.mark.parametrize("payload", read_csv_file("csv/update_payload.csv"))
@pytest.mark.parametrize("booking_id", [row["booking_id"] for row in read_csv_file("csv/booking_ids.csv")])
def test_update_booking(auth_token, booking_id, payload):
    headers = {"Content-Type": "application/json", "Accept": "application/json", "Cookie": f"token={auth_token}"}
    response = requests.put(f"{base_url}/{booking_id}", json=payload, headers=headers)
    assert response.status_code == 200

@pytest.mark.parametrize("booking_id", [row["booking_id"] for row in read_csv_file("csv/booking_ids.csv")])
def test_delete_booking(auth_token, booking_id):
    headers = {"Content-Type": "application/json", "Accept": "application/json", "Cookie": f"token={auth_token}"}
    response = requests.delete(f"{base_url}/{booking_id}", headers=headers)
    assert response.status_code == 201
