from manager_json import read_json

import json

def get_names_by(filename, start: int, end: int):

    result = []
    for item in read_json(filename):
        year = item.get('year')
        if start <= year <= end:
            result.append({
                'year': year,
                'girls': item.get('girls', []),
                'boys': item.get('boys', [])
            })

    return result
