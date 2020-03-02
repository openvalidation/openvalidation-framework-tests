describe('Array operand - Create_ARRAY', () => { 
    it('Result of huml.CREATE_ARRAY("a","b","c") expected to be string array', () => { 
        expect(huml.CREATE_ARRAY("a","b","c")) 
            .toEqual(["a","b","c"]); 
    });

    it('Result of huml.CREATE_ARRAY(1,2,3) expected to be number array', () => { 
        expect(huml.CREATE_ARRAY(1,2,3)) 
            .toEqual([1,2,3]); 
    });

    it('Result of huml.CREATE_ARRAY() expected to be empty array', () => { 
        expect(huml.CREATE_ARRAY()) 
            .toEqual([]); 
    });

});