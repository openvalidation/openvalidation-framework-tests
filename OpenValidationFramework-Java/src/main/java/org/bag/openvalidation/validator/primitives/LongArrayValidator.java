package org.bag.openvalidation.validator.primitives;

import org.bag.model.primitives.LongModel;
import org.bag.openvalidation.HUMLFramework;


public class LongArrayValidator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;
    
    public LongArrayValidator()
    {
        huml = new HUMLFramework();

        HUMLFramework.Variable X = huml.CreateVariable("X", (LongModel model) -> 
            huml.FIRST(model.getLongs())
        
        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> huml.FIRST(Y.GetValue(model)));

        huml.appendRule("",
           new String[]{ "longs" },
           "error",
           (LongModel model) -> huml.EQUALS(X.GetValue(model), model.getValue()),
           false
        );



    }

    public String getValidatorID(){
        return "";
    }

    public HUMLFramework.OpenValidationSummary validate(LongModel model) {
        return huml.validate(model);
    }

    @Override
    public HUMLFramework.OpenValidationSummary validate(Object model) {
        return this.validate((LongModel) model);
    }

    
}