package operators.arrays;

import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
