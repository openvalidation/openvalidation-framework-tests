package org.bag.openvalidation.validator.primitives;

import org.bag.model.primitives.ShortModel;
import org.bag.openvalidation.HUMLFramework;


public class ShortArrayValidator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;

    private ShortArrayValidator(){}
    
    public static ShortArrayValidator createFirstShortArrayValidator()
    {
        ShortArrayValidator validator = new ShortArrayValidator();
        validator.huml = new HUMLFramework();

        HUMLFramework.Variable X = validator.huml.CreateVariable("X", (ShortModel model) ->
                validator.huml.FIRST(model.getShorts())
        
        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> huml.FIRST(Y.GetValue(model)));

        validator.huml.appendRule("",
           new String[]{ "shorts" },
           "error",
           (ShortModel model) -> validator.huml.EQUALS(X.GetValue(model), model.getValue()),
           false
        );


        return validator;
    }

    public static ShortArrayValidator createLastShortArrayValidator()
    {
        ShortArrayValidator validator = new ShortArrayValidator();
        validator.huml = new HUMLFramework();

        HUMLFramework.Variable X = validator.huml.CreateVariable("X", (ShortModel model) ->
                validator.huml.LAST(model.getShorts())

        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> huml.FIRST(Y.GetValue(model)));

        validator.huml.appendRule("",
                new String[]{ "shorts" },
                "error",
                (ShortModel model) -> validator.huml.EQUALS(X.GetValue(model), model.getValue()),
                false
        );


        return validator;
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