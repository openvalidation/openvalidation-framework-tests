package org.bag.openvalidation;

import org.bag.openvalidation.firstTestModel.Model;

import java.util.List;

public class ValidatorFuncOnVarOnFunc implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;

    public ValidatorFuncOnVarOnFunc()
    {
        huml = new HUMLFramework();



        HUMLFramework.Variable array = huml.CreateVariable("array", (Model model) ->
            //Object numbers = model.getNumbers();
//            Object o = huml.FIRST(numbers, 2.0);
//            return o;
//            return huml.FIRST(numbers, 2.0);
            huml.FIRST(model.getNumbers(), 2)
        );

        HUMLFramework.Variable X = huml.CreateVariable("X", (Model model) -> huml.FIRST(array.GetValue(model)));

        huml.appendRule("",
           new String[]{ "numbers" },
           "error",
           (Model model) -> huml.EQUALS(X.GetValue(model), 1.0),
           false
        );



    }

    public String getValidatorID(){
        return "";
    }

    public HUMLFramework.OpenValidationSummary validate(Model model) {
        return huml.validate(model);
    }

    @Override
    public HUMLFramework.OpenValidationSummary validate(Object model) {
        return this.validate((Model)model);
    }

    
}
