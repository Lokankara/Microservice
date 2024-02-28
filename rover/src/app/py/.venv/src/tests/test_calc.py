import pytest

import os
import sys
sys.path.append(os.path.join(os.path.dirname(__file__), "..", ".."))
from src.calc import add, subtract, multiply, divide


def test_add():
    assert add(5, 3) == 8
    assert add(-5, 3) == -2
    assert add(0, 0) == 0

def test_subtract():
    assert subtract(5, 3) == 2
    assert subtract(-5, 3) == -8
    assert subtract(0, 0) == 0

def test_multiply():
    assert multiply(5, 3) == 15
    assert multiply(-5, 3) == -15
    assert multiply(0, 0) == 0

def test_divide():
    assert divide(6, 3) == 2
    assert divide(-6, 3) == -2
    assert divide(5, 2) == 2.5
    with pytest.raises(ZeroDivisionError):
        divide(5, 0)
