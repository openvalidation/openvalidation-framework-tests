package org.bag.openvalidation.validator;

import org.bag.model.ThingModel;
import org.bag.openvalidation.HUMLFramework;

public class ValidatorWhereFuncWithNumberCheck implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;

    public ValidatorWhereFuncWithNumberCheck()
    {
        huml = new HUMLFramework();



        HUMLFramework.Variable myThing = huml.CreateVariable("myThing", (ThingModel model) -> huml.FIRST(huml.WHERE(model.getThings(), x_821342630 -> huml.GREATER_THAN(x_821342630.getNumber(), 4.0))));

        HUMLFramework.Variable myOtherThing = huml.CreateVariable("myOtherThing", (ThingModel model) -> huml.FIRST(model.getThings()));

        huml.appendRule("",
                new String[]{ "things", "number", "things" },
                "error",
                (ThingModel model) -> huml.EQUALS(myThing.GetValue(model), myOtherThing.GetValue(model)),
                false
        );

        huml.appendRule("",
                new String[]{ "things", "number", "things" },
                "anotherError",
                (ThingModel model) -> huml.NOT_EQUALS(myThing.GetValue(model), myOtherThing.GetValue(model)),
                false
        );



    }

    public String getValidatorID(){
        return "";
    }

    public HUMLFramework.OpenValidationSummary validate(ThingModel model) {
        return huml.validate(model);
    }

    @Override
    public HUMLFramework.OpenValidationSummary validate(Object model) {
        return this.validate((ThingModel)model);
    }


}