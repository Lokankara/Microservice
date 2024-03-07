import asyncio
import aiohttp
import requests
import pytest
from file_manager import save_csv

base_url = 'https://restful-booker.herokuapp.com/booking'

async def get_booking_by_id(booking_id):
    async with aiohttp.ClientSession() as session:
        async with session.get(f'{base_url}/{booking_id}') as response:
            if response.status == 404: return None
            assert response.status == 200
            return booking_id

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
    return sorted([booking['bookingid'] for booking in response.json()])[:4]

def test_save_booking_ids_to_csv(booking_ids):
    assert isinstance(booking_ids, list)
    assert len(booking_ids) > 0
    save_csv(booking_ids, "./csv/booking_ids.csv")
