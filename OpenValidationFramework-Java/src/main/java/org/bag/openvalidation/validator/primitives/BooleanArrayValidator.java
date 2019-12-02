package org.bag.openvalidation.validator.primitives;

import org.bag.openvalidation.HUMLFramework;

import org.bag.model.primitives.BooleanModel;


public class BooleanArrayValidator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;
    
    public BooleanArrayValidator()
    {

    }
    
    public static BooleanArrayValidator createFirstBooleanValidator(){
        BooleanArrayValidator arrayValidator = new BooleanArrayValidator();
        arrayValidator.huml = new HUMLFramework();

        HUMLFramework.Variable X = arrayValidator.huml.CreateVariable("X", (BooleanModel model) ->
                arrayValidator.huml.FIRST(model.getBooleans())

        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> huml.FIRST(Y.GetValue(model)));

        arrayValidator.huml.appendRule("",
                new String[]{ "booleans" },
                "error",
                (BooleanModel model) -> arrayValidator.huml.EQUALS(X.GetValue(model), model.isValue()),
                false
        );
        
        return arrayValidator;
    }

    public static BooleanArrayValidator createLastBooleanValidator(){
        BooleanArrayValidator arrayValidator = new BooleanArrayValidator();
        arrayValidator.huml = new HUMLFramework();

        HUMLFramework.Variable X = arrayValidator.huml.CreateVariable("X", (BooleanModel model) ->
                arrayValidator.huml.LAST(model.getBooleans())

        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> huml.FIRST(Y.GetValue(model)));

        arrayValidator.huml.appendRule("",
                new String[]{ "booleans" },
                "error",
                (BooleanModel model) -> arrayValidator.huml.EQUALS(X.GetValue(model), model.isValue()),
                false
        );

        return arrayValidator;
    }

    public String getValidatorID(){
        return "";
    }

    public HUMLFramework.OpenValidationSummary validate(BooleanModel model) {
        return huml.validate(model);
    }

    @Override
    public HUMLFramework.OpenValidationSummary validate(Object model) {
        return this.validate((BooleanModel) model);
    }

    
}