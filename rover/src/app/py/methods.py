import math

# 4.1
def square_info(side):
    perimeter = 4 * side
    area = side ** 2
    diagonal = math.sqrt(2) * side
    return perimeter, area, diagonal

# 4.2
def print_arguments(**kwargs):
    for key, value in kwargs.items():
        print(f"{key}: {value}")

# 4.3
my_list = [20, -3, 15, 2, -1, -21]
positive_numbers = list(filter(lambda x: x > 0, my_list))

# 4.4
multiply_result = reduce(lambda x, y: x * y, my_list)

# 4.5
import time
def calculate_time(func):
    def wrapper(*args, **kwargs):
        start_time = time.time()
        result = func(*args, **kwargs)
        end_time = time.time()
        print(f"Execution time of {func.__name__}: {end_time - start_time} seconds")
        return result
    return wrapper

def count_AGTC(dna):
    a = dna.count('A')
    g = dna.count('G')
    t = dna.count('T')
    c = dna.count('C')
    return (a, g, t, c)

dna_sequence = "AGCTAGCTAGCT"
counts = count_AGTC(dna_sequence)
print("Counts of A, G, T, C:", counts)

def is_palindrome(text):
    text = ''.join(char for char in text.lower() if char.isalnum())
    return text == text[::-1]

print(is_palindrome("A man, a plan, a canal, Panama!"))  # True
print(is_palindrome("racecar"))  # True
print(is_palindrome("hello"))  # False
