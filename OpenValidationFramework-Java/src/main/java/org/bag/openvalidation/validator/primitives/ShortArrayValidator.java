package org.bag.openvalidation.validator.primitives;

import org.bag.model.primitives.ShortModel;
import org.bag.openvalidation.HUMLFramework;


public class ShortArrayValidator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;
    
    public ShortArrayValidator()
    {
        huml = new HUMLFramework();

        HUMLFramework.Variable X = huml.CreateVariable("X", (ShortModel model) -> 
            huml.FIRST(model.getShorts())
        
        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> huml.FIRST(Y.GetValue(model)));

        huml.appendRule("",
           new String[]{ "booleans" },
           "error",
           (ShortModel model) -> huml.EQUALS(X.GetValue(model), Short.valueOf("1")),
           false
        );



    }

    public String getValidatorID(){
        return "";
    }

    public HUMLFramework.OpenValidationSummary validate(ShortModel model) {
        return huml.validate(model);
    }

    @Override
    public HUMLFramework.OpenValidationSummary validate(Object model) {
        return this.validate((ShortModel) model);
    }

    
}