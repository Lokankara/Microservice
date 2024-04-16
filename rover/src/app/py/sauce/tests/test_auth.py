from selenium.webdriver.common.by import By
import time 
from src.urls import Urls
from page.sign_page import SignPage
from locators.main_locators import MainLocators
from src.user_data import UserData

class TestAuth:
    def test_login_form(self, browser):
        login = SignPage(browser, Urls.base_url)
        login.open()
        login.login()
        login.click(LOGIN_BUTTON)    
        assert browser.current_url == "https://www.saucedemo.com/inventory.html"

# pytest -s -v --setup-show test_auth.py