package validators.primitives;

import org.bag.model.primitives.FloatModel;
import org.bag.openvalidation.HUMLFramework;
import org.bag.openvalidation.validator.primitives.FloatArrayValidator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class FloatValidatorTest {

    @Test
    public void SimpleTest(){
        float[] floats = new float[]{1f,2f,3f};

        FloatModel model = new FloatModel();
        model.setFloats(floats);
        model.setValue(1f);

        FloatArrayValidator val = new FloatArrayValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

}
