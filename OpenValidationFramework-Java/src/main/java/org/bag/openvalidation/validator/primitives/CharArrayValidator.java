package org.bag.openvalidation.validator.primitives;

import org.bag.model.primitives.CharModel;
import org.bag.openvalidation.HUMLFramework;


public class CharArrayValidator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;
    
    public CharArrayValidator()
    {
        huml = new HUMLFramework();

        HUMLFramework.Variable X = huml.CreateVariable("X", (CharModel model) -> 
            huml.FIRST(model.getChars())
        
        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (CharModel model) -> huml.FIRST(Y.GetValue(model)));

        huml.appendRule("",
           new String[]{ "chars" },
           "error",
           (CharModel model) -> huml.EQUALS(X.GetValue(model), 'a'),
           false
        );



    }

    public String getValidatorID(){
        return "";
    }

    public HUMLFramework.OpenValidationSummary validate(CharModel model) {
        return huml.validate(model);
    }

    @Override
    public HUMLFramework.OpenValidationSummary validate(Object model) {
        return this.validate((CharModel) model);
    }

    
}