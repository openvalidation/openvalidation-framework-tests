package org.bag.openvalidation.validator.primitives;

import org.bag.model.primitives.ByteModel;
import org.bag.openvalidation.HUMLFramework;


public class ByteArrayValidator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;

    private ByteArrayValidator(){
        
    }
    
    public static ByteArrayValidator createFirstByteArrayValidator()
    {
        ByteArrayValidator validator = new ByteArrayValidator();
        validator.huml = new HUMLFramework();

        HUMLFramework.Variable X = validator.huml.CreateVariable("X", (ByteModel model) -> 
            validator.huml.FIRST(model.getBytes())
        
        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> huml.FIRST(Y.GetValue(model)));

        validator.huml.appendRule("",
           new String[]{ "bytes" },
           "error",
           (ByteModel model) -> validator.huml.EQUALS(X.GetValue(model), model.getValue()),
           false
        );

        return validator;
    }

    public static ByteArrayValidator createLastByteArrayValidator()
    {
        ByteArrayValidator validator = new ByteArrayValidator();
        validator.huml = new HUMLFramework();

        HUMLFramework.Variable X = validator.huml.CreateVariable("X", (ByteModel model) ->
                validator.huml.LAST(model.getBytes())

        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> huml.FIRST(Y.GetValue(model)));

        validator.huml.appendRule("",
                new String[]{ "bytes" },
                "error",
                (ByteModel model) -> validator.huml.EQUALS(X.GetValue(model), model.getValue()),
                false
        );

        return validator;
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