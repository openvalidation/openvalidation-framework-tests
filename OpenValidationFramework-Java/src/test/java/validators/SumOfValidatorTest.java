package validators;

import org.bag.model.FirstTestModel;
import org.bag.model.primitives.IntModel;
import org.bag.openvalidation.HUMLFramework;
import org.bag.openvalidation.validator.SumOfOnNumberArrayValidator;
import org.bag.openvalidation.validator.Validator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class SumOfValidatorTest {

    @Test
    public void SimpleTest(){
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);

        IntModel model = new IntModel();
        model.setIntList(lst);

        SumOfOnNumberArrayValidator val = SumOfOnNumberArrayValidator.createListVal();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("sum is 10"));
    }
}
