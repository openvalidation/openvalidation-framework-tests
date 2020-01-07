var huml = require('../HUMLFramework');

var TESTValidator_last_function_on_simple_bool_array = function() {

            var X = huml.createVariable("X", function(model) { return huml.LAST(model.booleans); });

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




var openVALIDATION = new TESTValidator_last_function_on_simple_bool_array();
module.exports = openVALIDATION;
