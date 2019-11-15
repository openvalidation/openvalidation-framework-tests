describe('Comparisons - LESS OR EQUAL', () => {

    var huml = require('../../HUMLFramework');

    it('1.1 LESS_OR_EQUALS 1 should be false', () => { 
        expect(huml.LESS_OR_EQUALS(1.1, 1)) 
            .toEqual(false); 
    });

    //keep rounding errors to a minimum
    it('Math.PI LESS_OR_EQUALS 3.14159265358979 should be false', () => { 
        expect(huml.LESS_OR_EQUALS(Math.PI, 3.14159265358979)) 
            .toEqual(false); 
    });

    it('1 LESS_OR_EQUAL null should be false', () => { 
        expect(huml.LESS_OR_EQUALS(1, null)) 
            .toEqual(false); 
    });

    it('a LESS_OR_EQUALS b should be false', () => { 
        expect(huml.LESS_OR_EQUALS('b', 'a')) 
            .toEqual(false); 
    });


    //should be true
    it('name LESS_OR_EQUAL 1 should be false', () => { 
        expect(huml.LESS_OR_EQUALS('name', 1)) 
            .toEqual(false); 
    });

    it('1 LESS_OR_EQUALS 1.1 should be true', () => { 
        expect(huml.LESS_OR_EQUALS(1, 1.1)) 
            .toEqual(true); 
    });

    it('a LESS_OR_EQUALS b should be true', () => { 
        expect(huml.LESS_OR_EQUALS('a', 'b')) 
            .toEqual(true); 
    });

    it('1 LESS_OR_EQUALS 1 should be true', () => { 
        expect(huml.LESS_OR_EQUALS(1, 1)) 
            .toEqual(true); 
    });
    
});