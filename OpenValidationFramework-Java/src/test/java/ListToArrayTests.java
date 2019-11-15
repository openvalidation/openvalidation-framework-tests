import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.bag.openvalidation.HUMLFramework.listToArray;

public class ListToArrayTests {
    HUMLFramework huml = new HUMLFramework();

    @Test
    void list_to_array_with_empty_list()
    {
        List<String> input = new ArrayList<>();
        String[] result = listToArray(input);

        Assertions.assertNull(result);
    }

    @Test
    void list_to_array_with_simple_list()
    {
        List<String> input = new ArrayList<>(Arrays.asList("Alice", "Bob", "Carl"));
        String[] result = listToArray(input);

        Assertions.assertEquals("Alice", result[0]);
        Assertions.assertEquals("Bob", result[1]);
        Assertions.assertEquals("Carl", result[2]);
    }

    @Test
    void list_to_array_with_simple_list_retains_order_of_elements()
    {
        String[] inputArray = {"Hello", "World!", "How", "Are", "You", "Doing"
                , "Today?", "I", "Hope", "You're", "Doing", "Great!"};
        List<String> input = new ArrayList<>(Arrays.asList(inputArray));
        String[] result = listToArray(input);

        for(int i = 0; i< inputArray.length; i++)
        {
            //assert that "asList" does nto change order
            Assertions.assertEquals(inputArray[i], input.get(i));
            //actual part we want to test
            Assertions.assertEquals(input.get(i), result[i]);
        }
    }
}
