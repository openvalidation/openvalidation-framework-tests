package org.bag.openvalidation.validator.primitives;

import org.bag.model.primitives.LongModel;
import org.bag.openvalidation.HUMLFramework;


public class LongArrayValidator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;

    private LongArrayValidator(){}
    
    public static LongArrayValidator createFirstLongArrayValidator()
    {
        LongArrayValidator validator = new LongArrayValidator();
        validator.huml = new HUMLFramework();

        HUMLFramework.Variable X = validator.huml.CreateVariable("X", (LongModel model) ->
                validator.huml.FIRST(model.getLongs())
        
        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> huml.FIRST(Y.GetValue(model)));

        validator.huml.appendRule("",
           new String[]{ "longs" },
           "error",
           (LongModel model) -> validator.huml.EQUALS(X.GetValue(model), model.getValue()),
           false
        );


        return validator;
    }

    public static LongArrayValidator createLastLongArrayValidator()
    {
        LongArrayValidator validator = new LongArrayValidator();
        validator.huml = new HUMLFramework();

        HUMLFramework.Variable X = validator.huml.CreateVariable("X", (LongModel model) ->
                validator.huml.LAST(model.getLongs())

        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> huml.FIRST(Y.GetValue(model)));

        validator.huml.appendRule("",
                new String[]{ "longs" },
                "error",
                (LongModel model) -> validator.huml.EQUALS(X.GetValue(model), model.getValue()),
                false
        );


        return validator;
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