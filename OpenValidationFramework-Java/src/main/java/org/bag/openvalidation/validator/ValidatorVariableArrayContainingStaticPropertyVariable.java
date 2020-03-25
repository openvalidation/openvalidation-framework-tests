package org.bag.openvalidation.validator;

import org.bag.model.StandardModel;
import org.bag.openvalidation.HUMLFramework;

public class ValidatorVariableArrayContainingStaticPropertyVariable implements HUMLFramework.IOpenValidator
{
   public HUMLFramework huml;

   public ValidatorVariableArrayContainingStaticPropertyVariable() {}

   public static ValidatorVariableArrayContainingStaticPropertyVariable createValidatorWithIntegers(){
      ValidatorVariableArrayContainingStaticPropertyVariable validator = new ValidatorVariableArrayContainingStaticPropertyVariable();
      validator.huml = new HUMLFramework();


      HUMLFramework.Variable numVar = validator.huml.CreateVariable("numVar", (StandardModel model) -> 3);

      HUMLFramework.Variable numbers = validator.huml.CreateVariable("numbers", (StandardModel model) -> validator.huml.CREATE_ARRAY(1,model.getIntegerValue1(),numVar.GetValue(model)));

      validator.huml.appendRule("",
              new String[]{ "inputNumber" },
              "the inputNumber must be one of numbers",
              (StandardModel model) -> validator.huml.NONE_OF(model.getBigDecimal1(), numbers.GetValue(model)),
              false
      );

      return validator;
   }

   public static ValidatorVariableArrayContainingStaticPropertyVariable createValidatorWithIntegersAndDoubles(){
      ValidatorVariableArrayContainingStaticPropertyVariable validator = new ValidatorVariableArrayContainingStaticPropertyVariable();
      validator.huml = new HUMLFramework();


      HUMLFramework.Variable numVar = validator.huml.CreateVariable("numVar", (StandardModel model) -> 3.3);

      HUMLFramework.Variable numbers = validator.huml.CreateVariable("numbers", (StandardModel model) -> validator.huml.CREATE_ARRAY(1.1,model.getIntegerValue1(),numVar.GetValue(model)));

      validator.huml.appendRule("",
              new String[]{ "inputNumber" },
              "the inputNumber must be one of numbers",
              (StandardModel model) -> validator.huml.NONE_OF(model.getBigDecimal1(), numbers.GetValue(model)),
              false
      );

      return validator;
   }

   public String getValidatorID(){
      return "";
   }

   public HUMLFramework.OpenValidationSummary validate(StandardModel model) {
      return huml.validate(model);
   }

   @Override
   public HUMLFramework.OpenValidationSummary validate(Object model) {
      return this.validate((StandardModel)model);
   }


}
