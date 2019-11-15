var huml = require('./HUMLFramework');

var HUMLValidator = function() {

            huml.appendRule("",
                   ["name"],
                   "name must be johannes",
                   function(model) { return huml.NOT_EQUALS(model.name, "johannes");},
                   false
                );

    

    this.validate = function(model){
        return huml.validate(model);
    }

    this.getValidatorID = function(){
        return "";
    }
}




var openVALIDATION = new HUMLValidator();
module.exports = openVALIDATION;
