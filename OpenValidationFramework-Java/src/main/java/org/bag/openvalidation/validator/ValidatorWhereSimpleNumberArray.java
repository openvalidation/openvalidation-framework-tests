package org.bag.openvalidation.validator;


import org.bag.model.primitives.*;
import org.bag.openvalidation.HUMLFramework;

public class ValidatorWhereSimpleNumberArray implements HUMLFramework.IOpenValidator {
    public HUMLFramework huml;

    private ValidatorWhereSimpleNumberArray() {
    }

    public static ValidatorWhereSimpleNumberArray createSimpleNumberListValidator() {
        ValidatorWhereSimpleNumberArray val = new ValidatorWhereSimpleNumberArray();

        val.huml = new HUMLFramework();


        HUMLFramework.Variable X = val.huml.CreateVariable("X", (IntModel model) -> val.huml.FIRST(val.huml.WHERE(model.getIntList(), x_594195094 -> val.huml.GREATER_THAN(x_594195094, 2.0)), 2.0));

        HUMLFramework.Variable Y = val.huml.CreateVariable("Y", (IntModel model) -> val.huml.FIRST(X.GetValue(model)));

        val.huml.appendRule("",
                new String[]{"IntList", ""},
                "error",
                (IntModel model) -> val.huml.EQUALS(Y.GetValue(model), 3.0),
                false
        );

        return val;
    }

    public static ValidatorWhereSimpleNumberArray createSimpleNumberArrayValidator() {
        ValidatorWhereSimpleNumberArray val = new ValidatorWhereSimpleNumberArray();

        val.huml = new HUMLFramework();


        HUMLFramework.Variable X = val.huml.CreateVariable("X", (IntModel model) -> val.huml.FIRST(val.huml.WHERE(model.getInts(), x_594195094 -> val.huml.GREATER_THAN(x_594195094, 2.0)), 2.0));

        HUMLFramework.Variable Y = val.huml.CreateVariable("Y", (IntModel model) -> val.huml.FIRST(X.GetValue(model)));

        val.huml.appendRule("",
                new String[]{"ints", ""},
                "error",
                (IntModel model) -> val.huml.EQUALS(Y.GetValue(model), 3.0),
                false
        );

        return val;
    }

    public static ValidatorWhereSimpleNumberArray createSimpleBooleanValidator() {
        ValidatorWhereSimpleNumberArray val = new ValidatorWhereSimpleNumberArray();

        val.huml = new HUMLFramework();


        HUMLFramework.Variable X = val.huml.CreateVariable("X", (BooleanModel model) -> val.huml.FIRST(val.huml.WHERE(model.getBooleans(), x_594195094 -> val.huml.EQUALS(x_594195094, model.isValue())), 2.0));

        HUMLFramework.Variable Y = val.huml.CreateVariable("Y", (BooleanModel model) -> val.huml.FIRST(X.GetValue(model)));

        val.huml.appendRule("",
                new String[]{"booleans", ""},
                "error",
                (BooleanModel model) -> val.huml.EQUALS(Y.GetValue(model), model.isValue()),
                false
        );

        return val;
    }

    public static ValidatorWhereSimpleNumberArray createSimpleByteValidator() {
        ValidatorWhereSimpleNumberArray val = new ValidatorWhereSimpleNumberArray();

        val.huml = new HUMLFramework();


        HUMLFramework.Variable X = val.huml.CreateVariable("X", (ByteModel model) -> val.huml.FIRST(val.huml.WHERE(model.getBytes(), x_594195094 -> val.huml.EQUALS(x_594195094, 1)), 2.0));

        HUMLFramework.Variable Y = val.huml.CreateVariable("Y", (ByteModel model) -> val.huml.FIRST(X.GetValue(model)));

        val.huml.appendRule("",
                new String[]{"bytes", ""},
                "error",
                (ByteModel model) -> val.huml.EQUALS(Y.GetValue(model), 1),
                false
        );

        return val;
    }

    public static ValidatorWhereSimpleNumberArray createSimpleCharValidator() {
        ValidatorWhereSimpleNumberArray val = new ValidatorWhereSimpleNumberArray();

        val.huml = new HUMLFramework();


        HUMLFramework.Variable X = val.huml.CreateVariable("X", (CharModel model) -> val.huml.FIRST(val.huml.WHERE(model.getChars(), x_594195094 -> val.huml.EQUALS(x_594195094, model.getValue())), 2.0));

        HUMLFramework.Variable Y = val.huml.CreateVariable("Y", (CharModel model) -> val.huml.FIRST(X.GetValue(model)));

        val.huml.appendRule("",
                new String[]{"chars", ""},
                "error",
                (CharModel model) -> val.huml.EQUALS(Y.GetValue(model), model.getValue()),
                false
        );

        return val;
    }

    public static ValidatorWhereSimpleNumberArray createSimpleDoubleValidator() {
        ValidatorWhereSimpleNumberArray val = new ValidatorWhereSimpleNumberArray();

        val.huml = new HUMLFramework();


        HUMLFramework.Variable X = val.huml.CreateVariable("X", (DoubleModel model) -> val.huml.FIRST(val.huml.WHERE(model.getDoubles(), x_594195094 -> val.huml.EQUALS(x_594195094, model.getValue())), 2.0));

        HUMLFramework.Variable Y = val.huml.CreateVariable("Y", (DoubleModel model) -> val.huml.FIRST(X.GetValue(model)));

        val.huml.appendRule("",
                new String[]{"doubles", "value", ""},
                "error",
                (DoubleModel model) -> val.huml.EQUALS(Y.GetValue(model), model.getValue()),
                false
        );

        return val;
    }

    public static ValidatorWhereSimpleNumberArray createSimpleFloatValidator() {
        ValidatorWhereSimpleNumberArray val = new ValidatorWhereSimpleNumberArray();

        val.huml = new HUMLFramework();


        HUMLFramework.Variable X = val.huml.CreateVariable("X", (FloatModel model) -> val.huml.FIRST(val.huml.WHERE(model.getFloats(), x_594195094 -> val.huml.EQUALS(x_594195094, model.getValue())), 2.0));

        HUMLFramework.Variable Y = val.huml.CreateVariable("Y", (FloatModel model) -> val.huml.FIRST(X.GetValue(model)));

        val.huml.appendRule("",
                new String[]{"floats", "value", ""},
                "error",
                (FloatModel model) -> val.huml.EQUALS(Y.GetValue(model), model.getValue()),
                false
        );

        return val;
    }

    public static ValidatorWhereSimpleNumberArray createSimpleLongValidator() {
        ValidatorWhereSimpleNumberArray val = new ValidatorWhereSimpleNumberArray();

        val.huml = new HUMLFramework();


        HUMLFramework.Variable X = val.huml.CreateVariable("X", (LongModel model) -> val.huml.FIRST(val.huml.WHERE(model.getLongs(), x_594195094 -> val.huml.EQUALS(x_594195094, model.getValue())), 2.0));

        HUMLFramework.Variable Y = val.huml.CreateVariable("Y", (LongModel model) -> val.huml.FIRST(X.GetValue(model)));

        val.huml.appendRule("",
                new String[]{"longs", "value", ""},
                "error",
                (LongModel model) -> val.huml.EQUALS(Y.GetValue(model), model.getValue()),
                false
        );

        return val;
    }

    public static ValidatorWhereSimpleNumberArray createSimpleShortValidator() {
        ValidatorWhereSimpleNumberArray val = new ValidatorWhereSimpleNumberArray();

        val.huml = new HUMLFramework();


        HUMLFramework.Variable X = val.huml.CreateVariable("X", (ShortModel model) -> val.huml.FIRST(val.huml.WHERE(model.getShorts(), x_594195094 -> val.huml.EQUALS(x_594195094, model.getValue())), 2.0));

        HUMLFramework.Variable Y = val.huml.CreateVariable("Y", (ShortModel model) -> val.huml.FIRST(X.GetValue(model)));

        val.huml.appendRule("",
                new String[]{"shorts", "value", ""},
                "error",
                (ShortModel model) -> val.huml.EQUALS(Y.GetValue(model), model.getValue()),
                false
        );

        return val;
    }
    
    public static ValidatorWhereSimpleNumberArray createSimpleNumberArray_NonPrimitiveValidator() {
        ValidatorWhereSimpleNumberArray val = new ValidatorWhereSimpleNumberArray();

        val.huml = new HUMLFramework();


        HUMLFramework.Variable X = val.huml.CreateVariable("X", (IntModel model) -> val.huml.FIRST(val.huml.WHERE(model.getIntArray(), x_594195094 -> val.huml.GREATER_THAN(x_594195094, 2.0)), 2.0));

        HUMLFramework.Variable Y = val.huml.CreateVariable("Y", (IntModel model) -> val.huml.FIRST(X.GetValue(model)));

        val.huml.appendRule("",
                new String[]{"numbers", ""},
                "error",
                (IntModel model) -> val.huml.EQUALS(Y.GetValue(model), 3.0),
                false
        );

        return val;
    }

    public String getValidatorID() {
        return "";
    }

    public HUMLFramework.OpenValidationSummary validate(IntModel model) {
        return huml.validate(model);
    }
    
    public HUMLFramework.OpenValidationSummary validate(BooleanModel model) {
        return huml.validate(model);
    }
    
    public HUMLFramework.OpenValidationSummary validate(ByteModel model) {
        return huml.validate(model);
    }
    
    public HUMLFramework.OpenValidationSummary validate(CharModel model) {
        return huml.validate(model);
    }

    public HUMLFramework.OpenValidationSummary validate(DoubleModel model) {
        return huml.validate(model);
    }

    public HUMLFramework.OpenValidationSummary validate(FloatModel model) {
        return huml.validate(model);
    }

    public HUMLFramework.OpenValidationSummary validate(LongModel model) {
        return huml.validate(model);
    }

    public HUMLFramework.OpenValidationSummary validate(ShortModel model) {
        return huml.validate(model);
    }

    @Override
    public HUMLFramework.OpenValidationSummary validate(Object model) {
        //todo override multiple data types for all simple type tests
        if(model instanceof IntModel)
            return this.validate((IntModel) model);
        else if(model instanceof BooleanModel)
            return this.validate((BooleanModel)model);
        else if(model instanceof ByteModel)
            return this.validate((ByteModel)model);
        else if(model instanceof CharModel)
            return this.validate((CharModel)model);
        else if(model instanceof DoubleModel)
            return this.validate((DoubleModel)model);
        else if(model instanceof FloatModel)
            return this.validate((FloatModel)model);
        else if(model instanceof LongModel)
            return this.validate((LongModel)model);
        else if(model instanceof ShortModel)
            return this.validate((ShortModel)model);
        


        //no solution => break
        return null;
    }


}