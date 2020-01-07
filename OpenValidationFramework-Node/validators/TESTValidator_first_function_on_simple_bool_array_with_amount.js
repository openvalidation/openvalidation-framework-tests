var huml = require('../HUMLFramework');

var TESTValidator_first_function_on_simple_bool_array_with_amount = function() {

            var firstBools = huml.createVariable("firstBools", function(model) { return huml.FIRST(model.booleans, 3.0); });

            var X = huml.createVariable("X", function(model) { return huml.FIRST(model.booleans); });

            huml.appendRule("",
                   ["booleans"],
                   "error",
                   function(model) { return huml.EQUALS(X.GetValue(model), true);},
                   false
                );

    

    this.validate = function(model){
        return huml.validate(model);
    }

    this.getValidatorID = function(){
        return "";
    }
}




var openVALIDATION = new TESTValidator_first_function_on_simple_bool_array_with_amount();
module.exports = openVALIDATION;
