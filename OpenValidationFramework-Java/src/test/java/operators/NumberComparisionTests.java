package operators;

import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberComparisionTests {
    //LESS THAN

    @ParameterizedTest
    @ValueSource(doubles = {
            1.1, 2.0, 2.2, 3.0, 3.5, 6.0, 1000.1, Double.MAX_VALUE
    })
    void input_double_should_not_be_less_int_1(double input_left) {
        HUMLFramework huml = new HUMLFramework();
        int input_right = 1;
        Assertions.assertFalse(huml.LESS_THAN(input_left, input_right));
    }

    @ParameterizedTest
    @ValueSource(doubles = {
            0.9, 0.0, -1.0, -2.2, -5.5, Double.MIN_VALUE
    })
    void input_double_should_be_less_int_1(double input_left) {
        HUMLFramework huml = new HUMLFramework();
        int input_right = 1;
        Assertions.assertTrue(huml.LESS_THAN(input_left, input_right));
    }

    @ParameterizedTest
    @ValueSource(ints = {
            1, 2, 3, 8, 24, 42, Integer.MAX_VALUE
    })
    void input_int_should_not_be_less_int_1(double input_left) {
        HUMLFramework huml = new HUMLFramework();
        int input_right = 1;
        Assertions.assertFalse(huml.LESS_THAN(input_left, input_right));
    }

    @ParameterizedTest
    @ValueSource(ints = {
            0, -1, -5, -8, -24, -42, -555, -1111, -11011, -1234567, Integer.MIN_VALUE
    })
    void input_int_should_be_less_int_1(double input_left) {
        HUMLFramework huml = new HUMLFramework();
        int input_right = 1;
        Assertions.assertTrue(huml.LESS_THAN(input_left, input_right));
    }

    @Test
    public void string_less_than_int_should_be_false() {
        HUMLFramework huml = new HUMLFramework();
        String input_left = "name";
        int input_right = 1;
        Assertions.assertThrows(java.lang.ClassCastException.class, () -> huml.LESS_THAN(input_left, input_right));
    }

    //GREATER THAN

    @ParameterizedTest
    @ValueSource(ints = {
            0, -1, -5, -8, -24, -42, -555, -1111, -11011, -1234567, Integer.MIN_VALUE
    })
    void input_int_should_not_be_greater_int_1(double input_left) {
        HUMLFramework huml = new HUMLFramework();
        int input_right = 1;
        Assertions.assertFalse(huml.GREATER_THAN(input_left, input_right));
    }

    @ParameterizedTest
    @ValueSource(ints = {
            2, 3, 8, 24, 42, Integer.MAX_VALUE
    })
    void input_int_should_be_greater_int_1(double input_left) {
        HUMLFramework huml = new HUMLFramework();
        int input_right = 1;
        Assertions.assertTrue(huml.GREATER_THAN(input_left, input_right));
    }

    //LESS OR EQUALS

    @ParameterizedTest
    @ValueSource(ints = {
            1, 0, -1, -5, -8, -24, -42, -555, -1111, -11011, -1234567, Integer.MIN_VALUE
    })
    void input_int_should_be_less_or_equal_int_1(double input_left) {
        HUMLFramework huml = new HUMLFramework();
        int input_right = 1;
        Assertions.assertTrue(huml.LESS_OR_EQUALS(input_left, input_right));
    }

    @ParameterizedTest
    @ValueSource(ints = {
            2, 3, 8, 24, 42, Integer.MAX_VALUE
    })
    void input_int_should_not_be_less_or_equal_int_1(double input_left) {
        HUMLFramework huml = new HUMLFramework();
        int input_right = 1;
        Assertions.assertFalse(huml.LESS_OR_EQUALS(input_left, input_right));
    }

    //GREATER OR EQUAL
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2, 3, 8, 24, 42, Integer.MAX_VALUE
    })
    void input_int_should_be_greater_or_equal_int_1(double input_left) {
        HUMLFramework huml = new HUMLFramework();
        int input_right = 1;
        Assertions.assertTrue(huml.GREATER_OR_EQUALS(input_left, input_right));
    }

    @ParameterizedTest
    @ValueSource(ints = {
            0, -1, -5, -8, -24, -42, -555, -1111, -11011, -1234567, Integer.MIN_VALUE
    })
    void input_int_should_not_be_greater_or_equal_int_1(double input_left) {
        HUMLFramework huml = new HUMLFramework();
        int input_right = 1;
        Assertions.assertTrue(huml.LESS_OR_EQUALS(input_left, input_right));
    }
}
