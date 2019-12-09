package validators.primitives;

import org.bag.model.primitives.BooleanModel;
import org.bag.openvalidation.HUMLFramework;
import org.bag.openvalidation.validator.primitives.BooleanArrayValidator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class BooleanValidatorTest {

    @Test
    public void FirstTest(){
        boolean[] booleans = new boolean[]{true,false,false};

        BooleanModel model = new BooleanModel();
        model.setBooleans(booleans);
        model.setValue(true);

        BooleanArrayValidator val = BooleanArrayValidator.createFirstBooleanValidator();
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
        boolean[] booleans = new boolean[]{false,false,true};

        BooleanModel model = new BooleanModel();
        model.setBooleans(booleans);
        model.setValue(true);

        BooleanArrayValidator val = BooleanArrayValidator.createLastBooleanValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

}
