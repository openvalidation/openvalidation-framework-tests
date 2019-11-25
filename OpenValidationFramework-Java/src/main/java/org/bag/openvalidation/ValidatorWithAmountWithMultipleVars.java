package org.bag.openvalidation;

import org.bag.openvalidation.firstTestModel.Model;

public class ValidatorWithAmountWithMultipleVars implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;

    public ValidatorWithAmountWithMultipleVars()
    {
        huml = new HUMLFramework();

        HUMLFramework.Variable array = huml.CreateVariable("array", (Model model) -> model.getNumbers());

        HUMLFramework.Variable firstFilter = huml.CreateVariable("firstfilter", (Model model) -> huml.FIRST(array.GetValue(model), 2));
        HUMLFramework.Variable secondFilter = huml.CreateVariable("secondfilter", (Model model) -> huml.FIRST(firstFilter.GetValue(model), 2));

        HUMLFramework.Variable X = huml.CreateVariable("X",
                (Model model) ->
                        huml.FIRST(secondFilter.GetValue(model)
        ));

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