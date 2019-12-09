package validators.primitives;

import org.bag.model.primitives.ShortModel;
import org.bag.openvalidation.HUMLFramework;
import org.bag.openvalidation.validator.primitives.ShortArrayValidator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShortValidatorTest {

    @Test
    public void FirstTest(){
        short[] shorts = new short[]{1,2,3};

        ShortModel model = new ShortModel();
        model.setShorts(shorts);
        model.setValue(Short.valueOf("1"));

        ShortArrayValidator val = ShortArrayValidator.createFirstShortArrayValidator();
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
        short[] shorts = new short[]{1,2,3};

        ShortModel model = new ShortModel();
        model.setShorts(shorts);
        model.setValue(Short.valueOf("3"));

        ShortArrayValidator val = ShortArrayValidator.createLastShortArrayValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

}
