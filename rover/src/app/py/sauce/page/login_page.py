from page.base_page import BasePage
from src.locators import MainLocators

class LoginPage(BasePage):
    locators = LoginLocators()
    customer = UserData()

    # def __init__(self, driver):
    #     super().__init__(driver)

    # def open(self, url):
    #     self.open_url(url)

    # def login(self, username, password):
    #     self.send_keys(MainLocators.USERNAME_FIELD, username)
    #     self.send_keys(MainLocators.PASSWORD_FIELD, password)

    # def click(self, locator):
    #     self.click_by_element(locator)

    # def current_url(self):
    #     self.get_current_url()
