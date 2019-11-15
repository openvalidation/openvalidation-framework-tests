describe('Functions - WHERE', () => {

    //not yet implemented
    var huml = require('../../HUMLFramework');

    it('WHERE [a,b,c] is true expect [a,b,c]', () => { 
        expect(huml.WHERE(['a','b','c'], (x) => { return true;})) 
            .toEqual(['a','b', 'c']); 
    });

    it('WHERE [a,b,c] is a expect a', () => { 
        expect(huml.WHERE(['a','b','c'], (x) =>{ return 'a'===x;})) 
            .toEqual('a'); 
    });

    it('WHERE [a,b,c] is d expect []', () => { 
        expect(huml.WHERE(['a','b','c'], (x) =>{ return 'd'===x;})) 
            .toEqual([]); 
    });
});