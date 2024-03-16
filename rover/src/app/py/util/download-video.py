import json
from pytube import YouTube
import os

def download_video(url, output_path):
    try:
        yt = YouTube(url)
        stream = yt.streams.filter(res="360p").first()
        if os.path.exists(os.path.join(output_path, f"{yt.title}.mp4")):
            print(f"Video already exists: {yt.title}")
            return
        stream.download(output_path)
        print(f"Video downloaded: {yt.title}")
    except Exception as e:
        print(f"Error downloading video: {e}")

def download_videos_from_json(json_file, category='theory', start=0, limit=3):
    try:
        with open(json_file, "r", encoding="utf-8") as file:
            video_info = json.load(file)
        
        print(f"Downloading videos for category: {category}")
        links = video_info.get(category, {})
        ranges = len(links.items()) # start + limit
        print(ranges)
        for idx, (title, url) in enumerate(links.items()):
            if idx >= start and idx < start + ranges:
                download_video(url, f'./{category}')
    except Exception as e:
        print(f"Error loading JSON file: {e}")

if __name__ == "__main__":
    json_file = "video_info.json"
    download_videos_from_json(json_file, 'theory', 0, 3)
