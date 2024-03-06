import pytest
import sys
sys.path.append('../task')

from unittest.mock import mock_open, patch
from data_structure import count_and_sort_votes

@pytest.fixture
def mocked_open():
    with patch("builtins.open", mock_open(read_data="Alice\nBob\nCharlie\nDavid\nEve\n")) as mocked:
        yield mocked

@pytest.mark.parametrize("filename", ["bucket.txt"])
def test_count_and_sort_votes(filename, mocked_open):
    expected_result = [('Alice', 1), ('Bob', 1), ('Charlie', 1), ('David', 1), ('Eve', 1)]
    actual_result = count_and_sort_votes(filename)
    assert sorted(actual_result) == sorted(expected_result)

@pytest.mark.parametrize("filename", ["bucket.txt"])
def test_count_and_sort_votes(filename):
    expected_result = [('John Doe', 1), ('Alice Smith', 1), ('Robert Johnson', 1), ('Jane Williams', 1), ('Michael Brown', 1)]
    actual_result = count_and_sort_votes(filename)
    assert sorted(actual_result) == sorted(expected_result)
