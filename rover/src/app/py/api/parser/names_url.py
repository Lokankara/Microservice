from manager_json import save_to_json_file
import requests
import json

base_url = "https://raw.githubusercontent.com/aruljohn/popular-baby-names/master/"

merged_data = []

for year in range(1880, 2023):
    url = base_url + str(year) + "/girl_boy_names_" + str(year) + ".json"
    response = requests.get(url)
    data = response.json()
    data['year'] = year
    merged_data.append(data)

save_to_json_file(merged_data, 'all.json')
