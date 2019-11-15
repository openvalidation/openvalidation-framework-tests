describe('Rules - validate rule', () => { 

    var huml = require('../../HUMLFramework');
    beforeEach(() =>{
        huml.CLEAN();
    });

    it('validate rule -> null NOT_EQUALS something should be true', () => { 
        var mod = {'name': null};
        huml.appendRule("",
            ["name"],
            "name must be something",
            function(input) { 
                return huml.NOT_EQUALS(input, "something");
            },
            false
        );
        var res = huml.validate(mod);
        expect(res.hasErrors).toEqual(true);
    });     

    it('validate rule -> null as empty is true', () => { 
        var mod = {'name':null};

        huml.appendRule("",
            ["name"],
            "name must ",
            function(input) {
                return huml.EMPTY(input.name);
            },
            false
        );

        var res = huml.validate(mod);
        expect(res.hasErrors).toEqual(true);
    }); 

    it('validate rule -> "hans" as empty is false', () => { 
        var mod = {'name':'hans'};

        huml.appendRule("",
            ["name"],
            "name must ",
            function(input) {
                return huml.EMPTY(input.name);
            },
            false
        );

        var res = huml.validate(mod);
        expect(res.hasErrors).toEqual(false);
    }); 
});