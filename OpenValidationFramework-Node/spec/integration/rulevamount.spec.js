describe('Rules - append rule', () => { 

    var huml = require('../../HUMLFramework');
    beforeEach(() =>{
        huml.CLEAN();
    });

    it('append rule -> rules length should be greater or equal to 1', () => {
        huml.appendRule("",
            ["name"],
            "name must be something0",
            function(input) {
                // Is it intentional that you don't access the field `name` in the model here, as the generator would do it?
                return huml.NOT_EQUALS(input, "something");
            },
            false
        );
        // Is it really a good idea not to use javaScript built-in comparison operators here?
        // I mean, `GREATER_OR_EQUALS` is not what you're testing here.
        expect(huml.GREATER_OR_EQUALS(huml.rules.length, 1)) 
            .toEqual(true); 
    });

    it('append duplicate rule -> rules length should be greater or equal to 10', () => { 
        for(var i = 0;i<10;i++){
            huml.appendRule("",
                ["name"],
                "name must be something1",
                function(input) { 
                    return huml.NOT_EQUALS(input, "something");
                },
                false
            );
        }
        // Same as above.
        expect(huml.GREATER_OR_EQUALS(huml.rules.length, 10)) 
            .toEqual(true); 
    });
});