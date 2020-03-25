package operators.arrays;

import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AtLeastOneOfTests {
    private HUMLFramework huml = new HUMLFramework();

    @Test
    public void string_should_be_at_least_one_of_list_with_one_match() {
        String input_left = "Jerry";
        String[] input_right = {"Heins", "Jens", "Franz", "Peter", "Klaus", "Helmut", "Jerry", "Franz", "Berry"};
        Assertions.assertTrue(huml.AT_LEAST_ONE_OF(input_left, input_right));
    }

    @Test
    public void string_should_be_at_least_one_of_list_with_duplicates() {
        String input_left = "Jerry";
        String[] input_right = {"Heins", "Jens", "Franz", "Peter", "Klaus", "Helmut", "Jerry", "Jerry", "Franz", "Jerry", "Berry"};
        Assertions.assertTrue(huml.AT_LEAST_ONE_OF(input_left, input_right));
    }


    @Test
    public void string_should_not_be_at_least_one_of_list() {
        String input_left = "Mary";
        String[] input_right = {"Heins", "Jens", "Franz", "Peter", "Klaus", "Helmut", "Jerry", "Franz", "Berry"};
        Assertions.assertFalse(huml.AT_LEAST_ONE_OF(input_left, input_right));
    }

    @Test
    public void string_should_not_be_at_least_one_of_list_with_duplicates() {
        String input_left = "Mary";
        String[] input_right = {"Heins", "Jens", "Franz", "Peter", "Klaus", "Helmut", "Jerry", "Jerry", "Franz", "Jerry", "Berry"};
        Assertions.assertFalse(huml.AT_LEAST_ONE_OF(input_left, input_right));
    }

    @Test
    public void string_should_not_be_at_least_one_of_list_with_duplicates_static() {
        String input_left = "Mary";
        Assertions.assertFalse(huml.AT_LEAST_ONE_OF(input_left, huml.CREATE_ARRAY("Heins", "Jens", "Franz", "Peter", "Klaus", "Helmut", "Jerry", "Jerry", "Franz", "Jerry", "Berry")));
    }

    @Test
    public void string_should_not_be_at_least_one_of_list_with_duplicates_list() {
        String input_left = "Mary";
        List<String> input_right = new ArrayList<String>(Arrays.asList("Heins", "Jens", "Franz", "Peter", "Klaus", "Helmut", "Jerry", "Jerry", "Franz", "Jerry", "Berry"));
        Assertions.assertFalse(huml.AT_LEAST_ONE_OF(input_left, input_right));
    }

    @Test
    public void string_should_be_at_least_one_of_list_with_duplicates_list() {
        String input_left = "Mary";
        List<String> input_right = new ArrayList<>(Arrays.asList("Heins", "Jens", "Franz", "Peter", "Klaus", "Helmut", "Mary", "Jerry", "Jerry", "Franz", "Jerry", "Berry"));
        Assertions.assertTrue(huml.AT_LEAST_ONE_OF(input_left, input_right));
    }
}
