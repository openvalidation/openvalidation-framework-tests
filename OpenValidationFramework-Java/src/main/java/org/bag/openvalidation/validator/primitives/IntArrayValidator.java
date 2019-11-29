package org.bag.openvalidation.validator.primitives;

import org.bag.model.primitives.IntModel;
import org.bag.openvalidation.HUMLFramework;


public class IntArrayValidator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;
    
    public IntArrayValidator()
    {
        huml = new HUMLFramework();

        HUMLFramework.Variable X = huml.CreateVariable("X", (IntModel model) -> 
            huml.FIRST(model.getInts())
        
        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> huml.FIRST(Y.GetValue(model)));

        huml.appendRule("",
           new String[]{ "ints" },
           "error",
           (IntModel model) -> huml.EQUALS(X.GetValue(model), model.getValue()),
           false
        );



    }

    public String getValidatorID(){
        return "";
    }

    public HUMLFramework.OpenValidationSummary validate(IntModel model) {
        return huml.validate(model);
    }

    @Override
    public HUMLFramework.OpenValidationSummary validate(Object model) {
        return this.validate((IntModel) model);
    }

    
}