import pytest
from fixtures.fixture import driver, login
from selenium import webdriver
from selenium.webdriver.common.by import By

@pytest.mark.parametrize("login", [("standard_user", "secret_sauce")], indirect=True)
def test_login_with_credentials(driver, login):
    assert driver.find_element(By.CSS_SELECTOR, ".title").text == "Products"
    assert driver.find_element(By.CSS_SELECTOR, ".app_logo").text == "Swag Labs"
    