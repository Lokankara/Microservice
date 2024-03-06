import requests
import json
import pytest
import csv
import concurrent.futures

base_url = 'https://restful-booker.herokuapp.com/booking'

def test_get_status():
    request = requests.get(base_url)
    print(request)
    assert request.status_code == 200

def get_booking_by_id(booking_id):
    response = requests.get(f'{base_url}/{booking_id}')
    if response.status_code == 404:
        return None
    json_data = response.json()
    assert response.status_code == 200
#    expected_keys = ['firstname', 'lastname', 'totalprice', 'depositpaid', 'bookingdates', 'additionalneeds']
#    assert all(key in json_data for key in expected_keys), f"Expected keys {expected_keys} not found in response JSON for booking ID {booking_id}"
    return booking_id


@pytest.fixture()
def booking_ids():
    response = requests.get(base_url)
    assert response.status_code == 200
    return sorted([booking['bookingid'] for booking in response.json()])

def test_save_booking_ids_to_csv(booking_ids):
    assert isinstance(booking_ids, list)
    assert len(booking_ids) > 0
    with open("./csv/all_bookings_ids.csv", "w", newline="") as csvfile:
        writer = csv.writer(csvfile)
        writer.writerow(["bookingid"])
        for booking_id in booking_ids:
            writer.writerow([booking_id])
    print(len(booking_ids))

def test_get_booking_by_id(booking_ids):
    with concurrent.futures.ThreadPoolExecutor() as executor:
        results = list(executor.map(get_booking_by_id, booking_ids))   
    results = [result for result in results if result is not None]
    for result in results:
        assert result.status_code == 200, f"Response status code is {result.status_code}"

