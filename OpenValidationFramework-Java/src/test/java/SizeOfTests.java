import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SizeOfTests {
    private HUMLFramework huml = new HUMLFramework();

    //arrays
    @Test
    void size_of_on_empty_array()
    {
        String[] input = new String[0];
        int result = huml.sizeOf(input);

        Assertions.assertEquals(input.length, result);
    }

    @Test
    void size_of_on_filled_array()
    {
        String[] input = {"a", "b", "c"};
        int result = huml.sizeOf(input);

        Assertions.assertEquals(input.length, result);
    }

    //lists
    @Test
    void size_of_on_empty_list()
    {
        List<String> input = new ArrayList<>();
        int result = huml.sizeOf(input);

        Assertions.assertEquals(input.size(), result);
    }

    @Test
    void size_of_on_filled_list()
    {
        List<String> input = new ArrayList<>(Arrays.asList("a", "b", "c"));
        int result = huml.sizeOf(input);

        Assertions.assertEquals(input.size(), result);
    }
}
