package validators;

import org.bag.model.EnumModel;
import org.bag.model.Enums;
import org.bag.model.FirstTestModel;
import org.bag.openvalidation.HUMLFramework;
import org.bag.openvalidation.validator.EnumValidator;
import org.bag.openvalidation.validator.Validator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class EnumValidatorTest {

    @Test
    public void FirstTest(){
        Enums[] enums = new Enums[]{Enums.FIRST, Enums.SECOND, Enums.THIRD};

        EnumModel model = new EnumModel();
        model.setEnums(enums);
        model.setValue(Enums.FIRST);

        EnumValidator val = EnumValidator.createFirstEnumValidator();
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
        Enums[] enums = new Enums[]{Enums.FIRST, Enums.SECOND, Enums.THIRD};

        EnumModel model = new EnumModel();
        model.setEnums(enums);
        model.setValue(Enums.THIRD);

        EnumValidator val = EnumValidator.createLastEnumValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }
}
