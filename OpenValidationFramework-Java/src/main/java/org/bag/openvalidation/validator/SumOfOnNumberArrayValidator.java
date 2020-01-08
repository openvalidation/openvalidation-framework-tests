package org.bag.openvalidation.validator;


import org.bag.model.primitives.IntModel;
import org.bag.openvalidation.HUMLFramework;

public class SumOfOnNumberArrayValidator implements HUMLFramework.IOpenValidator {
    public HUMLFramework huml;

    private SumOfOnNumberArrayValidator() {
    }

    public static SumOfOnNumberArrayValidator createListVal() {
        SumOfOnNumberArrayValidator val = new SumOfOnNumberArrayValidator();

        val.huml = new HUMLFramework();


        HUMLFramework.Variable totalSum = val.huml.CreateVariable("totalSum", (IntModel model) -> val.huml.SUM_OF(model.getIntList()));

        val.huml.appendRule("",
                new String[]{"numbers"},
                "sum is 10",
                (IntModel model) -> val.huml.EQUALS(totalSum.GetValue(model), 10.0),
                false
        );

        val.huml.appendRule("",
                new String[]{"numbers"},
                "sum is 0",
                (IntModel model) -> val.huml.EQUALS(totalSum.GetValue(model), 0.0),
                false
        );

        return val;
    }

//    public static SumOfOnNumberArrayValidator createArrayVal() {
//        SumOfOnNumberArrayValidator val = new SumOfOnNumberArrayValidator();
//
//        val.huml = new HUMLFramework();
//
//
//        HUMLFramework.Variable totalSum = val.huml.CreateVariable("totalSum", (IntModel model) -> val.huml.SUM_OF(model.getInts()));
//
//        val.huml.appendRule("",
//                new String[]{"numbers"},
//                "sum is 10",
//                (IntModel model) -> val.huml.EQUALS(totalSum.GetValue(model), 10.0),
//                false
//        );
//
//        val.huml.appendRule("",
//                new String[]{"numbers"},
//                "sum is 0",
//                (IntModel model) -> val.huml.EQUALS(totalSum.GetValue(model), 0.0),
//                false
//        );
//
//        return val;
//    }

    public String getValidatorID() {
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