package org.bag.openvalidation.validator;

import org.bag.openvalidation.HUMLFramework;
import org.bag.model.FirstTestModel;

public class Validator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;

    public Validator()
    {
        huml = new HUMLFramework();

        HUMLFramework.Variable array = huml.CreateVariable("array", (FirstTestModel model) -> model.getNumbers());

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