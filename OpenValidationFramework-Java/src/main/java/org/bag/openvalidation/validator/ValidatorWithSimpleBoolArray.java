package org.bag.openvalidation.validator;

import org.bag.openvalidation.HUMLFramework;

import org.bag.model.primitives.BooleanModel;


public class ValidatorWithSimpleBoolArray implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;

    public ValidatorWithSimpleBoolArray()
    {
        huml = new HUMLFramework();



        HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> huml.FIRST(model.getBooleans()));

        huml.appendRule("",
           new String[]{ "booleans" },
           "error",
           (BooleanModel model) -> huml.EQUALS(X.GetValue(model), true),
           false
        );



    }

    public String getValidatorID(){
        return "";
    }

    public HUMLFramework.OpenValidationSummary validate(BooleanModel model) {
        return huml.validate(model);
    }

    @Override
    public HUMLFramework.OpenValidationSummary validate(Object model) {
        return this.validate((BooleanModel) model);
    }

    
}