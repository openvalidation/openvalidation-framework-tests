var huml = require('../HUMLFramework');

var TESTValidator_first_function_on_simple_string_array_with_amount = function() {

            var firstFruits = huml.createVariable("firstFruits", function(model) { return huml.FIRST(model.fruits, 3.0); });

            var X = huml.createVariable("X", function(model) { return huml.FIRST(firstFruits.GetValue(model)); });

            huml.appendRule("",
                   ["fruits"],
                   "error",
                   function(model) { return huml.EQUALS(X.GetValue(model), "banana");},
                   false
                );

    

    this.validate = function(model){
        return huml.validate(model);
    }

    this.getValidatorID = function(){
        return "";
    }
}




var openVALIDATION = new TESTValidator_first_function_on_simple_string_array_with_amount();
module.exports = openVALIDATION;
