class LogoutPage(BasePage):
    def logout(self):
        self.driver.find_element_by_id("logout-button").click()