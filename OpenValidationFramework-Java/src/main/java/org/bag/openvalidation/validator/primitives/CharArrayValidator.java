package org.bag.openvalidation.validator.primitives;

import org.bag.model.primitives.CharModel;
import org.bag.openvalidation.HUMLFramework;


public class CharArrayValidator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;
    
    private CharArrayValidator(){
        
    }
    
    public static CharArrayValidator createFirstCharArrayValidator()
    {
        CharArrayValidator validator = new CharArrayValidator();
        validator.huml = new HUMLFramework();

        HUMLFramework.Variable X = validator.huml.CreateVariable("X", (CharModel model) -> 
            validator.huml.FIRST(model.getChars())
        
        );

        //HUMLFramework.Variable X = validator.huml.CreateVariable("X", (CharModel model) -> validator.huml.FIRST(Y.GetValue(model)));

        validator.huml.appendRule("",
           new String[]{ "chars" },
           "error",
           (CharModel model) -> validator.huml.EQUALS(X.GetValue(model), model.getValue()),
           false
        );


        return validator;
    }

    public static CharArrayValidator createLastCharArrayValidator()
    {
        CharArrayValidator validator = new CharArrayValidator();
        validator.huml = new HUMLFramework();

        HUMLFramework.Variable X = validator.huml.CreateVariable("X", (CharModel model) ->
                validator.huml.LAST(model.getChars())

        );

        //HUMLFramework.Variable X = validator.huml.CreateVariable("X", (CharModel model) -> validator.huml.FIRST(Y.GetValue(model)));

        validator.huml.appendRule("",
                new String[]{ "chars" },
                "error",
                (CharModel model) -> validator.huml.EQUALS(X.GetValue(model), model.getValue()),
                false
        );


        return validator;
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