package org.bag.openvalidation.validator;

import org.bag.model.EnumModel;
import org.bag.model.Enums;
import org.bag.openvalidation.HUMLFramework;

public class EnumValidator implements HUMLFramework.IOpenValidator {
    public HUMLFramework huml;

    private EnumValidator(){

    }

    public static EnumValidator createFirstEnumValidator()
    {
        EnumValidator validator = new EnumValidator();
        validator.huml = new HUMLFramework();

        HUMLFramework.Variable X = validator.huml.CreateVariable("X", (EnumModel model) ->
                validator.huml.FIRST(model.getEnums())

        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> huml.FIRST(Y.GetValue(model)));

        validator.huml.appendRule("",
                new String[]{ "enums" },
                "error",
                (EnumModel model) -> validator.huml.EQUALS(X.GetValue(model), model.getValue()),
                false
        );

        return validator;
    }

    public static EnumValidator createLastEnumValidator()
    {
        EnumValidator validator = new EnumValidator();
        validator.huml = new HUMLFramework();

        HUMLFramework.Variable X = validator.huml.CreateVariable("X", (EnumModel model) ->
                validator.huml.LAST(model.getEnums())

        );

        //HUMLFramework.Variable X = huml.CreateVariable("X", (BooleanModel model) -> huml.FIRST(Y.GetValue(model)));

        validator.huml.appendRule("",
                new String[]{ "enums" },
                "error",
                (EnumModel model) -> validator.huml.EQUALS(X.GetValue(model), model.getValue()),
                false
        );

        return validator;
    }

    public String getValidatorID(){
        return "";
    }

    public HUMLFramework.OpenValidationSummary validate(EnumModel model) {
        return huml.validate(model);
    }

    @Override
    public HUMLFramework.OpenValidationSummary validate(Object model) {
        return this.validate((EnumModel) model);
    }
}
