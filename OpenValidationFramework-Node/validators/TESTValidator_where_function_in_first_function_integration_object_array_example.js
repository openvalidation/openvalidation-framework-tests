var huml = require('../HUMLFramework');

var TESTValidator_where_function_in_first_function_integration_object_array_example = function() {

            var myNumber = huml.createVariable("myNumber", function(model) { return huml.FIRST(huml.WHERE(model.numbers, x_17510639 => huml.EQUALS(x_17510639.number, 42.0))); });

            var bigNumber = huml.createVariable("bigNumber", function(model) { return huml.FIRST(huml.WHERE(model.numbers, x_10915321 => huml.GREATER_THAN(x_10915321.number, 30.0))); });

            huml.appendRule("",
                   ["numbers", "number", "numbers", "number"],
                   "error",
                   function(model) { return huml.EQUALS(myNumber.GetValue(model), bigNumber.GetValue(model));},
                   false
                );

    

    this.validate = function(model){
        return huml.validate(model);
    }

    this.getValidatorID = function(){
        return "";
    }
}




var openVALIDATION = new TESTValidator_where_function_in_first_function_integration_object_array_example();
module.exports = openVALIDATION;
