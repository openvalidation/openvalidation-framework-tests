import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class atPositionTests {
    private HUMLFramework huml = new HUMLFramework();

    //arrays
    @Test
    void array_atPostion_empty_array()
    {
        String[] input = new String[0];
        String result = huml.atPosition(input, 0);

        Assertions.assertNull(result);
        //Assertions.assertEquals(input.length, result);
    }

    @Test
    void array_atPosition_0_equals_a()
    {
        String[] input = {"a", "b", "c"};
        String result = huml.atPosition(input, 0);

        Assertions.assertEquals(result, input[0]);
    }

    @Test
    void array_atPosition_1_equals_b()
    {
        String[] input = {"a", "b", "c"};
        String result = huml.atPosition(input, 1);

        Assertions.assertEquals(result, input[1]);
    }

    @Test
    void array_atPosition_2_equals_c()
    {
        String[] input = {"a", "b", "c"};
        String result = huml.atPosition(input, 2);

        Assertions.assertEquals(result, input[2]);
    }

    //lists
    @Test
    void list_atPostion_empty_array()
    {
        List<String> input = Arrays.asList();
        String result = huml.atPosition(input, 0);

        Assertions.assertNull(result);
        //Assertions.assertEquals(input.length, result);
    }

    @Test
    void list_atPosition_0_equals_a()
    {
        List<String> input = Arrays.asList("a", "b", "c");
        String result = huml.atPosition(input, 0);

        Assertions.assertEquals(result, input.get(0));
    }

    @Test
    void list_atPosition_1_equals_b()
    {
        List<String> input = Arrays.asList("a", "b", "c");
        String result = huml.atPosition(input, 1);

        Assertions.assertEquals(result, input.get(1));
    }

    @Test
    void list_atPosition_2_equals_c()
    {
        List<String> input = Arrays.asList("a", "b", "c");
        String result = huml.atPosition(input, 2);

        Assertions.assertEquals(result, input.get(2));
    }
}
