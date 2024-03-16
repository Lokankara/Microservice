import requests

base_url = "https://ia802509.us.archive.org/17/items/03_20220514_202205/"

for i in range(1, 31):
    url = base_url + f"{i:02d}.mp3"
    response = requests.get(url)
    print(response)
    
    if response.status_code == 200:
        with open(f"file_{i:02d}.mp3", "wb") as f:
            f.write(response.content)
        print(f"Downloaded file_{i:02d}.mp3")
    else:
        print(f"Failed to download file_{i:02d}.mp3")
