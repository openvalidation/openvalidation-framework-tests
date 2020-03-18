package validators;

import org.bag.model.StandardModel;
import org.bag.openvalidation.HUMLFramework;
import org.bag.openvalidation.validator.ValidatorOneOfWithCreateArrayOnVariable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidatorOneOfWithCreateArrayOnVariableTest
{
   /*
      Ruleset of validator is:
      cherry as stringVar

      apple, stringValue1 or stringVar as fruits

      the stringValue2 must be none of fruits

      {stringValue1: "", stringValue2: ""}

      => stringValue1 and stringValue2 have to be set in Model
    */


   @ParameterizedTest
   @ValueSource(strings = {"apricot", "coconut"})
   public void validator_with_array_containing_strings_triggered(String s)
   {
      StandardModel model = new StandardModel();
      model.setStringValue1("banana");
      model.setStringValue2(s);

      ValidatorOneOfWithCreateArrayOnVariable validator = new ValidatorOneOfWithCreateArrayOnVariable();
      HUMLFramework.OpenValidationSummary result =  validator.validate(model);

      assertThat(result, notNullValue());
      assertThat(result.hasErrors(), is(true));
      assertThat(result.getErrors(), notNullValue());
      assertThat(result.getErrors().length, is(1));
      assertThat(result.getErrors()[0], notNullValue());
      assertThat(result.getErrors()[0].getError(), is("the fruit must be none of fruits"));
   }

   @ParameterizedTest
   @ValueSource(strings = {"apple", "banana", "cherry"})
   public void validator_with_array_containing_strings_not_triggered(String s)
   {
      StandardModel model = new StandardModel();
      model.setStringValue1("banana");
      model.setStringValue2(s);

      ValidatorOneOfWithCreateArrayOnVariable validator = new ValidatorOneOfWithCreateArrayOnVariable();
      HUMLFramework.OpenValidationSummary result =  validator.validate(model);

      assertThat(result, notNullValue());
      assertThat(result.hasErrors(), is(false));
   }
}
