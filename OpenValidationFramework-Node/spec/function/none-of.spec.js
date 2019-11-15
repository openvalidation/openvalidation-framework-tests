describe('Functions - NONE OF', () => {

    var huml = require('../../HUMLFramework');

    it('1 NONE_OF 1,2,3 should be false', () => { 
        expect(huml.NONE_OF(1, 1,2,3)) 
            .toEqual(false); 
    });

    it('1 NONE_OF [1,2,3] should be false', () => { 
        expect(huml.NONE_OF(1, [1,2,3])) 
            .toEqual(false); 
    });

    it('a NONE_OF abcd should be false', () => { 
        expect(huml.NONE_OF('a', 'abcd')) 
            .toEqual(false); 
    });

    it('1 NONE_OF [1,2,3,4,1] should be false', () => { 
        expect(huml.NONE_OF(1, [1,2,3,4,1])) 
            .toEqual(false); 
    });

    it('1 NONE_OF [2,3,4] should be true', () => { 
        expect(huml.NONE_OF(1,[2,3,4])) 
            .toEqual(true); 
    });

    it('a NONE_OF bcde should be true', () => { 
        expect(huml.NONE_OF('a', 'bcde')) 
            .toEqual(true); 
    });

    it('name NONE_OF [1,2,3] should be true', () => { 
        expect(huml.NONE_OF('name', [1,2,3])) 
            .toEqual(true); 
    });

    it('null NONE_OF [1,2,3] should be true', () => { 
        expect(huml.NONE_OF(null, [1,2,3])) 
            .toEqual(true); 
    });
});