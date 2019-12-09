package validators.primitives;

import org.bag.model.primitives.DoubleModel;
import org.bag.openvalidation.HUMLFramework;
import org.bag.openvalidation.validator.primitives.DoubleArrayValidator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class DoubleValidatorTest {

    @Test
    public void FirstTest(){
        double[] doubles = new double[]{1.0,2.0,3.0};

        DoubleModel model = new DoubleModel();
        model.setDoubles(doubles);
        model.setValue(1.0);

        DoubleArrayValidator val = DoubleArrayValidator.createFirstDoubleArrayValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

    @Test
    public void LastTest(){
        double[] doubles = new double[]{1.0,2.0,3.0};

        DoubleModel model = new DoubleModel();
        model.setDoubles(doubles);
        model.setValue(3.0);

        DoubleArrayValidator val = DoubleArrayValidator.createLastDoubleArrayValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

}
