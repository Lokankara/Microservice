import requests

base_url = "https://ipaudio5.com/wp-content/uploads/STARR/star/Heir%20to%20the%20Empire/"

file_range = range(1, 23)

save_directory = "/"

for file_number in file_range:

    file_url = f"{base_url}{file_number:02d}.mp3"
    
    response = requests.get(file_url)
    
    if response.status_code == 200:
   
        with open(f"{save_directory}{file_number:02d}.mp3", 'wb') as file:
            file.write(response.content)
            print(f"Downloaded {file_number:02d}.mp3")
    else:
        print(f"Failed to download {file_number:02d}.mp3. Status code: {response.status_code}")
