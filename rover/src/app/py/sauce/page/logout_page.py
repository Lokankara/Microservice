from locators.logout_locators import LogoutLocators

class LogoutPage(BasePage):
    def logout(self):
        self.click_by_element(LogoutLocators.LOGOUT_BUTTON)