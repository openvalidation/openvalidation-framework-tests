describe('Functions - SUM_OF', () => { 
    it('SUM_OF 1, 2, 3, 4, 5, 6 should EQUALS 21', () => { 
        expect(huml.EQUALS(huml.SUM_OF([1,2,3,4,5,6]),21))
            .toEqual(true); 
    });
});