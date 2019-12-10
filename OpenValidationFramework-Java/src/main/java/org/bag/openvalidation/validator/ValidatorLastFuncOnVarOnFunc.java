package org.bag.openvalidation.validator;

import org.bag.model.LastTestModel;
import org.bag.openvalidation.HUMLFramework;

public class ValidatorLastFuncOnVarOnFunc implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;

    public ValidatorLastFuncOnVarOnFunc()
    {
        huml = new HUMLFramework();



        HUMLFramework.Variable array = huml.CreateVariable("array", (LastTestModel model) -> huml.LAST(model.getNumbers(), 2.0));

        HUMLFramework.Variable X = huml.CreateVariable("X", (LastTestModel model) -> huml.LAST(array.GetValue(model)));

        huml.appendRule("",
                new String[]{ "numbers" },
                "error",
                (LastTestModel model) -> huml.EQUALS(X.GetValue(model), 1.0),
                false
        );
        
    }

    public String getValidatorID(){
        return "";
    }

    public HUMLFramework.OpenValidationSummary validate(LastTestModel model) {
        return huml.validate(model);
    }

    @Override
    public HUMLFramework.OpenValidationSummary validate(Object model) {
        return this.validate((LastTestModel)model);
    }


}