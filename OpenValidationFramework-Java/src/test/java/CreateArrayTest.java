import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateArrayTest
{
   HUMLFramework huml = new HUMLFramework();

   @Test
   public void simple_create_array_with_strings()
   {
      String[] strings = huml.CREATE_ARRAY("Berlin", "Paris", "London");

      Assertions.assertEquals(strings.length, 3);
      Assertions.assertEquals(strings[0], "Berlin");
      Assertions.assertEquals(strings[1], "Paris");
      Assertions.assertEquals(strings[2], "London");
   }

   @Test
   public void simple_create_array_with_numbers()
   {
      Number[] numbers = huml.CREATE_ARRAY(-1, 0, 3.1415);

      Assertions.assertEquals(numbers.length, 3);
      Assertions.assertEquals(numbers[0], -1);
      Assertions.assertEquals(numbers[1], 0);
      Assertions.assertEquals(numbers[2], 3.1415);
   }
}
