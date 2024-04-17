from selenium.webdriver.common.by import By
import time 
from src.urls import Urls
from page.sign_page import SignPage
from locators.main_locators import MainLocators
from src.user_data import UserData

class TestAuth:
    main_locators = MainLocators()
    def test_login_form(self, browser):
        login = SignPage(browser, Urls.base_url)
        login.open()
        login.login()
        #login.click_by_element(self.main_locators.LOGIN_BUTTON)    
        assert browser.current_url == "https://www.saucedemo.com/inventory.html"

# pytest -s -v --setup-show tests/test_auth.py