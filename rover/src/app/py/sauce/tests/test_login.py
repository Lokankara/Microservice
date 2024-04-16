from locators.main_locators import MainLocators
from page.login_page import LoginPage
from src.urls import Urls
import allure

@allure.epic("Test Login page")
class TestLogin:
    url = Urls()
    main_locators = MainLocators()

    @allure.title("test login with Products")
    @allure.description("test check if user redirect to Products after login")
    @allure.severity(allure.severity_level.BLOCKER)
    def test_login(self, browser):
        page = LoginPage(browser, self.url.base_url)
        page.open()
        page.login()
        actual_text = page.get_text(self.main_locators.TITLE)
        expected_text = "Products"
        assert actual_text == expected_text, \
            f"Unexpected text, expected text: {expected_text}, actual text: {actual_text}"

    @allure.title("test login with CARDS")
    @allure.description("test check if user redirect to Products with CARDS after login")
    @allure.severity(allure.severity_level.TRIVIAL)
    def test_login1(self, browser):
        page = LoginPage(browser, self.url.base_url)
        page.open()
        page.login()
        expected_len = 6
        cards = page.get_length(self.main_locators.CARDS)
        assert cards == expected_len, f"Expected: {expected_len}, actual: {cards}"
        