package validators;

import org.bag.model.car.Car;
import org.bag.model.car.CarModel;
import org.bag.model.car.Wheel;
import org.bag.openvalidation.HUMLFramework;
import org.bag.openvalidation.validator.CarModelValidator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class CarValidatorTest {

    
    //todo jgeske 02.12.19 requires the resolution of return types by model generation
    @Test
    @Disabled
    public void SimpleTest(){
        boolean[] booleans = new boolean[]{true,false,false};

        //init model values
        
        Wheel wheel1 = new Wheel();
        wheel1.setDiameter(126.0);
        wheel1.setTireType(1);
        Wheel wheel2 = new Wheel();
        wheel2.setDiameter(1.0);
        wheel2.setTireType(2);
        
        Wheel[] wheels = new Wheel[]{wheel1, wheel2};
        
        Car car1 = new Car();
        car1.setWheels(wheels);
        car1.setManufacturer("general engines");
        car1.setName("daddylac");
        
        Car[] cars = new Car[]{car1};
        
        //setup model

        CarModel model = new CarModel();
        model.setCars(cars);

        //validate
        
        CarModelValidator val = new CarModelValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

}
