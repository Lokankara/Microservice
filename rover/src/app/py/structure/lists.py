my_list = ['a', 'b', [1, 2, 3], 'd']
print(my_list[2])

list_1 = ['Hi', 'ananas', 2, 75, 'pizza', 36, 100]

amount = 0
for l in list_1:
  if isinstance(l, (int, float)): amount += l
print(amount)

amount = 0
for l in list_1:
  if 'a' in str(l): print(l)

leaf = ['cat', 'dog', 'horse', 'cow']
animals = tuple(leaf)
print(animals)

family_1 = input('Enter first family members: ')
family_2 = input('Enter second family members: ')

count_1 = len(family_1.split(','))
count_2 = len(family_2.split(','))

if count_1 > count_2:
  print("Family 1 is larger")

elif count_1 < count_2:
  print("Family 2 is larger")
else:
  print("Equal")

inception = {
    'title': 'Inception',
    'director': 'Christopher Nolan',
    'year': 2010,
    'budget': '$160 million',
    'main_actor': 'Leonardo DiCaprio',
    'slogan': 'Your mind is the scene of the crime.'
}

print('Keys: ', list(inception.keys()))
print('Values: ', list(inception.values()))

print('Key-Value Pairs: ')
for k, v in inception.items(): print(k, ':', v)

my_dictionary = {'num1': 375, 'num2': 567, 'num3': -37, 'num4': 21}
amount = sum(my_dictionary.values())
print('Total:', amount)

nums = [1, 2, 3, 4, 5, 3, 2, 1]
unique = list(set(nums))
print(nums)

set1 = {'a', 'z', 1, 5, 9, 12, 100, 'b'}
set2 = {5, 'z', 1, 8, 9, 21, 100, 'l', 785}

intersection = set1.intersection(set2)
print("Values that occur in both sets:", intersection)

symmetric = set1.symmetric_difference(set2)
print("Values that do not occur in both sets:", symmetric)

if set1.issubset(set2):
    print("set1 is a subset of set2.")
elif set2.issubset(set1):
    print("set2 is a subset of set1.")
else:
    print("Neither set is a subset of the other.")

