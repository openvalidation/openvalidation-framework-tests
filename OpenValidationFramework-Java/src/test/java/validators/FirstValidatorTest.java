package validators;

import org.bag.openvalidation.*;
import org.bag.model.FirstTestModel;

import org.bag.openvalidation.validator.Validator;
import org.bag.openvalidation.validator.ValidatorFuncOnVarOnFunc;
import org.bag.openvalidation.validator.ValidatorWithAmount;
import org.bag.openvalidation.validator.ValidatorWithAmountWithMultipleVars;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class FirstValidatorTest {

    @Test
    public void SimpleTest(){
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);

        FirstTestModel model = new FirstTestModel();
        model.setNumbers(lst);

        Validator val = new Validator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

    @Test
    public void ArrayAmountTest() {
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);

        FirstTestModel model = new FirstTestModel();
        model.setNumbers(lst);

        ValidatorWithAmount val = new ValidatorWithAmount();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

    @Test
    public void ArrayAmountTestWithMultipleVarArrays() {
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);

        FirstTestModel model = new FirstTestModel();
        model.setNumbers(lst);

        ValidatorWithAmountWithMultipleVars val = new ValidatorWithAmountWithMultipleVars();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

    @Test
    public void FuncOnVarOnFunc() {
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);

        FirstTestModel model = new FirstTestModel();
        model.setNumbers(lst);

        ValidatorFuncOnVarOnFunc val = new ValidatorFuncOnVarOnFunc();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

}
