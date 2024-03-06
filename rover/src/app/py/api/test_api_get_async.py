import asyncio
import aiohttp
import requests
import csv
import pytest

base_url = 'https://restful-booker.herokuapp.com/booking'

async def get_booking_by_id(booking_id):
    async with aiohttp.ClientSession() as session:
        async with session.get(f'{base_url}/{booking_id}') as response:
            if response.status == 404:
                return None
            assert response.status == 200
            return booking_id

def test_get_status():
    request = requests.get(base_url)
    print(request)
    assert request.status_code == 200


@pytest.mark.asyncio
async def test_get_booking_by_id(booking_ids):
    tasks = [get_booking_by_id(booking_id) for booking_id in booking_ids]
    results = await asyncio.gather(*tasks)
    results = [result for result in results if result is not None]
    assert len(results) == len(booking_ids), "Not all booking IDs were processed"

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
