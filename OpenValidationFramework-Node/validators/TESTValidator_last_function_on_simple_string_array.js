var huml = require('../HUMLFramework');

var TESTValidator_last_function_on_simple_string_array = function() {

            var X = huml.createVariable("X", function(model) { return huml.LAST(model.fruits); });

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




var openVALIDATION = new TESTValidator_last_function_on_simple_string_array();
module.exports = openVALIDATION;
