describe('Comparisons - GREATER THAN', () => {

    var huml = require('../../HUMLFramework');

    it('1.1 GREATER_THAN 1 should be true', () => { 
        expect(huml.GREATER_THAN(1.1, 1)) 
            .toEqual(true); 
    });

    //keep rounding errors to a minimum
    it('Math.PI GREATER_THAN 3.14159265358979 should be true', () => { 
        expect(huml.GREATER_THAN(Math.PI, 3.14159265358979)) 
            .toEqual(true); 
    });

    it('1 GREATER_THAN null should be true', () => { 
        expect(huml.GREATER_THAN(1, null)) 
            .toEqual(true); 
    });

    it('a GREATER_THAN b should be true', () => { 
        expect(huml.GREATER_THAN('b', 'a')) 
            .toEqual(true); 
    });


    //should be false
    it('name GREATER_THAN 1 should be false', () => { 
        expect(huml.GREATER_THAN('name', 1)) 
            .toEqual(false); 
    });

    it('1 GREATER_THAN 1.1 should be false', () => { 
        expect(huml.GREATER_THAN(1, 1.1)) 
            .toEqual(false); 
    });

    it('a GREATER_THAN b should be false', () => { 
        expect(huml.GREATER_THAN('a', 'b')) 
            .toEqual(false); 
    });

    it('1 GREATER_THAN 1 should be false', () => { 
        expect(huml.GREATER_THAN(1, 1)) 
            .toEqual(false); 
    });
    
});