package validators.primitives;

import org.bag.model.primitives.ByteModel;
import org.bag.model.primitives.ShortModel;
import org.bag.openvalidation.HUMLFramework;
import org.bag.openvalidation.validator.primitives.ByteArrayValidator;
import org.bag.openvalidation.validator.primitives.ShortArrayValidator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ByteValidatorTest {

    @Test
    public void FirstTest(){
        byte[] bytes = new byte[]{1,2,3};

        ByteModel model = new ByteModel();
        model.setBytes(bytes);
        model.setValue(Byte.valueOf("1"));

        ByteArrayValidator val = ByteArrayValidator.createFirstByteArrayValidator();
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
        byte[] bytes = new byte[]{1,2,3};

        ByteModel model = new ByteModel();
        model.setBytes(bytes);
        model.setValue(Byte.valueOf("3"));

        ByteArrayValidator val = ByteArrayValidator.createLastByteArrayValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

}
