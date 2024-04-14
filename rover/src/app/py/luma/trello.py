import re
import json
import requests

server_url = "http://localhost:8080/api/cards"
file_path = r"e:\luma.json"

try:
    with open(file_path, "r") as file:
        data = json.load(file)
        
        for card_data in data['cards']:
            url_match = re.search(r'\[(.*?)\]\((.*?)\)', card_data['desc'])
            url = url_match.group(2) if url_match else None
            card_info = {
                'name': card_data['name'],
                'description': card_data['desc'],
                'url': url
            }
            try:
                response = requests.post(server_url, json=card_info)
                response.raise_for_status() 
#                print("Card sent successfully:", card_info['name'])
            except requests.exceptions.RequestException as e:
                print(f"Failed to send card '{card_info['name']}': {e}")
except FileNotFoundError:
    print(f"File '{file_path}' not found.")
except json.JSONDecodeError:
    print(f"Failed to decode JSON data from file '{file_path}'.")
except Exception as e:
    print(f"An error occurred: {e}")
