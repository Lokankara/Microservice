from selenium.webdriver.common.by import By

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