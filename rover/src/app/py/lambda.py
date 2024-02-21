starts_with = lambda s: s.startswith('W')

func = lambda x: x % 19 == 0 or x % 13 == 0

result = lambda a, b: (a ** 2) + (b ** 2)

data = ["apple", "orange", "pear", "lemon", "cherry", "mango", "apricot", "kiwi"]
sorted_by_len = sorted(data, key=lambda x: (-len(x), x), reverse=True)
print(*sorted_by_len))
sorted_by_name = sorted(data, key=lambda x: x)
print(*sorted_by_name))

numbers = [-3, 0, 2, 0, -5, 4, 0, -1]

negatives = len(list(filter(lambda x: x < 0, numbers)))

zeros = len(list(filter(lambda x: x == 0, numbers)))

positives = len(list(filter(lambda x: x > 0, numbers)))

print(negatives_count, zeros_count, positives_count)
