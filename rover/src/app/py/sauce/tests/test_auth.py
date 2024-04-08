from selenium.webdriver.common.by import By
import time 
from page.login_page import LoginPage
from src.locators import MainLocators
from src.data import LOGIN, PASSWORD, MAIN_PAGE, LOGIN_URL

def test_login_form(browser):
    login = LoginPage(browser)
    login.open(MAIN_PAGE)
    login.login(LOGIN, PASSWORD)
    login.click(MainLocators.LOGIN_BUTTON)    
    assert browser.current_url == "https://www.saucedemo.com/inventory.html"


# pytest -s -v --setup-show test_auth.py