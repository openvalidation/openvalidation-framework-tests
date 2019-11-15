describe('Comparisons - GREATER OR EQUALS', () => {

    var huml = require('../../HUMLFramework');

    it('1.1 GREATER_OR_EQUALS 1 should be true', () => { 
        expect(huml.GREATER_OR_EQUALS(1.1, 1)) 
            .toEqual(true); 
    });

    it('1 GREATER_OR_EQUALS 1 should be true', () => { 
        expect(huml.GREATER_OR_EQUALS(1, 1)) 
            .toEqual(true); 
    });

    it('b GREATER_OR_EQUALS a should be true', () => { 
        expect(huml.GREATER_OR_EQUALS('b', 'a')) 
            .toEqual(true); 
    });

    it('Math.PI GREATER_OR_EQUALS 3.14159265358979 should be true', () => { 
        expect(huml.GREATER_OR_EQUALS(Math.PI, 3.14159265358979)) 
            .toEqual(true); 
    });

    it('1 GREATER_OR_EQUALS 1.1 should be false', () => { 
        expect(huml.GREATER_OR_EQUALS(1, 1.1)) 
            .toEqual(false); 
    });

    it('a GREATER_OR_EQUALS b should be false', () => { 
        expect(huml.GREATER_OR_EQUALS('a', 'b')) 
            .toEqual(false); 
    });

    it('name GREATER_OR_EQUALS 1.1 should be false', () => { 
        expect(huml.GREATER_OR_EQUALS('name', 1.1)) 
            .toEqual(false); 
    });
});