numbers = [1,2,3,4,5,6,7,8,9]
print(type(numbers)

sentence = 'Fallout 76 - Appalachia Radio - Complete Track list'
words = sentence.split(' ')
print(words)

letters = list(sentence)
print(letters)

for number in numbers: print(number**2)

numbers[0] = 10
print(numbers)

decades = [10,20,30,40,50,60,70,80,90]

print(id(numbers))
numbers.append(decades)
print(id(numbers))

numbers.extends(decades)
print(numbers)

numbers.sort()
print(numbers)
print(sorted(numbers))
print(id(sorted(numbers)))

numbers.reverse()
print(numbers)
print(numbers[0: 4])
print(numbers[0:1:4])
print(numbers[::-1])
