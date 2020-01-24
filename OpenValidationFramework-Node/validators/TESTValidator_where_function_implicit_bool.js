var huml = require('../HUMLFramework');

var TESTValidator_where_function_implicit_bool = function() {

            var myThing = huml.createVariable("myThing", function(model) { return huml.FIRST(huml.WHERE(model.persons, x_282538 => huml.EQUALS(x_282538.married, true))); });

            var myOtherThing = huml.createVariable("myOtherThing", function(model) { return huml.FIRST(huml.WHERE(model.persons, x_7920333 => huml.EQUALS(x_7920333.married, true))); });

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




var openVALIDATION = new TESTValidator_where_function_implicit_bool();
module.exports = openVALIDATION;
