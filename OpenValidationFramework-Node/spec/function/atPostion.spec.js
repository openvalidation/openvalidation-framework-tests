describe('Functions - at Position', () => {

    var huml = require('../../HUMLFramework');

    it('at Position 1 of [1,2,3] should be 1', () => { 
        expect(huml.atPosition([1,2,3], 1)) 
            .toEqual(1); 
    });

    it('at Position -1 of [1,2,3] should be null', () => { 
        expect(huml.atPosition([1,2,3], -1)) 
            .toEqual(null); 
    });

    it('at Position 2 of [1,2,3] should be 2', () => { 
        expect(huml.atPosition([1,2,3], 2)) 
            .toEqual(2); 
    });

    it('at Position 4 of [1,2,3] should be null', () => { 
        expect(huml.atPosition([1,2,3], 4)) 
            .toEqual(null); 
    });
});