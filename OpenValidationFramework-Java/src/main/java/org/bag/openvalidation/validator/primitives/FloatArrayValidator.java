package org.bag.openvalidation.validator.primitives;

import org.bag.model.primitives.FloatModel;
import org.bag.openvalidation.HUMLFramework;


public class FloatArrayValidator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;
    
    public FloatArrayValidator()
    {
        huml = new HUMLFramework();

        HUMLFramework.Variable X = huml.CreateVariable("X", (FloatModel model) -> 
            huml.FIRST(model.getFloats())
        
        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (FloatModel model) -> huml.FIRST(Y.GetValue(model)));

        huml.appendRule("",
           new String[]{ "floats" },
           "error",
           (FloatModel model) -> huml.EQUALS(X.GetValue(model), model.getValue()),
           false
        );



    }

    public String getValidatorID(){
        return "";
    }

    public HUMLFramework.OpenValidationSummary validate(FloatModel model) {
        return huml.validate(model);
    }

    @Override
    public HUMLFramework.OpenValidationSummary validate(Object model) {
        return this.validate((FloatModel) model);
    }

    
}