describe('Comparisons - NOT EMPTY', () => {

    var huml = require('../../HUMLFramework');

    it('NOT_EMPTY null should be false', () => { 
        expect(huml.NOT_EMPTY(null)) 
            .toEqual(false); 
    });

    it('NOT_EMPTY string should be false', () => { 
        expect(huml.NOT_EMPTY('')) 
            .toEqual(false); 
    });

    it('EMPTY NaN should be false', () => { 
        expect(huml.NOT_EMPTY(NaN)) 
            .toEqual(false); 
    });

    it('NOT_EMPTY -1 should be true', () => { 
        expect(huml.NOT_EMPTY(-1)) 
            .toEqual(true); 
    });

    it('NOT_EMPTY name should be true', () => { 
        expect(huml.NOT_EMPTY('name')) 
            .toEqual(true); 
    });

    it('NOT_EMPTY object should be true', () => { 
        expect(huml.NOT_EMPTY(new Object)) 
            .toEqual(true); 
    });
});