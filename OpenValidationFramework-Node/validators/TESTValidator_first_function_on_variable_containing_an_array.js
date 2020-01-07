var huml = require('../HUMLFramework');

var TESTValidator_first_function_on_variable_containing_an_array = function() {

            var array = huml.createVariable("array", function(model) { return model.numbers; });

            var X = huml.createVariable("X", function(model) { return huml.FIRST(array.GetValue(model)); });

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




var openVALIDATION = new TESTValidator_first_function_on_variable_containing_an_array();
module.exports = openVALIDATION;
