package validators.primitives;

import org.bag.model.primitives.IntModel;
import org.bag.openvalidation.HUMLFramework;
import org.bag.openvalidation.validator.primitives.IntArrayValidator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class IntValidatorTest {

    @Test
    public void FirstTest(){
        int[] ints = new int[]{1,2,3};

        IntModel model = new IntModel();
        model.setInts(ints);
        model.setValue(1);

        IntArrayValidator val = IntArrayValidator.createFirstIntArrayValidator();
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
        int[] ints = new int[]{1,2,3};

        IntModel model = new IntModel();
        model.setInts(ints);
        model.setValue(3);

        IntArrayValidator val = IntArrayValidator.createLastIntArrayValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

}
