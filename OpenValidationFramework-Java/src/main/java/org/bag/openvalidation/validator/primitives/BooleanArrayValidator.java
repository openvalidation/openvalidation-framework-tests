package org.bag.openvalidation.validator.primitives;

import org.bag.openvalidation.HUMLFramework;

import org.bag.model.primitives.BooleanModel;


public class BooleanArrayValidator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;
    
    public BooleanArrayValidator()
    {
        huml = new HUMLFramework();

        HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> 
            huml.FIRST(model.getBooleans())
        
        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> huml.FIRST(Y.GetValue(model)));

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