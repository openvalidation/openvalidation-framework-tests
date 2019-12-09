package org.bag.openvalidation.validator.primitives;

import org.bag.model.primitives.IntModel;
import org.bag.openvalidation.HUMLFramework;


public class IntArrayValidator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;

    private IntArrayValidator(){}
    
    public static IntArrayValidator createFirstIntArrayValidator()
    {
        IntArrayValidator validator = new IntArrayValidator();
        validator.huml = new HUMLFramework();

        HUMLFramework.Variable X = validator.huml.CreateVariable("X", (IntModel model) ->
                validator.huml.FIRST(model.getInts())
        
        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> huml.FIRST(Y.GetValue(model)));

        validator.huml.appendRule("",
           new String[]{ "ints" },
           "error",
           (IntModel model) -> validator.huml.EQUALS(X.GetValue(model), model.getValue()),
           false
        );


        return validator;
    }

    public static IntArrayValidator createLastIntArrayValidator()
    {
        IntArrayValidator validator = new IntArrayValidator();
        validator.huml = new HUMLFramework();

        HUMLFramework.Variable X = validator.huml.CreateVariable("X", (IntModel model) ->
                validator.huml.LAST(model.getInts())

        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> huml.FIRST(Y.GetValue(model)));

        validator.huml.appendRule("",
                new String[]{ "ints" },
                "error",
                (IntModel model) -> validator.huml.EQUALS(X.GetValue(model), model.getValue()),
                false
        );


        return validator;
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