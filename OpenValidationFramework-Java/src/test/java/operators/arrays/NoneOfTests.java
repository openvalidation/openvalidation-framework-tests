package operators.arrays;

import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.GenericVariable;

import java.util.Arrays;

public class NoneOfTests {
    private HUMLFramework huml = new HUMLFramework();

    //none of
    @Test
    public void string_should_be_none_of_list() {
        String input_left = "Jerry";
        String[] input_right = {"Heins", "Jens", "Franz", "Peter", "Klaus", "Helmut"};
        Assertions.assertTrue(huml.NONE_OF(input_left, input_right));
    }

    @Test
    public void string_should_not_be_none_of_list() {
        String input_left = "Jerry";
        String[] input_right = {"Heins", "Jens", "Franz", "Jerry", "Peter", "Klaus", "Helmut"};
        Assertions.assertFalse(huml.NONE_OF(input_left, input_right));
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.000000000001, 0.999999999999, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL, Double.MIN_NORMAL})//, 123 + Double.MIN_NORMAL})
    public void number_should_be_none_of_generic_variable_array_with_numbers_1(double x) {
        GenericVariable array = new GenericVariable(huml.CREATE_ARRAY(1.0, 2.0, 3.0));
        Assertions.assertTrue(huml.NONE_OF(x, array.getValue()));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, Integer.MAX_VALUE, Integer.MIN_VALUE})//, 123 + Double.MIN_NORMAL})
    public void number_should_be_none_of_generic_variable_array_with_numbers_2(int x) {
        GenericVariable array = new GenericVariable(huml.CREATE_ARRAY(-0.000000000001, 0.000000000001, 0.999999999999, 1.000000000001));
        Assertions.assertTrue(huml.NONE_OF(x, array.getValue()));
    }

    @Test
    public void none_of_with_generic_variable_array()
    {
        Object objectStringA = "a";
        Object objectStringZ = "z";

        GenericVariable var = new GenericVariable(new String[]{"a", "b", "c"});

        Assertions.assertTrue(huml.NONE_OF("z", var.getValue()));
        Assertions.assertFalse(huml.NONE_OF("a", var.getValue()));

        Assertions.assertTrue(huml.NONE_OF(objectStringZ, var.getValue()));
        Assertions.assertFalse(huml.NONE_OF(objectStringA, var.getValue()));
    }

    @Test
    public void none_of_with_generic_variable_list()
    {
        Object objectStringA = "a";
        Object objectStringZ = "z";

        GenericVariable var = new GenericVariable(Arrays.asList("a", "b"," c"));

        Assertions.assertTrue(huml.NONE_OF("z", var.getValue()));
        Assertions.assertFalse(huml.NONE_OF("a", var.getValue()));

        Assertions.assertTrue(huml.NONE_OF(objectStringZ, var.getValue()));
        Assertions.assertFalse(huml.NONE_OF(objectStringA, var.getValue()));
    }
}
