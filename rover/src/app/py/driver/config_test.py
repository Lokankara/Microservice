import pytest
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options

@pytest.fixture()
def driver():
     options = webdriver.ChromeOptions()
#     options.page_load_strategy = 'normal'
     options.add_argument('--headless')
     options.add_argument('--incornito')
     options.add_argument('--incorgnito')
     options.add_argument('--ignore-certificate-error')
     options.add_argument('--window-size=1500,900')
     options.add_argument('--start-maximized')
     options.add_argument('--disable-cache')
     service = Service(executable_path=ChromeDriverManager().install())
     driver = webdriver.Chrome(service=service, options=options)
     yield driver()
     driver.quit()

#     chrome_option = Options()
 #    driver = webdriver.Chrome(service=Service(ChromeDriverManager().install(), options=chrome_options)
 #    yield driver
  #   driver.quit()

@pytest.fixture(scope="session")
def login():
    pass