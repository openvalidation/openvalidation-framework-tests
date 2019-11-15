describe('Comparisons - NOT_EQUALS', () => {

    var huml = require('../../HUMLFramework');

    it('name NOT_EQUALS 1 should be true', () => { 
        expect(huml.NOT_EQUALS('name', 1)) 
            .toEqual(true); 
    });

    it('1.1 NOT_EQUALS 1 should be true', () => { 
        expect(huml.NOT_EQUALS(1.1, 1)) 
            .toEqual(true); 
    });

    //keep rounding errors to a minimum
    it('Math.PI NOT_EQUALS 3.14159265358979 should be true', () => { 
        expect(huml.NOT_EQUALS(Math.PI, 3.14159265358979)) 
            .toEqual(true); 
    });

    it('Name NOT_EQUALS name should be true', () => { 
        expect(huml.NOT_EQUALS('Name','name')) 
            .toEqual(true); 
    });
});