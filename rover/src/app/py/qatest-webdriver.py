location='https://qatesttask.mobi-dev.com/accounts/login/'
from selenium import webdriver
import time
import requests

##driver = webdriver.Firefox()
####driver.maximize_window()
##from selenium.webdriver.common.alert import Alert
##driver.get(location)
##
##
##from selenium.webdriver.common.keys import Keys
user_name = "md-user"
password = "MD@QAPass1"
u='https://qatesttask.mobi-dev.com/'
##webbrowser.open(u)

resp = requests.get(u, data={}, auth=(user_name, password))
resp = requests.get(u)
print(resp)

#URL='https://qatesttask.mobi-dev.com/accounts/login/'
#driver = webdriver.Firefox()
#driver.get(URL)
#
#driver.find_element_by_css_selector("input[type = 'email']").send_keys(user)
#driver.find_element_by_css_selector("input[type = 'password']").send_keys(pw)
#
#element = driver.find_element_by_id("id_username")
#element.send_keys(user_name)
#element = driver.find_element_by_id("id_password")
#element.send_keys(password)
#element.send_keys(Keys.RETURN)
#element.close()

time.sleep(6)  

  
# create alert object
alert = Alert(driver)
# get alert text
print(alert.text)
  
# accept the alert
##alert.accept()
####
####button = driver.find_element_by_name('alert')
##obj = driver.switch_to.alert
##
##time.sleep(2)
##
###Enter text into the Alert using send_keys()
##obj.send_keys('Meenakshi')
##
time.sleep(2)


print(" Clicked on the OK Button in the Alert Window")

driver.close

##from selenium.webdriver.common.by import By
##
##
#doc = BeautifulSoup(driver.page_source, "html.parser")
#def open_browser():
#    driver = webdriver.Firefox()
#    driver.get(URL)
#    driver.find_element_by_tag('button').click()
#    text_field = driver.find_element_by_id('id_password')
#    text = wait(driver, 10).until(lambda driver: not text_field.text == 'Gerando...' and text_field.text)
#    return text
#
#print(open_browser())
#
#import webbrowser
#import requests
#from bs4 import BeautifulSoup
#cars=[]
#u=''
#a=[]
#pwd='MD@QAPass1'
#
#id_username='John'
#

#HOST = 'https://www.olx.ua/'
#HEADERS = {'user-agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:72.0) Gecko/20100101 Firefox/72.0',
#
#           'accert': '*/*'}
#
#
##
## print(res)
## for i in res: print(i)
#
#def get_html(URL, params=None):
#    return requests.get(URL,auth=('md-user',pwd))
#
#def get_content(html):
#    soup = BeautifulSoup(html, 'lxml')
#
#    #print(soup.find("ul", attrs={ "id" : "mylist"}))
#    print(soup.find("", id="id_password"))
#    print(soup.find("", id="id_username"))
#    print(soup.find("button", id=""))
#    #
#    # print(soup.form.prettify())
#    # print(soup.find("div", class_='id_password'))
#
#
#    # for i in items:
#    #     print(i)
#
#    #     cars.append({
#    #         'div': i.find('div', class_=''),
#    # #         # 'title': i.find('div', class_='space rel').get_text(strip=True),
#    # #         'a': i.find('a', class_=''),
#    # #         #'link': i.find('a' ).get('href')
#
#    #          })
#
#    # for c in cars:
#    #      for b in c.values(): print(b)
#
#def parse():
#    html = get_html(URL)
#    if (html.status_code) == 200:get_content(html.text)
#    else:
#        print('error')
#
#parse()
#
#    # for i in items:
#    #     cars.append({
#    #         #'div': i.find('img', class_='fleft'),
#    #         'title': i.find('div', class_='space rel').get_text(strip=True),
#    #         #'zaq': i.find('a', class_='fleft' ),
#    #         'link': i.find('a' ).get('href'),
#    #         #'p': i.find('strong', class_='price' )
#    #         })
#
#    # for c in cars:
#    #     for b in c.values():
#
#    #         if isinstance(b, str):
#
#    #             print(b)
#    #             #webbrowser.open(b, new=0)
#
#    #         else:pass
#                #print(b.text)
#
#            #
#        #break
#       #print(c, type(c))
#            #print(k, type(k))
#
#
#u='https://qatesttask.mobi-dev.com/accounts/login/'
#u='https://qatesttask.mobi-dev.com/accounts/login/?next=/'
#webbrowser.open(u)
#resp = requests.get(u, data={}, auth=('John', '000'))
#print(resp)
#for i in resp: print(i)
#
#url = 'https://qatesttask.mobi-dev.com/accounts/login/'
#r=requests.get(u, auth=HTTPDigestAuth('John', '000'))
#for i in r: print(i)
#
###webbrowser.open_new_tab(u)


a=[]
##import glob, os, time
##import ahk
##from selenium import webdriver
##from selenium.webdriver.common.keys import Keys
import pyautogui as pag
import webbrowser
##driver=webdriver.Firefox()
##driver.get("http://qatesttask.mobi-dev.com/")
##pag.click(x=200, y=200)
##print(pag.size())
##pag.moveTo(100, 200, 1)
##pag.moveTo(1625, 327)

##emails = ["joe1@company.address", "linda2@company.address", "greg3@company.address", "hanna4@company.address", "oscar5@company.address", "helen6@company.address"]
webbrowser.open(URL)
pag.PAUSE = 5
pag.typewrite('md-user', interval=0.2)
##pag.moveTo(50, 670, 1)
##pag.press("f12")
##pag.hotkey('ctrl','shift', 'e')
pag.PAUSE = 1
pag.hotkey('ctrl','r')
pag.PAUSE = 1
pag.click(button='right')
pag.moveTo(130, 510, 1)
pag.click()
pag.typewrite('harki', interval=0.2)
pag.PAUSE = 1
pag.press("enter")
##pag.click()
pag.hotkey('ctrl', 'w') 
##pag.click(50, 500)
##pag.typewrite(email)
pag.press("enter")


driver.find_element_by_css_selector("input[type = 'email']").send_keys(user)
driver.find_element_by_css_selector("input[type = 'password']").send_keys(pw)
