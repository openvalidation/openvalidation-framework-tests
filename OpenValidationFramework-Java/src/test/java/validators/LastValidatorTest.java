package validators;

import org.bag.model.FirstTestModel;
import org.bag.model.LastTestModel;
import org.bag.openvalidation.HUMLFramework;
import org.bag.openvalidation.validator.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class LastValidatorTest {
    
    @Test
    public void FuncOnVarOnFunc_list() {
        List<Integer> lst = new ArrayList<>();
        lst.add(3);
        lst.add(2);
        lst.add(1);

        LastTestModel model = new LastTestModel();
        model.setNumbers(lst);

        ValidatorLastFuncOnVarOnFunc val = new ValidatorLastFuncOnVarOnFunc();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }
    
    @Test
    public void FuncOnVarOnFunc_singleton_list() {
        List<Integer> lst = new ArrayList<>();
        lst.add(1);

        LastTestModel model = new LastTestModel();
        model.setNumbers(lst);

        ValidatorLastFuncOnVarOnFunc val = new ValidatorLastFuncOnVarOnFunc();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

}
