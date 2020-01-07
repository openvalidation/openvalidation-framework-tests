var huml = require('../HUMLFramework');

var TESTValidator_last_function_on_variable_containing_a_function_with_property = function() {

            var last2Array = huml.createVariable("last2Array", function(model) { return huml.LAST(model.numbers, 2.0); });

            var X = huml.createVariable("X", function(model) { return huml.LAST(last2Array.GetValue(model)); });

            huml.appendRule("",
                   ["numbers"],
                   "error",
                   function(model) { return huml.EQUALS(X.GetValue(model), 1.0);},
                   false
                );

    

    this.validate = function(model){
        return huml.validate(model);
    }

    this.getValidatorID = function(){
        return "";
    }
}




var openVALIDATION = new TESTValidator_last_function_on_variable_containing_a_function_with_property();
module.exports = openVALIDATION;
