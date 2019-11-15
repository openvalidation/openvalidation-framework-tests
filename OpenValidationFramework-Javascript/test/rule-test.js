describe('Rules - append rule', () => { 
        it('append rule -> rules length should be greater or equal to 1', () => { 
            var hml = new HUMLFramework();
            hml.appendRule("",
                ["name"],
                "name must be something",
                function(input) { 
                    return huml.NOT_EQUALS(input, "something");
                },
                false
            );

            expect(huml.GREATER_OR_EQUALS(hml.rules.length, 1)) 
                .toEqual(true); 
        });

        it('append duplicate rule -> rules length should be greater or equal to 10', () => { 
            var hml = new HUMLFramework();
            for(var i = 0;i<10;i++){
                hml.appendRule("",
                    ["name"],
                    "name must be something",
                    function(input) { 
                        return huml.NOT_EQUALS(input, "something");
                    },
                    false
                );
            }

            expect(huml.GREATER_OR_EQUALS(hml.rules.length, 10)) 
                .toEqual(true); 
        });
});

describe('Rules - validate rule', () => { 
    it('validate rule -> nothing NOT_EQUALS something should be true', () => { 
        var hml = new HUMLFramework();
        hml.appendRule("",
            ["name"],
            "name must be something",
            function(input) { 
                return huml.NOT_EQUALS(input, "something");
            },
            false
        );

        expect(huml.validate(null).hasErrors).toEqual(false);
    });     

    it('validate rule -> EMPTY should be true', () => { 
        var hml = new HUMLFramework();
        hml.appendRule("",
            ["name"],
            "name must be something",
            function(input) { 
                return huml.EMPTY(input.name);
            },
            false
        );

        var mod = {'name':'hans'};
        var res = huml.validate(mod);
        expect(res.hasErrors).toEqual(false);
    }); 
});