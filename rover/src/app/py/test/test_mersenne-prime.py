import sys
sys.path.append('../task')

from algorithm import mersenne_prime

import pytest
@pytest.mark.parametrize("p, expected", [
    (0, False),
    (1, False),
    (2, True),
    (3, True),
    (4, False),
    (5, True),
    (6, False),
    (7, True),
    (8, False),
    (9, False),
    (10, False),
    (11, False),
    (12, False),
    (13, True),
])
def test_mersenne_prime(p, expected):
    assert mersenne_prime(p) == expected
