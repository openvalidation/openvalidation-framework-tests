package validators;

import org.bag.model.StandardModel;
import org.bag.openvalidation.HUMLFramework;
import org.bag.openvalidation.validator.ValidatorVariableArrayContainingStaticPropertyVariable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidatorVariableArrayContainingStaticPropertyVariableTest
{
   /*
      3 as numVar

      1, numProp or numVar as numbers


      the inputNumber must be one of numbers


      {numProp: 2, inputNumber: 1.5}
      => integerValue1 and bigDecimal1 have to be set in Model
    */

   @ParameterizedTest
   @ValueSource(doubles = {0.99999, 1.00001, 0, 4, -1, -2, -3})
   public void validator_with_array_containing_integers_triggered(double num)
   {
      StandardModel model = new StandardModel();
      model.setIntegerValue1(2);
      model.setBigDecimal1(new BigDecimal(String.valueOf(num)));

      ValidatorVariableArrayContainingStaticPropertyVariable validator = ValidatorVariableArrayContainingStaticPropertyVariable.createValidatorWithIntegers();
      HUMLFramework.OpenValidationSummary result =  validator.validate(model);

      assertThat(result, notNullValue());
      assertThat(result.hasErrors(), is(true));
      assertThat(result.getErrors(), notNullValue());
      assertThat(result.getErrors().length, is(1));
      assertThat(result.getErrors()[0], notNullValue());
      assertThat(result.getErrors()[0].getError(), is("the inputNumber must be one of numbers"));
   }

   @ParameterizedTest
   @ValueSource(doubles = {1, 2, 3, 1.0, 2.0, 3.0})
   public void validator_with_array_containing_integers_not_triggered(double num)
   {
      StandardModel model = new StandardModel();
      model.setIntegerValue1(2);
      model.setBigDecimal1(new BigDecimal(String.valueOf(num)));

      ValidatorVariableArrayContainingStaticPropertyVariable validator = ValidatorVariableArrayContainingStaticPropertyVariable.createValidatorWithIntegers();
      HUMLFramework.OpenValidationSummary result =  validator.validate(model);

      assertThat(result, notNullValue());
      assertThat(result.hasErrors(), is(false));
   }


   /*
      3.3 as numVar

      1.1, numProp or numVar as numbers


      the inputNumber must be one of numbers


      {numProp: 2, inputNumber: 1.5}
      => integerValue1 and bigDecimal1 have to be set in Model
    */
   @ParameterizedTest
   @ValueSource(doubles = {1, 1.99999, 2.00001, 3, 3.5})
   public void validator_with_array_containing_integers_and_doubles_triggered(double num)
   {
      StandardModel model = new StandardModel();
      model.setIntegerValue1(2);
      model.setBigDecimal1(new BigDecimal(String.valueOf(num)));

      ValidatorVariableArrayContainingStaticPropertyVariable validator = ValidatorVariableArrayContainingStaticPropertyVariable.createValidatorWithIntegersAndDoubles();
      HUMLFramework.OpenValidationSummary result =  validator.validate(model);

      assertThat(result, notNullValue());
      assertThat(result.hasErrors(), is(true));
      assertThat(result.getErrors(), notNullValue());
      assertThat(result.getErrors().length, is(1));
      assertThat(result.getErrors()[0], notNullValue());
      assertThat(result.getErrors()[0].getError(), is("the inputNumber must be one of numbers"));
   }

   @ParameterizedTest
   @ValueSource(doubles = {1.1, 2, 3.3})
   public void validator_with_array_containing_integers_and_doubles_not_triggered(double num)
   {
      StandardModel model = new StandardModel();
      model.setIntegerValue1(2);
      model.setBigDecimal1(new BigDecimal(String.valueOf(num)));

      ValidatorVariableArrayContainingStaticPropertyVariable validator = ValidatorVariableArrayContainingStaticPropertyVariable.createValidatorWithIntegersAndDoubles();
      HUMLFramework.OpenValidationSummary result =  validator.validate(model);

      assertThat(result, notNullValue());
      assertThat(result.hasErrors(), is(false));
   }
}
