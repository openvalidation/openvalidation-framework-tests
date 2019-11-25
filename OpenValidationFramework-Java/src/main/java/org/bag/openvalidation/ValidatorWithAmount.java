package org.bag.openvalidation;

import org.bag.openvalidation.firstTestModel.Model;

public class ValidatorWithAmount implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;

    public ValidatorWithAmount()
    {
        huml = new HUMLFramework();

        HUMLFramework.Variable array = huml.CreateVariable("array", (Model model) -> model.getNumbers());
        HUMLFramework.Variable array2Items = huml.CreateVariable("X", (Model model) -> huml.FIRST(array.GetValue(model), 2));

        HUMLFramework.Variable X = huml.CreateVariable("X",
                (Model model) ->
                        huml.FIRST(array2Items.GetValue(model))
        );

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