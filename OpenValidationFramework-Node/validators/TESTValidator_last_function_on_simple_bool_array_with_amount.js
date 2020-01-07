var huml = require('../HUMLFramework');

var TESTValidator_last_function_on_simple_bool_array_with_amount = function() {

            var lastBools = huml.createVariable("lastBools", function(model) { return huml.LAST(model.booleans, 3.0); });

            var X = huml.createVariable("X", function(model) { return huml.LAST(lastBools.GetValue(model)); });

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




var openVALIDATION = new TESTValidator_last_function_on_simple_bool_array_with_amount();
module.exports = openVALIDATION;
