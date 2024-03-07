import pandas as pd
import json
import csv

def read_csv_file(file_path):
    with open(file_path, "r", encoding='utf-8') as file:
        reader = csv.DictReader(file)
        for row in reader:
            yield row
    file.close()

def csv_to_json(filename):
    payload_dict = next(read_csv_file(filename))
    payload_dict["totalprice"] = int(payload_dict["totalprice"])
    payload_dict["depositpaid"] = payload_dict["depositpaid"].lower() == "true"
    payload_dict["bookingdates"] = {
        "checkin": payload_dict["checkin"],
        "checkout": payload_dict["checkout"]
    }
    del payload_dict["checkin"]
    del payload_dict["checkout"]
    return payload_dict

def pandas_to_json(filename):
    df = pd.read_csv(filename)
    df['checkin'] = pd.to_datetime(df['checkin'])
    df['checkout'] = pd.to_datetime(df['checkout'])
    df['bookingdates'] = df[['checkin', 'checkout']].apply(lambda x: {'checkin': x['checkin'].strftime('%Y-%m-%d'), 'checkout': x['checkout'].strftime('%Y-%m-%d')}, axis=1)
    df.drop(columns=['checkin', 'checkout'], inplace=True)
    return json.loads(df.to_json(orient='records', indent=4))
