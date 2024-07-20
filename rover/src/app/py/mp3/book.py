import os
import requests

base_url = "https://storageext.ezaudiobooks.com/audio/dune-the-battle-of-corrin/1641985933182/"
headers = {
    "Range": "bytes=0-",
    "Referer": "https://audiobooks4soul.com/",
    "User-Agent": "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Mobile Safari/537.36"
}

for i in range(1, 31):
    file_name = f"{i:02d} - Dune The Battle of Corrin.mp3"
    url = base_url + file_name
    response = requests.get(url, headers=headers, stream=True)

    if response.status_code == 206:
        with open(file_name.replace(" ", "_"), "wb") as file:
            for chunk in response.iter_content(chunk_size=8192):
                file.write(chunk)
        print(f"Downloaded: {file_name}")
    else:
        print(f"Failed to download {file_name}. Status code: {response.status_code}")
