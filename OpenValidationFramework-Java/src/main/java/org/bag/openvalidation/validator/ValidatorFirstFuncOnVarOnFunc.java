package org.bag.openvalidation.validator;

import org.bag.model.LastTestModel;
import org.bag.openvalidation.HUMLFramework;
import org.bag.model.FirstTestModel;

public class ValidatorFirstFuncOnVarOnFunc implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;

    public ValidatorFirstFuncOnVarOnFunc()
    {
        huml = new HUMLFramework();



        HUMLFramework.Variable array = huml.CreateVariable("array", (FirstTestModel model) ->
            //Object numbers = model.getNumbers();
//            Object o = huml.FIRST(numbers, 2.0);
//            return o;
//            return huml.FIRST(numbers, 2.0);
            huml.FIRST(model.getNumbers(), 2.0)
        );

        HUMLFramework.Variable X = huml.CreateVariable("X", (FirstTestModel model) -> huml.FIRST(array.GetValue(model)));

        huml.appendRule("",
           new String[]{ "numbers" },
           "error",
           (FirstTestModel model) -> huml.EQUALS(X.GetValue(model), 1.0),
           false
        );
        
    }

    public String getValidatorID(){
        return "";
    }

    public HUMLFramework.OpenValidationSummary validate(FirstTestModel model) {
        return huml.validate(model);
    }

    @Override
    public HUMLFramework.OpenValidationSummary validate(Object model) {
        return this.validate((FirstTestModel)model);
    }

    
}
