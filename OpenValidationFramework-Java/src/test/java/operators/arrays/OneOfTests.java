package operators.arrays;

import com.sun.org.apache.xpath.internal.objects.XNumber;
import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;


// ONE_OF is being phased out in favour of EXACTLY_ONE_OF
public class OneOfTests {
    //ONE OF
    @Test
    public void string_should_not_be_one_of_list() {
        HUMLFramework huml = new HUMLFramework();
        String input_left = "Franz";
        String[] input_right = {"Heins", "Jens", "Peter", "Klaus", "Helmut"};
        Assertions.assertFalse(huml.ONE_OF(input_left, input_right));
    }

    @Test
    public void string_should_be_one_of_list() {
        HUMLFramework huml = new HUMLFramework();
        String input_left = "Franz";
        String[] input_right = {"Heins", "Jens", "Franz", "Peter", "Klaus", "Helmut"};
        Assertions.assertTrue(huml.ONE_OF(input_left, input_right));
    }

    //todo lazevedo 16.9.19 what si the expected behaviour. in my opinion it should be semantically "exactly
    // one of" since the HUMLFramework contains a method called explicitly "AT_LEAST_ONE_OF"
    @Disabled
    @Test
    public void string_should_be_one_of_list_with_more_than_one_match() {
        HUMLFramework huml = new HUMLFramework();
        String input_left = "Franz";
        String[] input_right = {"Heins", "Jens", "Franz", "Franz", "Peter", "Klaus", "Helmut"};
        Assertions.assertFalse(huml.ONE_OF(input_left, input_right));
    }

    @Test
    public void string_should_not_be_one_of_list_inline() {
        HUMLFramework huml = new HUMLFramework();
        String input_left = "Franz";
        Assertions.assertFalse(huml.ONE_OF(input_left, "Heins", "Jens", "Peter", "Klaus", "Helmut"));
    }

    @Test
    public void string_should_be_one_of_list_inline() {
        HUMLFramework huml = new HUMLFramework();
        String input_left = "Franz";
        Assertions.assertTrue(huml.ONE_OF(input_left, "Heins", "Jens", "Franz", "Peter", "Klaus", "Helmut"));
    }

    @Test
    public void string_should_not_be_one_of_list_inline_as_list() {
        HUMLFramework huml = new HUMLFramework();
        String input_left = "Franz";
        Assertions.assertFalse(huml.ONE_OF(input_left, Arrays.asList("Heins", "Jens", "Peter", "Klaus", "Helmut")));
    }

    @Test
    public void string_should_be_one_of_list_inline_as_list() {
        HUMLFramework huml = new HUMLFramework();
        String input_left = "Franz";
        Assertions.assertTrue(huml.ONE_OF(input_left, Arrays.asList("Heins", "Jens", "Franz", "Peter", "Klaus", "Helmut")));
    }

    //todo lazevedo 16.9.19 what is the expected behaviour. in my opinion it should be semantically "exactly
    // one of" since the HUMLFramework contains a method called explicitly "AT_LEAST_ONE_OF"
    @Disabled
    @Test
    public void string_should_be_one_of_list_inline_with_more_than_one_match() {
        HUMLFramework huml = new HUMLFramework();
        String input_left = "Franz";
        Assertions.assertFalse(huml.ONE_OF(input_left, "Heins", "Jens", "Franz", "Franz", "Peter", "Klaus", "Helmut"));
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
        HUMLFramework huml = new HUMLFramework();
        Assertions.assertTrue(huml.ONE_OF(input_left, 1,2,3));
        Assertions.assertFalse(huml.ONE_OF(input_left, 2,3,4));
        Assertions.assertTrue(huml.ONE_OF(input_left, Arrays.asList(1,2,3)));
        Assertions.assertFalse(huml.ONE_OF(input_left, Arrays.asList(2,3,4)));
        Assertions.assertFalse(huml.ONE_OF(input_left, new int[]{}));
        Assertions.assertFalse(huml.ONE_OF(input_left, Collections.emptyList()));

        //double
        Assertions.assertTrue(huml.ONE_OF(input_left, 1.0, 2.0, 3.0));
        Assertions.assertFalse(huml.ONE_OF(input_left, 2.0, 3.0, 4.0));
        Assertions.assertTrue(huml.ONE_OF(input_left, Arrays.asList(1.0, 2.0, 3.0)));
        Assertions.assertFalse(huml.ONE_OF(input_left, Arrays.asList(2.0, 3.0, 4.0)));
        Assertions.assertFalse(huml.ONE_OF(input_left, new double[]{}));
        Assertions.assertFalse(huml.ONE_OF(input_left, Collections.emptyList()));
    }

}
