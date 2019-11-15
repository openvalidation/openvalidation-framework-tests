var HUMLValidator = function() {
    var huml = new HUMLFramework();

            huml.appendRule("",
                   ["Name"],
                   "Name MUST be Jerry",
                   function(model) { return huml.NOT_EQUALS(model.Name, "Jerry");},
                   false
                );

    

    this.validate = function(model){
        return huml.validate(model);
    }
}


