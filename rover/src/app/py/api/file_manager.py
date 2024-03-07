import json
import csv
import os

def save_json(data, filename: str):
    with open(filename, 'w') as file:
        json.dump(data, file)
    assert os.path.exists(filename), "File was not created successfully"
    return filename

def read_json(filename) -> dict:
    with open(filename, 'r') as f:
        data = json.load(f)
    return data

def save_csv(data, filename: str):
    with open(filename, "w", newline="") as csvfile:
        writer = csv.writer(csvfile)
        writer.writerow(["bookingid"])
        for booking_id in data:
            writer.writerow([booking_id])
    csvfile.close()
    