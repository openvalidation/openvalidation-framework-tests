describe('Functions - SUM_OF', () => { 

    var huml = require('../../HUMLFramework');

    it('SUM_OF 1, 2, 3, 4, 5, 6 should EQUALS 21', () => { 
        var sum = huml.SUM_OF([1,2,3,4,5,6]);
        expect(huml.EQUALS(sum, 21))
            .toEqual(true); 
    });

    it('SUM_OF 1, 2 should EQUALS 21', () => { 
        var sum = huml.SUM_OF(1, 2);
        expect(huml.EQUALS(sum,3))
            .toEqual(true); 
    });
});