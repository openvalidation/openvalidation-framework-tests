package org.bag.openvalidation.validator.primitives;

import org.bag.model.primitives.ByteModel;
import org.bag.openvalidation.HUMLFramework;


public class ByteArrayValidator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;
    
    public ByteArrayValidator()
    {
        huml = new HUMLFramework();

        HUMLFramework.Variable X = huml.CreateVariable("X", (ByteModel model) -> 
            huml.FIRST(model.getBytes())
        
        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> huml.FIRST(Y.GetValue(model)));

        huml.appendRule("",
           new String[]{ "bytes" },
           "error",
           (ByteModel model) -> huml.EQUALS(X.GetValue(model), model.getValue()),
           false
        );



    }

    public String getValidatorID(){
        return "";
    }

    public HUMLFramework.OpenValidationSummary validate(ByteModel model) {
        return huml.validate(model);
    }

    @Override
    public HUMLFramework.OpenValidationSummary validate(Object model) {
        return this.validate((ByteModel) model);
    }

    
}