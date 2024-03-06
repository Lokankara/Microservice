import pytest
import sys
sys.path.append('../task')

from algorithm import is_prime

@pytest.mark.parametrize("number", [2, 3, 5, 7, 11, 13, 17, 19])
def test_is_prime(number):
    assert is_prime(number) == True


@pytest.mark.parametrize("number", range(2, 20))
def test_is_prime_in_range(number):
    assert is_prime(number) == (number in [2, 3, 5, 7, 11, 13, 17, 19])
