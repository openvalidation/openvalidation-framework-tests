describe('Comparisons - LESS THAN', () => {

    var huml = require('../../HUMLFramework');

    it('1 LESS_THAN 1.1 should be true', () => { 
        expect(huml.LESS_THAN(1, 1.1)) 
            .toEqual(true); 
    });

    it('a LESS_THAN b should be true', () => { 
        expect(huml.LESS_THAN('a', 'b')) 
            .toEqual(true); 
    });

    it('a LESS_THAN b should be true', () => { 
        expect(huml.LESS_THAN(3.14159265358979, Math.PI)) 
            .toEqual(true); 
    });

    it('1.00001 LESS_THAN 1 should be false', () => { 
        expect(huml.LESS_THAN(1.00001, 1)) 
            .toEqual(false); 
    });

    it('b LESS_THAN a should be false', () => { 
        expect(huml.LESS_THAN('b', 'a')) 
            .toEqual(false); 
    });

    it('name LESS_THAN 1.1 should be false', () => { 
        expect(huml.LESS_THAN('name', 1.1)) 
            .toEqual(false); 
    });
});