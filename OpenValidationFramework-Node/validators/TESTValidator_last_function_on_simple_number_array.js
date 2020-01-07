var huml = require('../HUMLFramework');

var TESTValidator_last_function_on_simple_number_array = function() {

            var X = huml.createVariable("X", function(model) { return huml.LAST(model.numbers); });

            huml.appendRule("",
                   ["numbers"],
                   "error",
                   function(model) { return huml.EQUALS(X.GetValue(model), 3.0);},
                   false
                );

    

    this.validate = function(model){
        return huml.validate(model);
    }

    this.getValidatorID = function(){
        return "";
    }
}




var openVALIDATION = new TESTValidator_last_function_on_simple_number_array();
module.exports = openVALIDATION;
