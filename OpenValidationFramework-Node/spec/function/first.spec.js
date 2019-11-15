describe('Functions - FIRST', () => {

    var huml = require('../../HUMLFramework');

    it('First 2 of 1,2,3 should be 1,2', () => { 
        expect(huml.FIRST([1,2,3], 2)) 
            .toEqual([1,2]); 
    });

    it('First 1 of 1,2,3 should be 1', () => { 
        expect(huml.FIRST([1,2,3], 1)) 
            .toEqual(1); 
    });

    it('First 4 of 1,2,3 should be 1,2,3', () => { 
        expect(huml.FIRST([1,2,3], 4)) 
            .toEqual([1,2,3]); 
    });
});