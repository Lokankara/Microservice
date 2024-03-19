from selenium import webdriver
from selenium.webdriver.common.by import By
import time

def test_random_word_generator():

    driver = webdriver.Chrome()

    driver.get('https://randomwordgenerator.com/')

    driver.maximize_window()

    qty = (By.ID, 'qty')
    result = (By.ID, 'result')
    tag_name = (By.TAG_NAME, 'li')
    category = (By.ID, 'category')
    option = (By.XPATH, "//option[. = 'Nouns']")
    submit = (By.CSS_SELECTOR, "input[type='submit'][name='submit'][value='Generate Random Words']")

    dropdown = driver.find_element(*category)
    dropdown.find_element(*option).click()

    qty_input = driver.find_element(*qty)
    qty_input.clear()
    qty_input.send_keys('50')

    submit_button = driver.find_element(*submit)
    submit_button.click()

    time.sleep(1)

    ul = driver.find_element(*result)
    li_elements = ul.find_elements(*tag_name)

    li_values = [li.text for li in li_elements]

    assert len(li_values) == 50, "Expected 50 elements"

    words = get_longest_words_by_letters(li_values)
    print_map(words)


    driver.quit()

def get_longest_words_by_letters(words):
    longest_words = {}
    for word in words:
        first_letter = word[0].lower()
        current_longest = longest_words.get(first_letter, "")
        if len(word) > len(current_longest):
            longest_words[first_letter] = word
    return longest_words

def print_map(words_map):
    for key, value in words_map.items():
        print(f"{key}: {value}")

if __name__ == "__main__":
    test_random_word_generator()
