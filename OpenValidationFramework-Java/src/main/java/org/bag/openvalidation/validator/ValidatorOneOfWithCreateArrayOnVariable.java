package org.bag.openvalidation.validator;

import org.bag.model.StandardModel;
import org.bag.openvalidation.HUMLFramework;

public class ValidatorOneOfWithCreateArrayOnVariable implements HUMLFramework.IOpenValidator
{
   public HUMLFramework huml;

   public ValidatorOneOfWithCreateArrayOnVariable()
   {
      huml = new HUMLFramework();



      HUMLFramework.Variable stringVar = huml.CreateVariable("stringVar", (StandardModel model) -> "cherry");

      HUMLFramework.Variable fruits = huml.CreateVariable("fruits", (StandardModel model) -> huml.CREATE_ARRAY("apple",model.getStringValue1(),stringVar.GetValue(model)));

      huml.appendRule("",
              new String[]{ "fruit" },
              "the fruit must be none of fruits",
              (StandardModel model) -> {
                       return huml.NONE_OF(model.getStringValue2(), fruits.GetValue(model));},
              false
      );



   }

   public String getValidatorID(){
      return "";
   }

   public HUMLFramework.OpenValidationSummary validate(StandardModel model) {
      return huml.validate(model);
   }

   @Override
   public HUMLFramework.OpenValidationSummary validate(Object model) {
      return this.validate(model);
   }


}
