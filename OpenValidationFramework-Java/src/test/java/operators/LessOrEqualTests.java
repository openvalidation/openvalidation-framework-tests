package operators;

import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LessOrEqualTests {
    private HUMLFramework huml = new HUMLFramework();

    // int
    @ParameterizedTest
    @ValueSource(ints = {123, 124, Integer.MAX_VALUE})
    void int_int_expected_true(int other) {
        int input = 123;
        Assertions.assertTrue(huml.LESS_OR_EQUALS(input, other));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 122, -1, -123, Integer.MIN_VALUE})
    void int_int_expected_false(int other) {
        int input = 123;
        Assertions.assertFalse(huml.LESS_OR_EQUALS(input, other));
    }
    
    @ParameterizedTest
    @ValueSource(doubles = {123.00000, 123.000000000001, 123.1, 654.321, Double.MAX_VALUE})
    void int_double_expected_true(double other) {
        int input = 123;
        Assertions.assertTrue(huml.LESS_OR_EQUALS(input, other));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.00, 1.1, 122.0, 122.9999999, -1.1, -123.3, Double.MIN_VALUE})
    void int_double_expected_false(double other) {
        int input = 123;
        Assertions.assertFalse(huml.LESS_OR_EQUALS(input, other));
    }



    // double
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 123, Integer.MAX_VALUE})
    void double_int_expected_true(int other) {
        double input = 0.0;
        Assertions.assertTrue(huml.LESS_OR_EQUALS(input, other));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -123, Integer.MIN_VALUE})
    void double_int_expected_false(int other) {
        double input = 0.0;
        Assertions.assertFalse(huml.LESS_OR_EQUALS(input, other));
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.5, 0.5, 0.0000001, Double.MIN_NORMAL, 0.00})
    void double_double_expected_true(double other) {
        double input = 0.0;
        Assertions.assertTrue(huml.LESS_OR_EQUALS(input, other));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.5, -0.5, -0.0000001, -Double.MIN_NORMAL})
    void double_double_expected_false(double other) {
        double input = 0.0;
        Assertions.assertFalse(huml.LESS_OR_EQUALS(input, other));
    }
}
