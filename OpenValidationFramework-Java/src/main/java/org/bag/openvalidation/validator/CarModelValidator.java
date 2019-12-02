package org.bag.openvalidation.validator;

import org.bag.model.car.CarModel;
import org.bag.openvalidation.HUMLFramework;

/*
first from cars as firstCar

first from firstCar.Wheels as firstWheel

if firstWheel.diameter is greater than 125
then ( ͡° ͜ʖ ͡°)
* */
public class CarModelValidator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;

    public CarModelValidator()
    {
        huml = new HUMLFramework();

        HUMLFramework.Variable firstCar = huml.CreateVariable("firstCar", (CarModel model) -> huml.FIRST(model.getCars()));

        HUMLFramework.Variable firstWheel = huml.CreateVariable("firstWheel", (CarModel model) -> huml.FIRST(firstCar.GetValue(model)));

        huml.appendRule("",
           new String[]{ "cars", "cars.wheels" },
           "error",
           (CarModel model) -> huml.GREATER_THAN(firstWheel.GetValue(model), 125.0),
           //(CarModel model) -> huml.GREATER_THAN(((CarModel.Car.Wheel)firstWheel.GetValue(model)), 125.0),
           false
        );



    }

    public String getValidatorID(){
        return "";
    }

    public HUMLFramework.OpenValidationSummary validate(CarModel model) {
        return huml.validate(model);
    }

    @Override
    public HUMLFramework.OpenValidationSummary validate(Object model) {
        return this.validate((CarModel)model);
    }

    
}