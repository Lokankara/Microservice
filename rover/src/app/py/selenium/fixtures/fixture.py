import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

@pytest.fixture(scope="session", autouse=True)
def driver():
    driver = webdriver.Chrome()
    driver.maximize_window()
    yield driver
    driver.quit()

@pytest.fixture
def login(driver, request):
    username = request.param[0]
    password = request.param[1]
    
    driver.get("https://www.saucedemo.com/")
    username_input = driver.find_element(By.CSS_SELECTOR, "*[data-test=\"username\"]")
    password_input = driver.find_element(By.CSS_SELECTOR, "*[data-test=\"password\"]")

    username_input.send_keys(username)
    password_input.send_keys(password)
    password_input.send_keys(Keys.ENTER)

    return username, password
