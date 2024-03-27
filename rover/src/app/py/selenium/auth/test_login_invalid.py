import pytest
from fixtures.fixture import driver, login
from selenium import webdriver
from selenium.webdriver.common.by import By

@pytest.mark.parametrize("login", [("user", "user")], indirect=True)
def test_login_with_credentials(driver, login):
  message = "Epic sadface: Username and password do not match any user in this service"
  assert driver.find_element(By.CSS_SELECTOR, "*[data-test=\"error\"]").text == message
    