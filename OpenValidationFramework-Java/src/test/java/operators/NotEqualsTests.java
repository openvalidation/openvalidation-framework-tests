package operators;

import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NotEqualsTests {
    // NOT_EQUALS
    private HUMLFramework huml = new HUMLFramework();

    // string
    @Test
    void string_name_should_not_be_name() {
        String input = "name";
        Assertions.assertFalse(huml.NOT_EQUALS(input, "name"));
    }

    @Test
    void string_name_should_be_name() {
        String input = "name";
        Assertions.assertTrue(huml.NOT_EQUALS(input, "not name"));
    }

    // int
    @ParameterizedTest
    @ValueSource(ints = {123})
    void int_int_expected_false(int other) {
        int input = 123;
        Assertions.assertFalse(huml.NOT_EQUALS(input, other));
    }

    @ParameterizedTest
    @ValueSource(doubles = {123.0, 123.000000})
    void int_double_expected_false(double other) {
        int input = 123;
        Assertions.assertFalse(huml.NOT_EQUALS(input, other));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, -1, -123, Integer.MAX_VALUE, Integer.MIN_VALUE})
    void int_int_expected_true(int other) {
        int input = 123;
        Assertions.assertTrue(huml.NOT_EQUALS(input, other));
    }

    @ParameterizedTest
    @ValueSource(doubles = {123.000000000001, 122.999999999999, -123.000001, -122.99999, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL})//, 123 + Double.MIN_NORMAL})
    void int_double_expected_true(double other) {
        int input = 123;
        Assertions.assertTrue(huml.NOT_EQUALS(input, other));
    }


    // double
    @ParameterizedTest
    @ValueSource(ints = {0})
    void double_int_expected_false(int other) {
        double input = 0.0;
        Assertions.assertFalse(huml.NOT_EQUALS(input, other));
    }
    
    @ParameterizedTest
    @ValueSource(doubles = {0.0, 0.0000000000000000})
    void double_double_expected_false(double other) {
        double input = 0.0;
        Assertions.assertFalse(huml.NOT_EQUALS(input, other));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, -1, -123, Integer.MAX_VALUE, Integer.MIN_VALUE})
    void double_int_expected_true(int other) {
        double input = 0.0;
        Assertions.assertTrue(huml.NOT_EQUALS(input, other));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.000000000001, -0.000000000001, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL, Double.MIN_NORMAL})//, 123 + Double.MIN_NORMAL})
    void double_double_expected_true(double other) {
        double input = 0.0;
        Assertions.assertTrue(huml.NOT_EQUALS(input, other));
    }
}
