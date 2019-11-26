package firstRework;

import org.bag.openvalidation.HUMLFramework;
import org.bag.openvalidation.Validator;
import org.bag.openvalidation.ValidatorWithAmount;
import org.bag.openvalidation.ValidatorWithAmountWithMultipleVars;
import org.bag.openvalidation.firstTestModel.Model;

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

        Model model = new Model();
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

        Model model = new Model();
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

        Model model = new Model();
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
}
