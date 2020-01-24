var huml = require('../HUMLFramework');

var TESTValidator_where_function_in_first_function_on_variable_with_number_array_without_sugar = function() {

            var numList = huml.createVariable("numList", function(model) { return model.numbers; });

            var myNumber = huml.createVariable("myNumber", function(model) { return huml.FIRST(huml.WHERE(numList.GetValue(model), x_6797920 => huml.GREATER_THAN(x_6797920, 1.0))); });

            huml.appendRule("",
                   ["numbers", ""],
                   "error",
                   function(model) { return huml.EQUALS(myNumber.GetValue(model), 2.0);},
                   false
                );

    

    this.validate = function(model){
        return huml.validate(model);
    }

    this.getValidatorID = function(){
        return "";
    }
}




var openVALIDATION = new TESTValidator_where_function_in_first_function_on_variable_with_number_array_without_sugar();
module.exports = openVALIDATION;
