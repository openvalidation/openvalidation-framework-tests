package operators.arrays;

import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

    //todo lazevedo 16.9.19 what is the expected behaviour. in my opinion it should be semantically "exactly
    // one of" since the HUMLFramework contains a method called explicitly "AT_LEAST_ONE_OF"
    @Disabled
    @Test
    public void string_should_be_one_of_list_inline_with_more_than_one_match() {
        HUMLFramework huml = new HUMLFramework();
        String input_left = "Franz";
        Assertions.assertFalse(huml.ONE_OF(input_left, "Heins", "Jens", "Franz", "Franz", "Peter", "Klaus", "Helmut"));
    }

    //with numerical values
    //int
    //int -> int
    @Test
    public void number_int_should_be_one_of_list_of_type_int() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertTrue(huml.ONE_OF(input_left, 1,2,3));
    }

    @Test
    public void number_int_should_not_be_one_of_list_of_type_int() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertFalse(huml.ONE_OF(input_left, 2,3,4));
    }

    @Test
    public void number_int_should_be_one_of_list_of_type_int_as_list() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertTrue(huml.ONE_OF(input_left, Arrays.asList(1,2,3)));
    }

    @Test
    public void number_int_should_not_be_one_of_list_of_type_int_as_list() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertFalse(huml.ONE_OF(input_left, Arrays.asList(2,3,4)));
    }

    //int -> Integer
    @Test
    public void number_int_should_be_one_of_list_of_type_integer() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertTrue(huml.ONE_OF(input_left, new Integer(1), new Integer(3), new Integer(4)));
    }

    @Test
    public void number_int_should_not_be_one_of_list_of_type_integer() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertFalse(huml.ONE_OF(input_left, new Integer(2), new Integer(3), new Integer(4)));
    }

    @Test
    public void number_int_should_be_one_of_list_of_type_integer_as_list() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertTrue(huml.ONE_OF(input_left, Arrays.asList(new Integer(1), new Integer(3), new Integer(4))));
    }

    @Test
    public void number_int_should_not_be_one_of_list_of_type_integer_as_list() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertFalse(huml.ONE_OF(input_left,Arrays.asList( new Integer(2), new Integer(3), new Integer(4))));
    }

    //int -> double
    @Test
    public void number_int_should_be_one_of_list_of_type_double() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertTrue(huml.ONE_OF(input_left, 1.0, 2.0, 3.0));
    }

    @Test
    public void number_int_should_not_be_one_of_list_of_type_double() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertFalse(huml.ONE_OF(input_left, 2.0, 3.0, 4.0));
    }

    @Test
    public void number_int_should_be_one_of_list_of_type_double_as_list() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertTrue(huml.ONE_OF(input_left, Arrays.asList(1.0, 2.0, 3.0)));
    }

    @Test
    public void number_int_should_not_be_one_of_list_of_type_double_as_list() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertFalse(huml.ONE_OF(input_left, Arrays.asList(2.0, 3.0, 4.0)));
    }

    //int -> Double
    @Test
    public void number_int_should_be_one_of_list_of_type_Double() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertTrue(huml.ONE_OF(input_left, new Double(1), new Double(3), new Double(4)));
    }

    @Test
    public void number_int_should_not_be_one_of_list_of_type_Double() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertFalse(huml.ONE_OF(input_left, new Double(2), new Double(3), new Double(4)));
    }

    @Test
    public void number_int_should_be_one_of_list_of_type_Double_as_list() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertTrue(huml.ONE_OF(input_left, Arrays.asList(new Double(1), new Double(3), new Double(4))));
    }

    @Test
    public void number_int_should_not_be_one_of_list_of_type_Double_as_list() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertFalse(huml.ONE_OF(input_left, Arrays.asList(new Double(2), new Double(3), new Double(4))));
    }

    //int -> Number
    @Test
    public void number_int_should_be_one_of_list_of_type_number() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertTrue(huml.ONE_OF(input_left, (Number)1, (Number)2, (Number)3));
    }

    @Test
    public void number_int_should_not_be_one_of_list_of_type_number() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertFalse(huml.ONE_OF(input_left, (Number)2, (Number)3, (Number)4));
    }

    @Test
    public void number_int_should_be_one_of_list_of_type_number_as_list() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertTrue(huml.ONE_OF(input_left, Arrays.asList((Number)1, (Number)2, (Number)3)));
    }

    @Test
    public void number_int_should_not_be_one_of_list_of_type_number_as_list() {
        HUMLFramework huml = new HUMLFramework();
        int input_left = 1;
        Assertions.assertFalse(huml.ONE_OF(input_left, Arrays.asList((Number)2, (Number)3, (Number)4)));
    }

    
    //Integer
    //Integer -> int
    @Test
    public void number_integer_should_be_one_of_list_of_type_int() {
        HUMLFramework huml = new HUMLFramework();
        Integer input_left = new Integer(1);
        Assertions.assertTrue(huml.ONE_OF(input_left, 1,2,3));
    }

    @Test
    public void number_integer_should_not_be_one_of_list_of_type_int() {
        HUMLFramework huml = new HUMLFramework();
        Integer input_left = new Integer(1);
        Assertions.assertFalse(huml.ONE_OF(input_left, 2,3,4));
    }

    //Integer -> Integer
    @Test
    public void number_integer_should_be_one_of_list_of_type_integer() {
        HUMLFramework huml = new HUMLFramework();
        Integer input_left = new Integer(1);
        Assertions.assertTrue(huml.ONE_OF(input_left, new Integer(1), new Integer(3), new Integer(4)));
    }

    @Test
    public void number_integer_should_not_be_one_of_list_of_type_integer() {
        HUMLFramework huml = new HUMLFramework();
        Integer input_left = new Integer(1);
        Assertions.assertFalse(huml.ONE_OF(input_left, new Integer(2), new Integer(3), new Integer(4)));
    }

    //Integer -> double
    @Test
    public void number_integer_should_be_one_of_list_of_type_double() {
        HUMLFramework huml = new HUMLFramework();
        Integer input_left = new Integer(1);
        Assertions.assertTrue(huml.ONE_OF(input_left, 1.0, 2.0, 3.0));
    }

    @Test
    public void number_integer_should_not_be_one_of_list_of_type_double() {
        HUMLFramework huml = new HUMLFramework();
        Integer input_left = new Integer(1);
        Assertions.assertFalse(huml.ONE_OF(input_left, 2.0, 3.0, 4.0));
    }

    //Integer -> Double
    @Test
    public void number_integer_should_be_one_of_list_of_type_Double() {
        HUMLFramework huml = new HUMLFramework();
        Integer input_left = new Integer(1);
        Assertions.assertTrue(huml.ONE_OF(input_left, new Double(1), new Double(3), new Double(4)));
    }

    @Test
    public void number_integer_should_not_be_one_of_list_of_type_Double() {
        HUMLFramework huml = new HUMLFramework();
        Integer input_left = new Integer(1);
        Assertions.assertFalse(huml.ONE_OF(input_left, new Double(2), new Double(3), new Double(4)));
    }

    //Integer -> Number
    @Test
    public void number_integer_should_be_one_of_list_of_type_number() {
        HUMLFramework huml = new HUMLFramework();
        Integer input_left = new Integer(1);
        Assertions.assertTrue(huml.ONE_OF(input_left, (Number)1, (Number)2, (Number)3));
    }

    //Integer -> Number
    @Test
    public void number_integer_should_not_be_one_of_list_of_type_number() {
        HUMLFramework huml = new HUMLFramework();
        Integer input_left = new Integer(1);
        Assertions.assertFalse(huml.ONE_OF(input_left, (Number)2, (Number)3, (Number)4));
    }
    
    //double
    //double -> int
    @Test
    public void number_double_should_be_one_of_list_of_type_int() {
        HUMLFramework huml = new HUMLFramework();
        double input_left = 1.0;
        Assertions.assertTrue(huml.ONE_OF(input_left, 1,2,3));
    }

    @Test
    public void number_double_should_not_be_one_of_list_of_type_int() {
        HUMLFramework huml = new HUMLFramework();
        double input_left = 1.0;
        Assertions.assertFalse(huml.ONE_OF(input_left, 2,3,4));
    }

    //double -> Integer
    @Test
    public void number_double_should_be_one_of_list_of_type_integer() {
        HUMLFramework huml = new HUMLFramework();
        double input_left = 1.0;
        Assertions.assertTrue(huml.ONE_OF(input_left, new Integer(1), new Integer(3), new Integer(4)));
    }

    @Test
    public void number_double_should_not_be_one_of_list_of_type_integer() {
        HUMLFramework huml = new HUMLFramework();
        double input_left = 1.0;
        Assertions.assertFalse(huml.ONE_OF(input_left, new Integer(2), new Integer(3), new Integer(4)));
    }

    //double -> double
    @Test
    public void number_double_should_be_one_of_list_of_type_double() {
        HUMLFramework huml = new HUMLFramework();
        double input_left = 1.0;
        Assertions.assertTrue(huml.ONE_OF(input_left, 1.0, 2.0, 3.0));
    }

    @Test
    public void number_double_should_not_be_one_of_list_of_type_double() {
        HUMLFramework huml = new HUMLFramework();
        double input_left = 1.0;
        Assertions.assertFalse(huml.ONE_OF(input_left, 2.0, 3.0, 4.0));
    }

    //double -> Double
    @Test
    public void number_double_should_be_one_of_list_of_type_Double() {
        HUMLFramework huml = new HUMLFramework();
        double input_left = 1.0;
        Assertions.assertTrue(huml.ONE_OF(input_left, new Double(1), new Double(3), new Double(4)));
    }

    @Test
    public void number_double_should_not_be_one_of_list_of_type_Double() {
        HUMLFramework huml = new HUMLFramework();
        double input_left = 1.0;
        Assertions.assertFalse(huml.ONE_OF(input_left, new Double(2), new Double(3), new Double(4)));
    }

    //double -> Number
    @Test
    public void number_double_should_be_one_of_list_of_type_number() {
        HUMLFramework huml = new HUMLFramework();
        double input_left = 1.0;
        Assertions.assertTrue(huml.ONE_OF(input_left, (Number)1, (Number)2, (Number)3));
    }

    //double -> Number
    @Test
    public void number_double_should_not_be_one_of_list_of_type_number() {
        HUMLFramework huml = new HUMLFramework();
        double input_left = 1.0;
        Assertions.assertFalse(huml.ONE_OF(input_left, (Number)2, (Number)3, (Number)4));
    }
    
    //Double
    //Double -> int
    @Test
    public void numbe_Double_should_be_one_of_list_of_type_int() {
        HUMLFramework huml = new HUMLFramework();
        Double input_left = new Double(1.0);
        Assertions.assertTrue(huml.ONE_OF(input_left, 1,2,3));
    }

    @Test
    public void numbe_Double_should_not_be_one_of_list_of_type_int() {
        HUMLFramework huml = new HUMLFramework();
        Double input_left = new Double(1.0);
        Assertions.assertFalse(huml.ONE_OF(input_left, 2,3,4));
    }

    //Double -> Integer
    @Test
    public void numbe_Double_should_be_one_of_list_of_type_integer() {
        HUMLFramework huml = new HUMLFramework();
        Double input_left = new Double(1.0);
        Assertions.assertTrue(huml.ONE_OF(input_left, new Integer(1), new Integer(3), new Integer(4)));
    }

    @Test
    public void numbe_Double_should_not_be_one_of_list_of_type_integer() {
        HUMLFramework huml = new HUMLFramework();
        Double input_left = new Double(1.0);
        Assertions.assertFalse(huml.ONE_OF(input_left, new Integer(2), new Integer(3), new Integer(4)));
    }

    //Double -> double
    @Test
    public void numbe_Double_should_be_one_of_list_of_type_double() {
        HUMLFramework huml = new HUMLFramework();
        Double input_left = new Double(1.0);
        Assertions.assertTrue(huml.ONE_OF(input_left, 1.0, 2.0, 3.0));
    }

    @Test
    public void numbe_Double_should_not_be_one_of_list_of_type_double() {
        HUMLFramework huml = new HUMLFramework();
        Double input_left = new Double(1.0);
        Assertions.assertFalse(huml.ONE_OF(input_left, 2.0, 3.0, 4.0));
    }

    //Double -> Double
    @Test
    public void numbe_Double_should_be_one_of_list_of_type_Double() {
        HUMLFramework huml = new HUMLFramework();
        Double input_left = new Double(1.0);
        Assertions.assertTrue(huml.ONE_OF(input_left, new Double(1), new Double(3), new Double(4)));
    }

    @Test
    public void numbe_Double_should_not_be_one_of_list_of_type_Double() {
        HUMLFramework huml = new HUMLFramework();
        Double input_left = new Double(1.0);
        Assertions.assertFalse(huml.ONE_OF(input_left, new Double(2), new Double(3), new Double(4)));
    }

    //Double -> Number
    @Test
    public void numbe_Double_should_be_one_of_list_of_type_number() {
        HUMLFramework huml = new HUMLFramework();
        Double input_left = new Double(1.0);
        Assertions.assertTrue(huml.ONE_OF(input_left, (Number)1, (Number)2, (Number)3));
    }

    //Double -> Number
    @Test
    public void numbe_Double_should_not_be_one_of_list_of_type_number() {
        HUMLFramework huml = new HUMLFramework();
        Double input_left = new Double(1.0);
        Assertions.assertFalse(huml.ONE_OF(input_left, (Number)2, (Number)3, (Number)4));
    }

    //Number
    //Number -> int
    @Test
    public void number_Number_should_be_one_of_list_of_type_int() {
        HUMLFramework huml = new HUMLFramework();
        Number input_left = (Number)1.0;
        Assertions.assertTrue(huml.ONE_OF(input_left, 1,2,3));
    }

    @Test
    public void number_Number_should_not_be_one_of_list_of_type_int() {
        HUMLFramework huml = new HUMLFramework();
        Number input_left = (Number)1.0;
        Assertions.assertFalse(huml.ONE_OF(input_left, 2,3,4));
    }

    //Number -> Integer
    @Test
    public void number_Number_should_be_one_of_list_of_type_integer() {
        HUMLFramework huml = new HUMLFramework();
        Number input_left = (Number)1.0;
        Assertions.assertTrue(huml.ONE_OF(input_left, new Integer(1), new Integer(3), new Integer(4)));
    }

    @Test
    public void number_Number_should_not_be_one_of_list_of_type_integer() {
        HUMLFramework huml = new HUMLFramework();
        Number input_left = (Number)1.0;
        Assertions.assertFalse(huml.ONE_OF(input_left, new Integer(2), new Integer(3), new Integer(4)));
    }

    //Number -> double
    @Test
    public void number_Number_should_be_one_of_list_of_type_double() {
        HUMLFramework huml = new HUMLFramework();
        Number input_left = (Number)1.0;
        Assertions.assertTrue(huml.ONE_OF(input_left, 1.0, 2.0, 3.0));
    }

    @Test
    public void number_Number_should_not_be_one_of_list_of_type_double() {
        HUMLFramework huml = new HUMLFramework();
        Number input_left = (Number)1.0;
        Assertions.assertFalse(huml.ONE_OF(input_left, 2.0, 3.0, 4.0));
    }

    //Number -> Double
    @Test
    public void number_Number_should_be_one_of_list_of_type_Double() {
        HUMLFramework huml = new HUMLFramework();
        Number input_left = (Number)1.0;
        Assertions.assertTrue(huml.ONE_OF(input_left, new Double(1), new Double(3), new Double(4)));
    }

    @Test
    public void number_Number_should_not_be_one_of_list_of_type_Double() {
        HUMLFramework huml = new HUMLFramework();
        Number input_left = (Number)1.0;
        Assertions.assertFalse(huml.ONE_OF(input_left, new Double(2), new Double(3), new Double(4)));
    }

    //Number -> Number
    @Test
    public void number_Number_should_be_one_of_list_of_type_number() {
        HUMLFramework huml = new HUMLFramework();
        Number input_left = (Number)1.0;
        Assertions.assertTrue(huml.ONE_OF(input_left, (Number)1, (Number)2, (Number)3));
    }

    //Number -> Number
    @Test
    public void number_Number_should_not_be_one_of_list_of_type_number() {
        HUMLFramework huml = new HUMLFramework();
        Number input_left = (Number)1.0;
        Assertions.assertFalse(huml.ONE_OF(input_left, (Number)2, (Number)3, (Number)4));
    }

}
