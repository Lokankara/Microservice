import csv
import json
import requests

csv_url = "https://www.gutenberg.org/cache/epub/feeds/pg_catalog.csv"

response = requests.get(csv_url)
csv_data = response.text

csv_lines = csv_data.split('\n')

csv_reader = csv.DictReader(csv_lines)
json_data = []

for row in csv_reader:
    if len(row) == len(csv_reader.fieldnames):
        entry = {key.strip(): value.strip() for key, value in row.items()}
        json_data.append(entry)

with open('gutenberg_catalog.json', 'w', encoding='utf-8') as json_file:
    json.dump(json_data, json_file, indent=2, ensure_ascii=False)

print("JSON data saved to 'gutenberg_catalog.json'")
