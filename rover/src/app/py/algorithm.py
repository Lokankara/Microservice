def is_simple(x: int):
    return all(x % d != 0 for d in range(2, x -1))

def is_simples(x: int):
    return all(x % d != 0 for d in range(2, int(x**0.5) + 1))

for x in range(2, 100):
    if is_simples(x): print(x, end= " " )

def factorize(x: int):
    assert > 0, " less than 0" 
    divs = []
    d = 2
    while x != 1:
        while x % d == 0:
            divs.append(x)
            x //= d
        d +=1
    return divs

     