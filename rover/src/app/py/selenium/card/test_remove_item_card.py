import pytest
from fixtures.fixture import driver, login
from selenium import webdriver
from selenium.webdriver.common.by import By

@pytest.mark.parametrize("login", [("standard_user", "secret_sauce")], indirect=True)
def test_removecard(driver, login):
  driver.find_element(By.CSS_SELECTOR, "*[data-test=\"add-to-cart-sauce-labs-fleece-jacket\"]").click()
  driver.find_element(By.CSS_SELECTOR, "*[data-test=\"remove-sauce-labs-fleece-jacket\"]").click()

  assert driver.find_element(By.CSS_SELECTOR, "*[data-test=\"add-to-cart-sauce-labs-fleece-jacket\"]").text == "Add to cart"    
  driver.find_element(By.CSS_SELECTOR, "*[data-test=\"add-to-cart-sauce-labs-fleece-jacket\"]").click()
  driver.find_element(By.CSS_SELECTOR, ".shopping_cart_link").click()
  assert driver.find_element(By.CSS_SELECTOR, "*[data-test=\"remove-sauce-labs-fleece-jacket\"]").text == "Remove"

  cart_items = driver.find_elements(By.XPATH, "//div[@class='cart_item']")
  cart_item_count = len(cart_items)
  expected_count = 1
  assert cart_item_count == expected_count, f"Expected {expected_count} cart items but found {cart_item_count}"

  driver.find_element(By.XPATH, "//button[@id=\'remove-sauce-labs-fleece-jacket\']").click()
  driver.find_element(By.XPATH, "//button[@id=\'continue-shopping\']").click()
