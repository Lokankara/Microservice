from selenium.webdriver.common.by import By

class LoginLocators:
    USER_NAME = (By.CSS_SELECTOR, "input[data-test='username']")
    PASSWORD = (By.CSS_SELECTOR, "input[data-test='password']")
    LOGIN_BUTTON = (By.CSS_SELECTOR, "input[data-test='login-button']")
    LOGIN_FORM = (By.CSS_SELECTOR, "div[data-test='login-container']")
