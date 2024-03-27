import pytest
from fixtures.fixture import driver, login
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

@pytest.mark.parametrize("login", [("standard_user", "secret_sauce")], indirect=True)
def test_card(driver, login):

    driver.find_element(By.CSS_SELECTOR, ".inventory_item:nth-child(3) > .inventory_item_description").click()
    assert driver.find_element(By.CSS_SELECTOR, "#item_1_title_link > .inventory_item_name").text == "Sauce Labs Bolt T-Shirt"
    
    driver.find_element(By.CSS_SELECTOR, "*[data-test=\"add-to-cart-sauce-labs-bolt-t-shirt\"]").click()
    driver.find_element(By.CSS_SELECTOR, ".shopping_cart_link").click()
    assert driver.find_element(By.CSS_SELECTOR, ".shopping_cart_badge").text == "1"
    assert driver.find_element(By.CSS_SELECTOR, "#item_1_title_link > .inventory_item_name").text == "Sauce Labs Bolt T-Shirt"
    
    driver.find_element(By.CSS_SELECTOR, "#item_1_title_link > .inventory_item_name").click()
    assert driver.find_element(By.CSS_SELECTOR, ".inventory_details_name").text == "Sauce Labs Bolt T-Shirt"
    
    driver.find_element(By.ID, "react-burger-menu-btn").click()
    logout_link = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.ID, "logout_sidebar_link")))
    logout_link.click()
