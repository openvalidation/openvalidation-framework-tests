describe('Functions - ONE OF', () => {

    //not yet implemented
    var huml = require('../../HUMLFramework');

    it('1 ONE_OF 1,2,3 should be true', () => { 
        expect(huml.ONE_OF(1, 1,2,3)) 
            .toEqual(true); 
    });

    it('1 ONE_OF [1,2,3] should be true', () => { 
        expect(huml.ONE_OF(1, [1,2,3])) 
            .toEqual(true); 
    });

    it('a ONE_OF abcd should be true', () => { 
        expect(huml.ONE_OF('a', 'abcd')) 
            .toEqual(true); 
    });

    it('1 ONE_OF [1,2,3,4,1] should be true', () => { 
        expect(huml.ONE_OF(1, [1,2,3,4,1])) 
            .toEqual(true); 
    });

    it('1 ONE_OF [2,3,4] should be false', () => { 
        expect(huml.LESS_THAN(1,[2,3,4])) 
            .toEqual(false); 
    });

    it('a ONE_OF bcde should be false', () => { 
        expect(huml.ONE_OF('a', 'bcde')) 
            .toEqual(false); 
    });

    it('name ONE_OF [1,2,3] should be false', () => { 
        expect(huml.ONE_OF('name', [1,2,3])) 
            .toEqual(false); 
    });

    it('null ONE_OF [1,2,3] should be false', () => { 
        expect(huml.ONE_OF(null, [1,2,3])) 
            .toEqual(false); 
    });
});