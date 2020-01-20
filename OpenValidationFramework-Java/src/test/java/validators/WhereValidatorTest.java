package validators;

import org.bag.model.LastTestModel;
import org.bag.model.Thing;
import org.bag.model.ThingModel;
import org.bag.openvalidation.HUMLFramework;
import org.bag.openvalidation.validator.ValidatorLastFuncOnVarOnFunc;
import org.bag.openvalidation.validator.ValidatorWhereFuncWithNumberCheck;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhereValidatorTest {
    
    @Test
    public void Where_object_equals_differentSourceFunc() {
        List<Thing> lst = new ArrayList<>();
        lst.add(new Thing(5, "five"));
        lst.add(new Thing(2, "two"));
        lst.add(new Thing(3, "three"));

        ThingModel model = new ThingModel();
        model.setThings(lst);

        ValidatorWhereFuncWithNumberCheck val = new ValidatorWhereFuncWithNumberCheck();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }
    
    @Test
    public void Where_object_not_equals_differentSourceFunc() {
        List<Thing> lst = new ArrayList<>();
        lst.add(new Thing(1, "one"));
        lst.add(new Thing(5, "five"));
        lst.add(new Thing(2, "two"));
        lst.add(new Thing(3, "three"));

        ThingModel model = new ThingModel();
        model.setThings(lst);

        ValidatorWhereFuncWithNumberCheck val = new ValidatorWhereFuncWithNumberCheck();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("anotherError"));
    }

}
