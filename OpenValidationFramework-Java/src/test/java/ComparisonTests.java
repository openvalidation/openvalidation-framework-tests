import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;



public class ComparisonTests {

    @ParameterizedTest
    @ValueSource(doubles = {
            -2, -1, 0, -5, -18, 500.55501, -1.1010101010101, 0.1, 1.1111111111, 0.999999999999, 1.1, 2.0, 2.2, 3.0, 3.5, 6.0, 1000.1, Double.MAX_VALUE
    })
    public void input_greater_or_equals_minus_18_should_be_true(double input) {
        HUMLFramework huml = new HUMLFramework();
        Assertions.assertTrue(huml.GREATER_OR_EQUALS(input, -18));
    }
    
}
