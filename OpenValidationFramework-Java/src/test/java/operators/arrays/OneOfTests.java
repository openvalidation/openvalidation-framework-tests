package operators.arrays;

import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import util.GenericVariable;

import java.util.Arrays;
import java.util.Collections;


// ONE_OF is being phased out in favour of EXACTLY_ONE_OF
public class OneOfTests {

    HUMLFramework huml = new HUMLFramework();

    //ONE OF
    @Test
    public void string_should_not_be_one_of_list() {
        String input_left = "Franz";
        String[] input_right = {"Heins", "Jens", "Peter", "Klaus", "Helmut"};
        Assertions.assertFalse(huml.ONE_OF(input_left, input_right));
    }

    @Test
    public void string_should_be_one_of_list() {
        String input_left = "Franz";
        String[] input_right = {"Heins", "Jens", "Franz", "Peter", "Klaus", "Helmut"};
        Assertions.assertTrue(huml.ONE_OF(input_left, input_right));
    }

    //todo lazevedo 16.9.19 what si the expected behaviour. in my opinion it should be semantically "exactly
    // one of" since the HUMLFramework contains a method called explicitly "AT_LEAST_ONE_OF"
    @Disabled
    @Test
    public void string_should_be_one_of_list_with_more_than_one_match() {
        String input_left = "Franz";
        String[] input_right = {"Heins", "Jens", "Franz", "Franz", "Peter", "Klaus", "Helmut"};
        Assertions.assertFalse(huml.ONE_OF(input_left, input_right));
    }

    @Test
    public void string_should_not_be_one_of_list_inline() {
        String input_left = "Franz";
        Assertions.assertFalse(huml.ONE_OF(input_left, huml.CREATE_ARRAY("Heins", "Jens", "Peter", "Klaus", "Helmut")));
    }

    @Test
    public void string_should_be_one_of_list_inline() {
        String input_left = "Franz";
        Assertions.assertTrue(huml.ONE_OF(input_left, huml.CREATE_ARRAY("Heins", "Jens", "Franz", "Peter", "Klaus", "Helmut")));
    }

    @Test
    public void string_should_not_be_one_of_list_inline_as_list() {
        String input_left = "Franz";
        Assertions.assertFalse(huml.ONE_OF(input_left, Arrays.asList("Heins", "Jens", "Peter", "Klaus", "Helmut")));
    }

    @Test
    public void string_should_be_one_of_list_inline_as_list() {
        String input_left = "Franz";
        Assertions.assertTrue(huml.ONE_OF(input_left, Arrays.asList("Heins", "Jens", "Franz", "Peter", "Klaus", "Helmut")));
    }

    //todo lazevedo 16.9.19 what is the expected behaviour. in my opinion it should be semantically "exactly
    // one of" since the HUMLFramework contains a method called explicitly "AT_LEAST_ONE_OF"
    @Disabled
    @Test
    public void string_should_be_one_of_list_inline_with_more_than_one_match() {

        String input_left = "Franz";
        Assertions.assertFalse(huml.ONE_OF(input_left, huml.CREATE_ARRAY("Heins", "Jens", "Franz", "Franz", "Peter", "Klaus", "Helmut")));
    }

    @Test
    public void one_of_with_generic_variable_array()
    {
        Object objectStringA = "a";
        Object objectStringZ = "z";

        GenericVariable var = new GenericVariable(new String[]{"a", "b", "c"});

        Assertions.assertTrue(huml.ONE_OF("a", var.getValue()));
        Assertions.assertFalse(huml.ONE_OF("z", var.getValue()));

        Assertions.assertTrue(huml.ONE_OF(objectStringA, var.getValue()));
        Assertions.assertFalse(huml.ONE_OF(objectStringZ, var.getValue()));
    }

    @Test
    public void one_of_with_generic_variable_list()
    {
        Object objectStringA = "a";
        Object objectStringZ = "z";

        GenericVariable var = new GenericVariable(Arrays.asList("a", "b"," c"));

        Assertions.assertTrue(huml.ONE_OF("a", var.getValue()));
        Assertions.assertFalse(huml.ONE_OF("z", var.getValue()));

        Assertions.assertTrue(huml.ONE_OF(objectStringA, var.getValue()));
        Assertions.assertFalse(huml.ONE_OF(objectStringZ, var.getValue()));
    }

    @Test
    public void test_oneOf_with_int()
    {
        int num = 1;
        test_suite(num);
    }

    @Test
    public void test_oneOf_with_double()
    {
        double num = 1.0;
        test_suite(num);
    }

    private void test_suite(Number input_left)
    {
        //int
        Assertions.assertTrue(huml.ONE_OF(input_left, huml.CREATE_ARRAY(1,2,3)));
        Assertions.assertFalse(huml.ONE_OF(input_left, huml.CREATE_ARRAY(2,3,4)));
        Assertions.assertTrue(huml.ONE_OF(input_left, Arrays.asList(1,2,3)));
        Assertions.assertFalse(huml.ONE_OF(input_left, Arrays.asList(2,3,4)));
        Assertions.assertFalse(huml.ONE_OF(input_left, new int[]{}));
        Assertions.assertFalse(huml.ONE_OF(input_left, Collections.emptyList()));

        //double
        Assertions.assertTrue(huml.ONE_OF(input_left, huml.CREATE_ARRAY(1.0, 2.0, 3.0)));
        Assertions.assertFalse(huml.ONE_OF(input_left, huml.CREATE_ARRAY(2.0, 3.0, 4.0)));
        Assertions.assertTrue(huml.ONE_OF(input_left, Arrays.asList(1.0, 2.0, 3.0)));
        Assertions.assertFalse(huml.ONE_OF(input_left, Arrays.asList(2.0, 3.0, 4.0)));
        Assertions.assertFalse(huml.ONE_OF(input_left, new double[]{}));
        Assertions.assertFalse(huml.ONE_OF(input_left, Collections.emptyList()));
    }

}
