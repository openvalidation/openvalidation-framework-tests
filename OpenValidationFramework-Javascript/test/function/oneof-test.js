describe('Functions - ONE_OF', () => { 

    const parameters1 = [
        {description: "number 1 ONE_OF array expected true", value: 1, list: [1,2,3,4,5], expected: true},
        {description: "number 1 ONE_OF array expected false", value: 1, list: [2,3,4], expected: false}, 
        {description: "number 1 ONE_OF empty array expected false", value: 1, list: [], expected: false}, 
        {description: "number 1.5 ONE_OF array expected true", value: 1, list: [1,1.5,2], expected: true},
        {description: "number 1.5 ONE_OF array expected false", value: 1, list: [1.4,1.6], expected: false},
        {description: "number 1.5 ONE_OF empty array expected false", value: 1, list: [], expected: false},
        {description: "number 0.0000000001 ONE_OF array expected true", value: 1, list: [1,0.0000000001,2], expected: true},
        {description: "number 0.0000000001 ONE_OF array expected false", value: 1, list: [0.0000000000,0.0000000002], expected: false},
        {description: "number 0.0000000001 ONE_OF empty array expected false", value: 1, list: [], expected: false},
        {description: "name ONE_OF array expected true", value: "Peter", list: ["Alice", "Peter", "Ben"], expected: true},
        {description: "name ONE_OF array expected false", value: "Peter", list: ["Alice", "Ben", "Carmen"], expected: false},
        {description: "name ONE_OF empty array expected false", value: "Peter", list: ["Alice", "Ben", "Carmen"], expected: false}
    ];

    parameters1.forEach(parameter => {
        it(parameter.description, () => {
            expect(huml.ONE_OF(parameter.value, parameter.list))
            .toEqual(parameter.expected);
        });
    });

    const parameters2 = [
        {description: "number 1 ONE_OF array [1,2,3] with variable expected true", value: 1, expected: true},
        {description: "number 2 ONE_OF array [1,2,3] with variable expected true", value: 2, expected: true},
        {description: "number 3 ONE_OF array [1,2,3] with variable expected true", value: 3, expected: true},
        {description: "number 4 ONE_OF array [1,2,3] with variable expected false", value: 4, expected: false},
        {description: "number 1.0000000001 ONE_OF array [1,2,3] with variable expected false", value: 1.0000000001, expected: false},
        {description: "number -1 ONE_OF array [1,2,3] with variable expected false", value: -1, expected: false}
    ];
       
    parameters2.forEach(parameter => {
        it(parameter.description, () => {
            var model = { numProp: 2 };

            var numVar = huml.createVariable("numVar", function(model) { return 3.0; });

            var numbers = huml.createVariable("numbers", function(model) { return huml.CREATE_ARRAY(1.0,model.numProp,numVar.GetValue(model)); });

            expect(huml.ONE_OF(parameter.value, numbers.GetValue(model))).toEqual(parameter.expected); 
        });
    });

});




