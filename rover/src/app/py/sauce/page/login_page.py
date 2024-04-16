from page.base_page import BasePage
from locators.login_locators import LoginLocators
from src.user_data import UserData

class LoginPage(BasePage):
    locators = LoginLocators()
    customer = UserData()
