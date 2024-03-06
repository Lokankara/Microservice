import pytest
import sys
sys.path.append('../task')

from algorithm import factorize

class FactorizeArgumentsProvider:

    @staticmethod
    def provide_test_cases():
        return [
            (2, [2]),
            (3, [3]),
            (4, [2, 2]),
            (6, [2, 3]),
            (8, [2, 2, 2]),
            (9, [3, 3]),
            (10, [2, 5]),
            (12, [2, 2, 3]),
            (13, [13])
        ]

@pytest.mark.parametrize("number, expected", FactorizeArgumentsProvider.provide_test_cases())
def test_factorize(number, expected):
    assert factorize(number) == expected
