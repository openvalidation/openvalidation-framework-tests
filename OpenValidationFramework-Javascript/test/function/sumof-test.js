describe('Functions - SUM_OF', () => { 
    const parameters = [
        {description: "SUM_OF on plain array [1,2,3,4] should be 10", value: [1,2,3,4], expected: 10},
        {description: "SUM_OF on plain array [-1,-2,-3,-4] should be -10", value: [-1,-2,-3,-4], expected: -10},
        {description: "SUM_OF on plain array [-2,-1,0,1,2] should be 0", value: [-2,-1,0,1,2], expected: 0}
    ];
       
    parameters.forEach(parameter => {
        it(parameter.description, () => {
            expect(huml.SUM_OF(parameter.value))
                .toEqual(parameter.expected); 
        });
    });

    const parameters2 = [
        {description: "SUM_OF on huml.CREATE_ARRAY(1,2,3,4) should be 10", value: huml.CREATE_ARRAY(1,2,3,4), expected: 10},
        {description: "SUM_OF on huml.CREATE_ARRAY(-1,-2,-3,-4) should be -10", value: huml.CREATE_ARRAY(-1,-2,-3,-4), expected: -10},
        {description: "SUM_OF on huml.CREATE_ARRAY(-2,-1,0,1,2) should be 0", value: huml.CREATE_ARRAY(-2,-1,0,1,2), expected: 0}
    ];
       
    parameters2.forEach(parameter => {
        it(parameter.description, () => {
            expect(huml.SUM_OF(parameter.value))
                .toEqual(parameter.expected); 
        });
    });
});