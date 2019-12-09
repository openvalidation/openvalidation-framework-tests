package org.bag.openvalidation.validator.primitives;

import org.bag.model.primitives.DoubleModel;
import org.bag.openvalidation.HUMLFramework;


public class DoubleArrayValidator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;
    
    private DoubleArrayValidator(){}
    
    public static DoubleArrayValidator createFirstDoubleArrayValidator()
    {
        DoubleArrayValidator validator = new DoubleArrayValidator();
        validator.huml = new HUMLFramework();

        HUMLFramework.Variable X = validator.huml.CreateVariable("X", (DoubleModel model) ->
                validator.huml.FIRST(model.getDoubles())
        
        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (DoubleModel model) -> huml.FIRST(Y.GetValue(model)));

        validator.huml.appendRule("",
           new String[]{ "doubles" },
           "error",
           (DoubleModel model) -> validator.huml.EQUALS(X.GetValue(model), model.getValue()),
           false
        );


        return validator;
    }

    public static DoubleArrayValidator createLastDoubleArrayValidator()
    {
        DoubleArrayValidator validator = new DoubleArrayValidator();
        validator.huml = new HUMLFramework();

        HUMLFramework.Variable X = validator.huml.CreateVariable("X", (DoubleModel model) ->
                validator.huml.LAST(model.getDoubles())

        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (DoubleModel model) -> huml.FIRST(Y.GetValue(model)));

        validator.huml.appendRule("",
                new String[]{ "doubles" },
                "error",
                (DoubleModel model) -> validator.huml.EQUALS(X.GetValue(model), model.getValue()),
                false
        );


        return validator;
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