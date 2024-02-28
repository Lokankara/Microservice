def power(x, n):
    return x**n

def add(a, b):
    return a+b

def subtract(a, b):
    return a-b

def divide(a, b):
    return a/b

def multiply(a, b):
    return a*b

action = input()
x = int(input())

actions = {"**": power, "*": multiply, "+": add, "-": subtract , "/": divide }

if action in actions:
    print(actions[action](x))
else
    print("Unsupported action")
