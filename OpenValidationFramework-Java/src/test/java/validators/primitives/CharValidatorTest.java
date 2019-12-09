package validators.primitives;

import org.bag.model.primitives.CharModel;
import org.bag.openvalidation.HUMLFramework;
import org.bag.openvalidation.validator.primitives.CharArrayValidator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class CharValidatorTest {

    @Test
    public void FirstTest(){
        char[] chars = new char[]{'a','b','c'};

        CharModel model = new CharModel();
        model.setChars(chars);
        model.setValue('a');

        CharArrayValidator val = CharArrayValidator.createFirstCharArrayValidator();
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
        char[] chars = new char[]{'a','b','c'};

        CharModel model = new CharModel();
        model.setChars(chars);
        model.setValue('c');

        CharArrayValidator val = CharArrayValidator.createLastCharArrayValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

}
