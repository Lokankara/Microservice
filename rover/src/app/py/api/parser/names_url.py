from manager_json import save_to_json_file
import requests
import json

base_url = "https://raw.githubusercontent.com/Lokankara/Micronaut/main/tester/src/test/resources"

url = base_url + "/names.json"
response = requests.get(url)
data = response.json()

save_to_json_file(data, './api/parser/json/names.json')
