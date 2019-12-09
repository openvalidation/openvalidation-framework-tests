package org.bag.openvalidation.validator.primitives;

import org.bag.model.primitives.FloatModel;
import org.bag.openvalidation.HUMLFramework;


public class FloatArrayValidator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;

    private FloatArrayValidator(){}
    
    public static FloatArrayValidator createFirstFloatArrayValidator()
    {
        FloatArrayValidator validator = new FloatArrayValidator();
        validator.huml = new HUMLFramework();

        HUMLFramework.Variable X = validator.huml.CreateVariable("X", (FloatModel model) ->
                validator.huml.FIRST(model.getFloats())
        
        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (FloatModel model) -> huml.FIRST(Y.GetValue(model)));

        validator.huml.appendRule("",
           new String[]{ "floats" },
           "error",
           (FloatModel model) -> validator.huml.EQUALS(X.GetValue(model), model.getValue()),
           false
        );


        return validator;
    }

    public static FloatArrayValidator createLastFloatArrayValidator()
    {
        FloatArrayValidator validator = new FloatArrayValidator();
        validator.huml = new HUMLFramework();

        HUMLFramework.Variable X = validator.huml.CreateVariable("X", (FloatModel model) ->
                validator.huml.LAST(model.getFloats())

        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (FloatModel model) -> huml.FIRST(Y.GetValue(model)));

        validator.huml.appendRule("",
                new String[]{ "floats" },
                "error",
                (FloatModel model) -> validator.huml.EQUALS(X.GetValue(model), model.getValue()),
                false
        );


        return validator;
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