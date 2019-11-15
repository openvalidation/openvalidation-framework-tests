describe('Comparisons - EQUAL', () => { 
    //string equal string
    it('name EQUALS name should be true', () => { 
        expect(huml.EQUALS('name','name')) 
            .toEqual(true); 
    });

    it('name EQUALS no name should be false', () => { 
        expect(huml.EQUALS('name','no name')) 
            .toEqual(false); 
    });

    //number equal number

    it('1.0 EQUALS 1 should be true', () => { 
        expect(huml.EQUALS(1.0,1)) 
        .toEqual(true); 
    });

    it('1.0 EQUALS 1.0 should be true', () => { 
        expect(huml.EQUALS(1.0,1.0)) 
        .toEqual(true); 
    });

    it('1 EQUALS 1 should be true', () => { 
        expect(huml.EQUALS(1,1)) 
            .toEqual(true); 
    });

    it('1 EQUALS 1 should be false', () => { 
        expect(huml.EQUALS(1,2)) 
            .toEqual(false); 
    });

    // non validation equals

    it('1 EQUALS name should be false', () => { 
        expect(huml.EQUALS(1,'name')) 
            .toEqual(false); 
    });

    it('name EQUALS 1 should be false', () => { 
        expect(huml.EQUALS('name',1)) 
            .toEqual(false); 
    });

    it('1 EQUALS 1str should be true', () => { 
        expect(huml.EQUALS(1,'1')) 
            .toEqual(true); 
    });
    
  });

describe('Comparisons - NOT_EQUALS', () => {
    it('name NOT_EQUALS 1 should be true', () => { 
        expect(huml.NOT_EQUALS('name', 1)) 
            .toEqual(true); 
    });

    it('1.1 NOT_EQUALS 1 should be true', () => { 
        expect(huml.NOT_EQUALS(1.1, 1)) 
            .toEqual(true); 
    });

    //keep rounding errors to a minimum
    it('Math.PI NOT_EQUALS 3.14159265358979 should be true', () => { 
        expect(huml.NOT_EQUALS(Math.PI, 3.14159265358979)) 
            .toEqual(true); 
    });

    it('Name NOT_EQUALS name should be true', () => { 
        expect(huml.NOT_EQUALS('Name','name')) 
            .toEqual(true); 
    });
});

describe('Comparisons - GREATER THAN', () => {
    it('1.1 GREATER_THAN 1 should be true', () => { 
        expect(huml.GREATER_THAN(1.1, 1)) 
            .toEqual(true); 
    });

    //keep rounding errors to a minimum
    it('Math.PI GREATER_THAN 3.14159265358979 should be true', () => { 
        expect(huml.GREATER_THAN(Math.PI, 3.14159265358979)) 
            .toEqual(true); 
    });

    it('1 GREATER_THAN null should be true', () => { 
        expect(huml.GREATER_THAN(1, null)) 
            .toEqual(true); 
    });

    it('a GREATER_THAN b should be true', () => { 
        expect(huml.GREATER_THAN('b', 'a')) 
            .toEqual(true); 
    });


    //should be false
    it('name GREATER_THAN 1 should be false', () => { 
        expect(huml.GREATER_THAN('name', 1)) 
            .toEqual(false); 
    });

    it('1 GREATER_THAN 1.1 should be false', () => { 
        expect(huml.GREATER_THAN(1, 1.1)) 
            .toEqual(false); 
    });

    it('a GREATER_THAN b should be false', () => { 
        expect(huml.GREATER_THAN('a', 'b')) 
            .toEqual(false); 
    });

    it('1 GREATER_THAN 1 should be false', () => { 
        expect(huml.GREATER_THAN(1, 1)) 
            .toEqual(false); 
    });
    
});

describe('Comparisons - LESS OR EQUAL', () => {
    it('1.1 LESS_OR_EQUALS 1 should be false', () => { 
        expect(huml.LESS_OR_EQUALS(1.1, 1)) 
            .toEqual(false); 
    });

    //keep rounding errors to a minimum
    it('Math.PI LESS_OR_EQUALS 3.14159265358979 should be false', () => { 
        expect(huml.LESS_OR_EQUALS(Math.PI, 3.14159265358979)) 
            .toEqual(false); 
    });

    it('1 LESS_OR_EQUAL null should be false', () => { 
        expect(huml.LESS_OR_EQUALS(1, null)) 
            .toEqual(false); 
    });

    it('a LESS_OR_EQUALS b should be false', () => { 
        expect(huml.LESS_OR_EQUALS('b', 'a')) 
            .toEqual(false); 
    });


    //should be true
    it('name LESS_OR_EQUAL 1 should be false', () => { 
        expect(huml.LESS_OR_EQUALS('name', 1)) 
            .toEqual(false); 
    });

    it('1 LESS_OR_EQUALS 1.1 should be true', () => { 
        expect(huml.LESS_OR_EQUALS(1, 1.1)) 
            .toEqual(true); 
    });

    it('a LESS_OR_EQUALS b should be true', () => { 
        expect(huml.LESS_OR_EQUALS('a', 'b')) 
            .toEqual(true); 
    });

    it('1 LESS_OR_EQUALS 1 should be true', () => { 
        expect(huml.LESS_OR_EQUALS(1, 1)) 
            .toEqual(true); 
    });
    
});

describe('Comparisons - GREATER OR EQUALS', () => {
    it('1.1 GREATER_OR_EQUALS 1 should be true', () => { 
        expect(huml.GREATER_OR_EQUALS(1.1, 1)) 
            .toEqual(true); 
    });

    it('1 GREATER_OR_EQUALS 1 should be true', () => { 
        expect(huml.GREATER_OR_EQUALS(1, 1)) 
            .toEqual(true); 
    });

    it('b GREATER_OR_EQUALS a should be true', () => { 
        expect(huml.GREATER_OR_EQUALS('b', 'a')) 
            .toEqual(true); 
    });

    it('Math.PI GREATER_OR_EQUALS 3.14159265358979 should be true', () => { 
        expect(huml.GREATER_OR_EQUALS(Math.PI, 3.14159265358979)) 
            .toEqual(true); 
    });

    it('1 GREATER_OR_EQUALS 1.1 should be false', () => { 
        expect(huml.GREATER_OR_EQUALS(1, 1.1)) 
            .toEqual(false); 
    });

    it('a GREATER_OR_EQUALS b should be false', () => { 
        expect(huml.GREATER_OR_EQUALS('a', 'b')) 
            .toEqual(false); 
    });

    it('name GREATER_OR_EQUALS 1.1 should be false', () => { 
        expect(huml.GREATER_OR_EQUALS('name', 1.1)) 
            .toEqual(false); 
    });
});

describe('Comparisons - LESS THAN', () => {
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

describe('Comparisons - EMPTY', () => {
    it('EMPTY null should be true', () => { 
        expect(huml.EMPTY(null)) 
            .toEqual(true); 
    });

    it('EMPTY string should be true', () => { 
        expect(huml.EMPTY('')) 
            .toEqual(true); 
    });

    it('EMPTY NaN should be true', () => { 
        expect(huml.EMPTY(NaN)) 
            .toEqual(true); 
    });

    it('EMPTY -1 should be false', () => { 
        expect(huml.EMPTY(-1)) 
            .toEqual(false); 
    });

    it('EMPTY name should be false', () => { 
        expect(huml.EMPTY('name')) 
            .toEqual(false); 
    });

    it('EMPTY object should be false', () => { 
        expect(huml.EMPTY(new Object)) 
            .toEqual(false); 
    });
});

describe('Comparisons - NOT EMPTY', () => {
    it('NOT_EMPTY null should be false', () => { 
        expect(huml.NOT_EMPTY(null)) 
            .toEqual(false); 
    });

    it('NOT_EMPTY string should be false', () => { 
        expect(huml.NOT_EMPTY('')) 
            .toEqual(false); 
    });

    it('EMPTY NaN should be false', () => { 
        expect(huml.NOT_EMPTY(NaN)) 
            .toEqual(false); 
    });

    it('NOT_EMPTY -1 should be true', () => { 
        expect(huml.NOT_EMPTY(-1)) 
            .toEqual(true); 
    });

    it('NOT_EMPTY name should be true', () => { 
        expect(huml.NOT_EMPTY('name')) 
            .toEqual(true); 
    });

    it('NOT_EMPTY object should be true', () => { 
        expect(huml.NOT_EMPTY(new Object)) 
            .toEqual(true); 
    });
});