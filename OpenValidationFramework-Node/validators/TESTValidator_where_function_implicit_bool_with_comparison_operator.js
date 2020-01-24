var huml = require('../HUMLFramework');

var TESTValidator_where_function_implicit_bool_with_comparison_operator = function() {

            var myThing = huml.createVariable("myThing", function(model) { return huml.FIRST(huml.WHERE(model.persons, x_3496137 => huml.EQUALS(true, x_3496137.married))); });

            var myOtherThing = huml.createVariable("myOtherThing", function(model) { return huml.FIRST(huml.WHERE(model.persons, x_18149900 => huml.EQUALS(x_18149900.married, true))); });

            huml.appendRule("",
                   ["persons", "married", "persons", "married"],
                   "error",
                   function(model) { return huml.EQUALS(myThing.GetValue(model), myOtherThing.GetValue(model));},
                   false
                );

    

    this.validate = function(model){
        return huml.validate(model);
    }

    this.getValidatorID = function(){
        return "";
    }
}




var openVALIDATION = new TESTValidator_where_function_implicit_bool_with_comparison_operator();
module.exports = openVALIDATION;
