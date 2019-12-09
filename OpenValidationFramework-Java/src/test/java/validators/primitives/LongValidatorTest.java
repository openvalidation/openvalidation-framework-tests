package validators.primitives;

import org.bag.model.primitives.LongModel;
import org.bag.openvalidation.HUMLFramework;
import org.bag.openvalidation.validator.primitives.LongArrayValidator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class LongValidatorTest {

    @Test
    public void FirstTest(){
        long[] longs = new long[]{1,2,3};

        LongModel model = new LongModel();
        model.setLongs(longs);
        model.setValue(1L);

        LongArrayValidator val = LongArrayValidator.createFirstLongArrayValidator();
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
        long[] longs = new long[]{1,2,3};

        LongModel model = new LongModel();
        model.setLongs(longs);
        model.setValue(3L);

        LongArrayValidator val = LongArrayValidator.createLastLongArrayValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

}
