import requests
import pytest
import concurrent.futures
from file_manager import save_csv

base_url = 'https://restful-booker.herokuapp.com/booking'

def test_get_status():
    request = requests.get(base_url)
    assert request.status_code == 200

def get_booking_by_id(booking_id):
    response = requests.get(f'{base_url}/{booking_id}')
    if response.status_code == 404: return None
    assert response.status_code == 200
    return booking_id

@pytest.fixture()
def booking_ids():
    response = requests.get(base_url)
    assert response.status_code == 200
    return sorted([booking['bookingid'] for booking in response.json()])[:10]

def test_save_booking_ids_to_csv(booking_ids):
    assert isinstance(booking_ids, list)
    assert len(booking_ids) > 0
    save_csv(booking_ids, "./csv/booking_ids.csv")

def test_get_booking_by_id(booking_ids):
    with concurrent.futures.ThreadPoolExecutor() as executor:
        for result in list(executor.map(get_booking_by_id, booking_ids)):
            if isinstance(result, int): continue
            assert result.status_code == 200, f"Response status code is {result.status_code}"
