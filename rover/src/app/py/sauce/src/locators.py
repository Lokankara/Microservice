from selenium.webdriver.common.by import By

class CartLocators:
    CHECKOUT_BTN = (By.CSS_SELECTOR, "button[data-test='checkout']")

class LoginLocators:
    USER_NAME = (By.CSS_SELECTOR, "input[data-test='username']")
    PASSWORD = (By.CSS_SELECTOR, "input[data-test='password']")
    LOGIN = (By.CSS_SELECTOR, "input[data-test='login-button']")
    LOGIN_FORM = (By.CSS_SELECTOR, "div[data-test='login-container']")    

class MainLocators:
    USERNAME_FIELD = (By.XPATH, '//input[@data-test="username"]')
    PASSWORD_FIELD = (By.XPATH, '//input[@data-test="password"]')
    TITLE = (By.CSS_SELECTOR, "span[data-test='title']")
    CARDS = (By.CSS_SELECTOR, "div[data-test='inventory-item']")
    SAUCE_LABS_BACKPACK = (By.CSS_SELECTOR, "button[data-test='add-to-cart-sauce-labs-backpack']")
    REMOVE_SAUCE_LABS_BACKPACK = (By.CSS_SELECTOR, "button[data-test='remove-sauce-labs-backpack']")
    CART_BTN = (By.CSS_SELECTOR, "a[data-test='shopping-cart-link']")
    BURGER_MENU = (By.CSS_SELECTOR, "div[class='bm-burger-button']")
    LOGOUT_BTN = (By.CSS_SELECTOR, "a[data-test='logout-sidebar-link']")
    SELECT = (By.XPATH, "//select[@data-test='product-sort-container']")
    LOGIN_BUTTON = (By.XPATH, '//input[@data-test="login-button"]')
    PRICE_VALUE = (By.CSS_SELECTOR, "div[data-test='inventory-item-price']")
    COUNT_ITEMS = (By.CSS_SELECTOR, "span[data-test='shopping-cart-badge']")    

class OrderLocators:
    FIRST_NAME = (By.CSS_SELECTOR, "input[data-test='firstName']")
    LAST_NAME = (By.CSS_SELECTOR, "input[data-test='lastName']")
    ZIP_CODE = (By.CSS_SELECTOR, "input[data-test='postalCode']")
    CONTINUE_BTN = (By.CSS_SELECTOR, "input[id='continue']")
    FINISH_BTN = (By.CSS_SELECTOR, "button[id='finish']")
    SUCCESSFUL_ORDER = (By.CSS_SELECTOR, "h2[data-test='complete-header']")
    ERROR_MESSAGE = (By.CSS_SELECTOR, "h3[data-test='error']")