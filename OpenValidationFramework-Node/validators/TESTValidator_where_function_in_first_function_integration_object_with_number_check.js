var huml = require('../HUMLFramework');

var TESTValidator_where_function_in_first_function_integration_object_with_number_check = function() {

            var myThing = huml.createVariable("myThing", function(model) { return huml.FIRST(huml.WHERE(model.things, x_15955206 => huml.GREATER_THAN(x_15955206.number, 4.0))); });

            var myOtherThing = huml.createVariable("myOtherThing", function(model) { return huml.FIRST(model.things); });

            huml.appendRule("",
                   ["things", "number", "things"],
                   "error",
                   function(model) { return huml.EQUALS(myThing.GetValue(model), myOtherThing.GetValue(model));},
                   false
                );

            huml.appendRule("",
                   ["things", "number", "things"],
                   "anotherError",
                   function(model) { return huml.NOT_EQUALS(myThing.GetValue(model), myOtherThing.GetValue(model));},
                   false
                );

    

    this.validate = function(model){
        return huml.validate(model);
    }

    this.getValidatorID = function(){
        return "";
    }
}




var openVALIDATION = new TESTValidator_where_function_in_first_function_integration_object_with_number_check();
module.exports = openVALIDATION;
