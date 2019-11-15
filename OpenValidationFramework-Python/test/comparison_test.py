import math

import HUMLFramework as huml

class TestComparisonsEqual:

    def test_string_equals_string(self):
        assert huml.EQUALS("name", "name")
        assert not huml.EQUALS("name", "no name")

    def test_number_equals_number(self):
        assert huml.EQUALS(1.0, 1)
        assert huml.EQUALS(1.0, 1.0)
        assert huml.EQUALS(1, 1)
        assert not huml.EQUALS(1, 2)

    def test_invalid_equals(self):
        assert not huml.EQUALS(1, "name")
        assert not huml.EQUALS("name", 1)
        assert huml.EQUALS(1, "1")

class TestComparisonsNotEqual:

    def test_not_equal_strings_and_numbers(self):
        assert huml.NOT_EQUALS("name", 1)
        assert huml.NOT_EQUALS(1.1, 1)
        assert huml.NOT_EQUALS("Name", "name")

    def test_rounding_errors(self):
        assert huml.NOT_EQUALS(math.pi, 3.14159265358979)

class TestComparisonsGreaterThan:

    def test_number_greater_than_number(self):
        assert huml.GREATER_THAN(1.1, 1)
        assert not huml.GREATER_THAN(1, 1.1)
        assert not huml.GREATER_THAN(1, 1)

    def test_rounding_errors(self):
        assert huml.GREATER_THAN(math.pi, 3.14159265358979)

    def test_number_greater_than_none(self):
        assert huml.GREATER_THAN(1, None)

    def test_char_greater_than_char(self):
        assert huml.GREATER_THAN("b", "a")
        assert not huml.GREATER_THAN("a", "b")

    def test_invalid_comparison(self):
        assert not huml.GREATER_THAN("name", 1)

class TestComparisonsLessOrEqual:

    def test_number_less_or_equal_number(self):
        assert not huml.LESS_OR_EQUALS(1.1, 1)
        assert huml.LESS_OR_EQUALS(1, 1.1)
        assert huml.LESS_OR_EQUALS(1, 1)

    def test_rounding_errors(self):
        assert not huml.LESS_OR_EQUALS(math.pi, 3.14159265358979)

    def test_number_less_or_equal_to_none(self):
        assert not huml.LESS_OR_EQUALS(1, None)

    def test_char_less_or_equal_char(self):
        assert not huml.LESS_OR_EQUALS("b", "a")
        assert huml.LESS_OR_EQUALS("a", "b")

    def test_invalid_comparison(self):
        assert not huml.LESS_OR_EQUALS("name", 1)

class TestComparisonsGreaterOrEquals:

    def test_number_greater_or_equal_number(self):
        assert huml.GREATER_OR_EQUALS(1.1, 1)
        assert huml.GREATER_OR_EQUALS(1, 1)
        assert not huml.GREATER_OR_EQUALS(1, 1.1)

    def test_char_greater_or_equal_char(self):
        assert huml.GREATER_OR_EQUALS("b", "a")
        assert not huml.GREATER_OR_EQUALS("a", "b")

    def test_rounding_errors(self):
        assert huml.GREATER_OR_EQUALS(math.pi, 3.14159265358979)

    def test_invalid_comparison(self):
        assert not huml.GREATER_OR_EQUALS("name", 1.1)

class TestComparisonsEmpty:

    def test_empty_none(self):
        assert huml.EMPTY(None)

    def test_empty_string(self):
        assert huml.EMPTY("")
        assert not huml.EMPTY("name")

    def test_empty_nan(self):
        assert huml.EMPTY(math.nan)

    def test_empty_number(self):
        assert not huml.EMPTY(-1)

    def test_empty_object(self):
        assert not huml.EMPTY(object())
