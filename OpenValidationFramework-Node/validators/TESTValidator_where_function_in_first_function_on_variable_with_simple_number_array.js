var huml = require('../HUMLFramework');

var TESTValidator_where_function_in_first_function_on_variable_with_simple_number_array = function() {

            var numList = huml.createVariable("numList", function(model) { return model.numbers; });

            var X = huml.createVariable("X", function(model) { return huml.FIRST(huml.WHERE(numList.GetValue(model), x_3596 => huml.GREATER_THAN(x_3596, 2.0)), 2.0); });

            var Y = huml.createVariable("Y", function(model) { return huml.FIRST(X.GetValue(model)); });

            huml.appendRule("",
                   ["numbers", ""],
                   "error",
                   function(model) { return huml.EQUALS(Y.GetValue(model), 3.0);},
                   false
                );

    

    this.validate = function(model){
        return huml.validate(model);
    }

    this.getValidatorID = function(){
        return "";
    }
}




var openVALIDATION = new TESTValidator_where_function_in_first_function_on_variable_with_simple_number_array();
module.exports = openVALIDATION;
