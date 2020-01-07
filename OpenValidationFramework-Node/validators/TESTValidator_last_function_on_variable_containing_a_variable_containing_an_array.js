var huml = require('../HUMLFramework');

var TESTValidator_last_function_on_variable_containing_a_variable_containing_an_array = function() {

            var arr = huml.createVariable("arr", function(model) { return model.numbers; });

            var array = huml.createVariable("array", function(model) { return arr.GetValue(model); });

            var X = huml.createVariable("X", function(model) { return huml.LAST(array.GetValue(model)); });

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




var openVALIDATION = new TESTValidator_last_function_on_variable_containing_a_variable_containing_an_array();
module.exports = openVALIDATION;
