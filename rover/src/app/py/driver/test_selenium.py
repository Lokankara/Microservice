import time

def test_get(driver):
    driver.get("https://www.google.com/")
    time.sleep(2)