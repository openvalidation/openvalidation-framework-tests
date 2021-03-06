describe('Functions - LAST', () => {

    var huml = require('../../HUMLFramework');

    it('Last 2 of 1,2,3 should be 2,3', () => { 
        expect(huml.LAST([1,2,3], 2)) 
            .toEqual([2,3]); 
    });

    it('LAST 1 of 1,2,3 should be 3', () => { 
        expect(huml.LAST([1,2,3], 1)) 
            .toEqual(3); 
    });

    it('LAST 4 of 1,2,3 should be 1,2,3', () => { 
        expect(huml.LAST([1,2,3], 4)) 
            .toEqual([1,2,3]); 
    });
    
    it('LAST of 1,2,3 in object should be 3', () => { 
        let cont = {numbers:[1,2,3]};
        
        expect(huml.LAST(cont.numbers, 1)) 
            .toEqual(3); 
    });

    it('LAST of 1,2,3 in object in object should be 3', () => { 
        let cont = {container:{numbers:[1,2,3]}};
        
        expect(huml.LAST(cont.container.numbers)) 
            .toEqual(3); 
    });
});