describe('Validators - run FIRST Validators', () => { 

    var huml = require('../../HUMLFramework');
    beforeEach(() =>{
        huml.CLEAN();
    });

    it('run simple bool array test validator', () => {
        var val = require('../../validators/TESTValidator_first_function_on_simple_bool_array');
        let model = {booleans:[true,false,false], name:'hello'};
        var summary = val.validate(model);
        //because of clean, each validator needs to be included within test case

        expect(summary.hasErrors) 
            .toEqual(true);
        expect(summary.errors[0].error)
            .toEqual('error');
    });

    it('run simple bool array test validator with amount', () => {
        var val = require('../../validators/TESTValidator_first_function_on_simple_bool_array_with_amount');
        let model = {booleans:[true,false,false], name:'hello'};
        var summary = val.validate(model);

        expect(summary.hasErrors) 
            .toEqual(true); 
        expect(summary.errors[0].error)
            .toEqual('error');
    });

    it('run simple number array test validator', () => {
        var val = require('../../validators/TESTValidator_first_function_on_simple_number_array');
        let model = {numbers:[1,2,3], name:'hello'};
        var summary = val.validate(model);

        expect(summary.hasErrors) 
            .toEqual(true); 
        expect(summary.errors[0].error)
            .toEqual('error');
    });

    it('run simple number array test validator with amount', () => {
        var val = require('../../validators/TESTValidator_first_function_on_simple_number_array_with_amount');
        let model = {numbers:[1,2,3], name:'hello'};
        var summary = val.validate(model);

        expect(summary.hasErrors) 
            .toEqual(true); 
        expect(summary.errors[0].error)
            .toEqual('error');
    });
    
    it('run simple string array test validator', () => {
        var val = require('../../validators/TESTValidator_first_function_on_simple_string_array');
        let model = {fruits:['banana', 'apple', 'pear', 'an onion'], name:'hello'};
        var summary = val.validate(model);

        expect(summary.hasErrors) 
            .toEqual(true); 
        expect(summary.errors[0].error)
            .toEqual('error');
    });

    it('run simple string array test validator with amount', () => {
        var val = require('../../validators/TESTValidator_first_function_on_simple_string_array_with_amount');
        let model = {fruits:['banana', 'apple', 'pear', 'an onion'], name:'hello'};
        var summary = val.validate(model);

        expect(summary.hasErrors) 
            .toEqual(true); 
        expect(summary.errors[0].error)
            .toEqual('error');
    });

    it('run first function on variable containing a function validator', () => {
        var val = require('../../validators/TESTValidator_first_function_on_variable_containing_a_function');
        let model = {numbers:[1,2,3], name:'hello'};
        var summary = val.validate(model);

        expect(summary.hasErrors) 
            .toEqual(true); 
        expect(summary.errors[0].error)
            .toEqual('error');
    });

    it('run first function on variable containing a function with property validator', () => {
        var val = require('../../validators/TESTValidator_first_function_on_variable_containing_a_function_with_property');
        let model = {numbers:[1,2,3], name:'hello'};
        var summary = val.validate(model);

        expect(summary.hasErrors) 
            .toEqual(true); 
        expect(summary.errors[0].error)
            .toEqual('error');
    });

    it('run first function on variable containing a function with variable validator', () => {
        var val = require('../../validators/TESTValidator_first_function_on_variable_containing_a_function_with_variable');
        let model = {numbers:[1,2,3], name:'hello'};
        var summary = val.validate(model);

        expect(summary.hasErrors) 
            .toEqual(true); 
        expect(summary.errors[0].error)
            .toEqual('error');
    });

    it('run first function on variable containing a variable containing a variable containing an array validator', () => {
        var val = require('../../validators/TESTValidator_first_function_on_variable_containing_a_variable_containing_an_array');
        let model = {numbers:[1,2,3], name:'hello'};
        var summary = val.validate(model);

        expect(summary.hasErrors) 
            .toEqual(true); 
        expect(summary.errors[0].error)
            .toEqual('error');
    });

    it('run first function on variable containing a variable containing an array validator', () => {
        var val = require('../../validators/TESTValidator_first_function_on_variable_containing_an_array');
        let model = {numbers:[1,2,3], name:'hello'};
        var summary = val.validate(model);

        expect(summary.hasErrors) 
            .toEqual(true); 
        expect(summary.errors[0].error)
            .toEqual('error');
    });
});