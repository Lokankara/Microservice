def is_prime(x: int):
    return all(x % d != 0 for d in range(2, int(x**0.5) + 1))

def factorize(x: int):
    assert x > 0, "Value must be greater than 0"
    divs = []
    d = 2
    while x != 1:
        while x % d == 0:
            divs.append(d)
            x //= d
        d += 1
    return divs

def mersenne_prime(p):
    if p <= 1:
        return False
    if not is_prime(p):
        return False
    m = 2**p - 1
    return is_prime(m)
