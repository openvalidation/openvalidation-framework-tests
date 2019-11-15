describe('Comparisons - EQUAL', () => { 

    var huml = require('../../HUMLFramework');

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