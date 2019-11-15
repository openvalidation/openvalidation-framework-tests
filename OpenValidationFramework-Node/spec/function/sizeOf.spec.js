describe('Functions - Size Of', () => {

    var huml = require('../../HUMLFramework');

    it('sizeOf 1,2,3 should be 3', () => { 
        expect(huml.sizeOf([1,2,3])) 
            .toEqual(3); 
    });

    it('sizeOf [] should be 0', () => { 
        expect(huml.sizeOf([])) 
            .toEqual(0); 
    });

    it('sizeOf 1 should be 0', () => { 
        expect(huml.sizeOf(1)) 
            .toEqual(0); 
    });
});