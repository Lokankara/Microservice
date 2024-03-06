import json

def save_to_json_file(data, filename):
    with open(filename, 'w') as f:
        json.dump(data, f)

def read_json(filename):
    with open(filename, 'r') as f:
        data = json.load(f)
    return data
