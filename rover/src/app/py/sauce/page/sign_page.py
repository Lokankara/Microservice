from page.base_page import BasePage
from locators.login_locators import LoginLocators
from selenium.webdriver.common.by import By

class SignPage(BasePage):
    def enter_username(self, username):
        self.send_keys(LoginLocators.USER_NAME, username)

    def enter_password(self, password):
        self.send_keys(LoginLocators.PASSWORD, password)
