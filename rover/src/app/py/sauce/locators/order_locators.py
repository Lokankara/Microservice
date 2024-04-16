from selenium.webdriver.common.by import By

class OrderLocators:
    FIRST_NAME = (By.CSS_SELECTOR, "input[data-test='firstName']")
    LAST_NAME = (By.CSS_SELECTOR, "input[data-test='lastName']")
    ZIP_CODE = (By.CSS_SELECTOR, "input[data-test='postalCode']")
    CONTINUE_BTN = (By.CSS_SELECTOR, "input[id='continue']")
    FINISH_BTN = (By.CSS_SELECTOR, "button[id='finish']")
    SUCCESSFUL_ORDER = (By.CSS_SELECTOR, "h2[data-test='complete-header']")
    ERROR_MESSAGE = (By.CSS_SELECTOR, "h3[data-test='error']")