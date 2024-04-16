from page.base_page import BasePage
from src.locators import MainLocators
from src.data import UserData

class LoginPage(BasePage):
    locators = MainLocators()
    customer = UserData()
