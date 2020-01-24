var huml = require('../HUMLFramework');

var TESTValidator_where_function_explicit_bool = function() {

            var myThing = huml.createVariable("myThing", function(model) { return huml.FIRST(huml.WHERE(model.persons, x_22459138 => huml.EQUALS(x_22459138.married, true))); });

            var myOtherThing = huml.createVariable("myOtherThing", function(model) { return huml.FIRST(huml.WHERE(model.persons, x_16834569 => huml.EQUALS(x_16834569.married, true))); });

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




var openVALIDATION = new TESTValidator_where_function_explicit_bool();
module.exports = openVALIDATION;
