var huml = require('../HUMLFramework');

var TESTValidator_last_function_on_simple_string_array_with_amount = function() {

            var lastFruits = huml.createVariable("lastFruits", function(model) { return huml.LAST(model.fruits, 3.0); });

            var X = huml.createVariable("X", function(model) { return huml.LAST(lastFruits.GetValue(model)); });

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




var openVALIDATION = new TESTValidator_last_function_on_simple_string_array_with_amount();
module.exports = openVALIDATION;
