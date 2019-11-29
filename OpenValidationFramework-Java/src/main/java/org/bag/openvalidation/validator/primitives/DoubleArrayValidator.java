package org.bag.openvalidation.validator.primitives;

import org.bag.model.primitives.DoubleModel;
import org.bag.openvalidation.HUMLFramework;


public class DoubleArrayValidator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;
    
    public DoubleArrayValidator()
    {
        huml = new HUMLFramework();

        HUMLFramework.Variable X = huml.CreateVariable("X", (DoubleModel model) -> 
            huml.FIRST(model.getDoubles())
        
        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (DoubleModel model) -> huml.FIRST(Y.GetValue(model)));

        huml.appendRule("",
           new String[]{ "doubles" },
           "error",
           (DoubleModel model) -> huml.EQUALS(X.GetValue(model), 1.0),
           false
        );



    }

    public String getValidatorID(){
        return "";
    }

    public HUMLFramework.OpenValidationSummary validate(DoubleModel model) {
        return huml.validate(model);
    }

    @Override
    public HUMLFramework.OpenValidationSummary validate(Object model) {
        return this.validate((DoubleModel) model);
    }

    
}