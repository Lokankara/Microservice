import json
import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

def scroll_to_bottom(driver):
    html = driver.find_element(By.TAG_NAME, 'html')
    html.send_keys(Keys.END)
    time.sleep(1)
    return driver.execute_script("return document.body.scrollHeight")

def categorize_video(title):
    if 'теория' in title.lower():
        return 'theory'
    elif 'практика' in title.lower():
        return 'practice'
    else:
        return 'other'

def get_video_info(channel_url):
    try:
        options = webdriver.ChromeOptions()
        options.add_argument("--start-maximized")
        driver = webdriver.Chrome(options=options)
        driver.get(channel_url)
        
        WebDriverWait(driver, 15).until(EC.presence_of_element_located((By.TAG_NAME, "h3")))

        old_video_count = 0
        
        while True:
            scroll_to_bottom(driver)
            time.sleep(1)
            video_elements = driver.find_elements(By.TAG_NAME, "h3")
            new_video_count = len(video_elements)
            
            if new_video_count > old_video_count:
                print("Not yet at the bottom of the page, loaded new videos")
                old_video_count = new_video_count
            else:
                print("Reached the bottom of the page")
                break

        video_info = {'theory': {}, 'practice': {}, 'other': {}}
        video_elements = driver.find_elements(By.TAG_NAME, "h3")
        
        for element in video_elements:
            try:
                a_tag = element.find_element(By.TAG_NAME, "a")
                title = a_tag.get_attribute("title")
                category = categorize_video(title)
                href = a_tag.get_attribute("href")
                video_info[category][title] = href
            except Exception as e:
                continue
        
        return video_info
    
    except Exception as e:
        print(f"Error: {e}")
        return None
    
    finally:
        driver.quit()

if __name__ == "__main__":
    channel_url = "https://www.youtube.com/@artuomkudryashov.5884/videos"
    video_info = get_video_info(channel_url)
    if video_info:
        print("Titles and URLs of all videos:")
        for title, url in video_info.items():
            print(f"Title: {title}, URL: {url}")
        with open("video_info.json", "w") as json_file:
            json.dump(video_info, json_file, indent=4, ensure_ascii=False)
            print("Video information saved to 'video_info.json'")
