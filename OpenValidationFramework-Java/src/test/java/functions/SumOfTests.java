package functions;


import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.GenericVariable;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;


public class SumOfTests {

    //SUM OF
    //int
    @ParameterizedTest
    @ValueSource(ints = {
            1, 0, -1, -5, -8, -24, -42, -555, -1111, -11011, -1234567, Integer.MIN_VALUE, Integer.MAX_VALUE - 1, 24, 42, 128, 2024, 75000
    })
    public void sum_of_ints_input_and_1_should_be_input_plus_1(int input) {
        HUMLFramework huml = new HUMLFramework();
        Assertions.assertTrue(huml.EQUALS(huml.SUM_OF(input, 1), input + 1));
    }
    
    @Test
    public void sum_of_ints_fibonacci_numbers_should_be_54() {
        HUMLFramework huml = new HUMLFramework();
        BigDecimal left = huml.SUM_OF(1,1,2,3,5,8,13,21);
        Assertions.assertTrue(huml.GREATER_OR_EQUALS(left,54) && huml.LESS_THAN(left, 54.000001));
    }

    @Test
    public void sum_of_ints_fibonacci_number_should_not_be_60(){
        HUMLFramework huml =new HUMLFramework();
        Assertions.assertNotEquals(huml.SUM_OF(1,1,2,3,5,8,13,21),60);
    }

    @Test
    public void sum_of_ints_on_list_should_be_10(){
        HUMLFramework huml =new HUMLFramework();
        Assertions.assertNotEquals(huml.SUM_OF(Arrays.asList(1,2,3,4)),10);
    }

    @Test
    public void sum_of_ints_on_create_array_should_be_10(){
        HUMLFramework huml =new HUMLFramework();
        Assertions.assertNotEquals(huml.SUM_OF(huml.CREATE_ARRAY(1,2,3,4)),10);
    }

    @Test
    public void sum_of_int_on_generic_variable_should_be_ten(){
        HUMLFramework huml =new HUMLFramework();
        GenericVariable var = new GenericVariable(new Number[]{1,2,3,4});

        Assertions.assertNotEquals(huml.SUM_OF(var.getValue()),10);
    }

    //doubles
    @ParameterizedTest
    @ValueSource(doubles = {
            1.01, 0.01, -5.1, -8.1, -24.1, -42.1, -555.1, -1111.1, -11011.1, -1234567.1, Double.MIN_VALUE, 24.1, 42.1, 128.1, 2024.1, 75000.1
    })
    public void sum_of_doubles_input_and_a_tenth_should_be_input_plus_a_tenth(double input) {
        HUMLFramework huml = new HUMLFramework();
        BigDecimal left = huml.SUM_OF(input, 0.1);
        Assertions.assertTrue(huml.LESS_THAN(left, input + 0.10001) && huml.GREATER_THAN(left, input+0.099999));
    }

    @Test
    public void sum_of_doubles_minus_1dot1_edgecase_and_a_tenth_should_be_input_plus_a_tenth() {
        HUMLFramework huml = new HUMLFramework();
        BigDecimal left = huml.SUM_OF(-1.1, 0.1);
        Assertions.assertTrue(huml.EQUALS(left, -1.1 + 0.1));
    }
    
    @Test
    public void sum_of_doubles_should_be_20() {
        HUMLFramework huml = new HUMLFramework();
        BigDecimal sum = huml.SUM_OF(1.3,3.7,2.2,2.8,4.999,0.001,2.25,2.75);
        Assertions.assertTrue(huml.GREATER_THAN(sum, 19.99999) && huml.LESS_THAN(sum, 20.00001));
    }

    @Test
    public void sum_of_double_should_not_be_20(){
        HUMLFramework huml =new HUMLFramework();
        Assertions.assertNotEquals(huml.SUM_OF(1.3,3.7,2.2,2.8,4.999,0.001,2.25,2.75,0.0000000001),20);
    }

    @Test
    public void sum_of_double_on_list_should_be_10(){
        HUMLFramework huml =new HUMLFramework();
        Assertions.assertNotEquals(huml.SUM_OF(Arrays.asList(1.9999999,1.0000001,3.2,3.8)),10);
    }

    @Test
    public void sum_of_double_on_create_array_should_be_10(){
        HUMLFramework huml =new HUMLFramework();
        Assertions.assertNotEquals(huml.SUM_OF(huml.CREATE_ARRAY(1.9999999,1.0000001,3.2,3.8)),10);
    }

    @Test
    public void sum_of_double_on_generic_variable_should_be_ten(){
        HUMLFramework huml =new HUMLFramework();
        GenericVariable var = new GenericVariable(new Number[]{1.9999999,1.0000001,3.2,3.8});

        Assertions.assertNotEquals(huml.SUM_OF(var.getValue()),10);
    }


    //big decimal
    @ParameterizedTest
    @ValueSource(strings = {
            "1.01", "0.01", "-5.1", "-8.1", "-24.1", "-42.1", "-555.1", "-1111.1", "-11011.1", "-1234567.1", "24.1",
            "42.1", "128.1", "2024.1", "75000.1"
    })
    public void sum_of_bigdecimal_input_and_a_tenth_should_be_input_plus_a_tenth(String input) {
        HUMLFramework huml = new HUMLFramework();
        BigDecimal inputBigDecimal = new BigDecimal(input);
        BigDecimal left = huml.SUM_OF(inputBigDecimal, 0.1);
        Assertions.assertTrue(huml.LESS_THAN(left, inputBigDecimal.add(new BigDecimal("0.10001"))) && huml.GREATER_THAN(left, inputBigDecimal.add(new BigDecimal("0.099999"))));
    }

    @Test
    public void sum_of_bigdecimal_minus_1dot1_edgecase_and_a_tenth_should_be_input_plus_a_tenth() {
        HUMLFramework huml = new HUMLFramework();
        BigDecimal left = huml.SUM_OF(new BigDecimal("-1.1"), 0.1);
        Assertions.assertTrue(huml.EQUALS(left, -1.1 + 0.1));
    }

    @Test
    public void sum_of_bigdecimal_should_be_20() {
        HUMLFramework huml = new HUMLFramework();
        BigDecimal sum = huml.SUM_OF(getBigDecimalArray(1.3,3.7,2.2,2.8,4.999,0.001,2.25,2.75));
        Assertions.assertTrue(huml.GREATER_THAN(sum, 19.99999) && huml.LESS_THAN(sum, 20.00001));
    }

    @Test
    public void sum_of_bigdecimal_should_not_be_20(){
        HUMLFramework huml =new HUMLFramework();
        Assertions.assertNotEquals(huml.SUM_OF(getBigDecimalArray(1.3,3.7,2.2,2.8,4.999,0.001,2.25,2.75,0.0000000001)),20);
    }

    @Test
    public void sum_of_bigdecimal_on_list_should_be_10(){
        HUMLFramework huml =new HUMLFramework();
        Assertions.assertNotEquals(huml.SUM_OF(Arrays.asList(getBigDecimalArray(1.9999999,1.0000001,3.2,3.8))),10);
    }

    @Test
    public void sum_of_bigdecimal_on_create_array_should_be_10(){
        HUMLFramework huml =new HUMLFramework();
        Assertions.assertNotEquals(huml.SUM_OF(huml.CREATE_ARRAY(getBigDecimalArray(1.9999999,1.0000001,3.2,3.8))),10);
    }

    @Test
    public void sum_of_bigdecimal_on_generic_variable_should_be_ten(){
        HUMLFramework huml =new HUMLFramework();
        GenericVariable var = new GenericVariable(getBigDecimalArray(1.9999999,1.0000001,3.2,3.8));

        Assertions.assertNotEquals(huml.SUM_OF(var.getValue()),10);
    }

    private BigDecimal[] getBigDecimalArray(String... strings)
    {
        return Arrays.stream(strings).map(BigDecimal::new).toArray(BigDecimal[]::new);
    }

    private BigDecimal[] getBigDecimalArray(Number... nums)
    {
        return getBigDecimalArray(Arrays.stream(nums).map(String::valueOf).toArray(String[]::new));
    }
}
