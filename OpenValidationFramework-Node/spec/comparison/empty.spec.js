describe('Comparisons - EMPTY', () => {

    var huml = require('../../HUMLFramework');

    it('EMPTY null should be true', () => { 
        expect(huml.EMPTY(null)) 
            .toEqual(true); 
    });

    it('EMPTY string should be true', () => { 
        expect(huml.EMPTY('')) 
            .toEqual(true); 
    });

    it('EMPTY NaN should be true', () => { 
        expect(huml.EMPTY(NaN)) 
            .toEqual(true); 
    });

    it('EMPTY -1 should be false', () => { 
        expect(huml.EMPTY(-1)) 
            .toEqual(false); 
    });

    it('EMPTY name should be false', () => { 
        expect(huml.EMPTY('name')) 
            .toEqual(false); 
    });

    it('EMPTY object should be false', () => { 
        expect(huml.EMPTY(new Object)) 
            .toEqual(false); 
    });
});