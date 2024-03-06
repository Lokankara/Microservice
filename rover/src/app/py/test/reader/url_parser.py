import requests

url = 'https://raw.githubusercontent.com/Fat-Frumos/Cars/master/py/1000000.txt'

def print_passwords(url):
    response = requests.get(url)
    if response.status_code == 200:
        passwords = set()
        for word in response.text.splitlines():
            if word.upper()[-2:] == 'ER':
                passwords.add(word.upper())

        for p in sorted(passwords, key=lambda x: (len(x), x)):
            print(p)