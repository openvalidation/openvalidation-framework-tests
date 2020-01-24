describe('Validators - run WHERE Validators', () => { 

    var huml = require('../../HUMLFramework');
    beforeEach(() =>{
        huml.CLEAN();
    });

    //implicit and explicit booleans

    it('run WHERE function with explicit bool', () => {
        var val = require('../../validators/TESTValidator_where_function_explicit_bool');
        let model = {persons:[{married:true}]};
        var summary = val.validate(model);
        //because of clean, each validator needs to be included within test case

        expect(summary.hasErrors) 
            .toEqual(true);
        expect(summary.errors[0].error)
            .toEqual('error');
    });

    it('run WHERE function with explicit bool', () => {
        var val = require('../../validators/TESTValidator_where_function_implicit_bool');
        let model = {persons:[{married:true}]};
        var summary = val.validate(model);
        //because of clean, each validator needs to be included within test case

        expect(summary.hasErrors) 
            .toEqual(true);
        expect(summary.errors[0].error)
            .toEqual('error');
    });

    it('run WHERE function with implicit bool with comparison operator', () => {
        var val = require('../../validators/TESTValidator_where_function_implicit_bool_with_comparison_operator');
        let model = {persons:[{married:true}]};
        var summary = val.validate(model);
        //because of clean, each validator needs to be included within test case

        expect(summary.hasErrors) 
            .toEqual(true);
        expect(summary.errors[0].error)
            .toEqual('error');
    });

    //nested in first function

    it('run WHERE function integration example with object array', () => {
        var val = require('../../validators/TESTValidator_where_function_in_first_function_integration_object_array_example');
        let model = {numbers:[{number:1},{number:2},{number:42}]};
        var summary = val.validate(model);
        //because of clean, each validator needs to be included within test case

        expect(summary.hasErrors) 
            .toEqual(true);
        expect(summary.errors[0].error)
            .toEqual('error');
    });

    it('run WHERE function integration with number check', () => {
        var val = require('../../validators/TESTValidator_where_function_in_first_function_integration_object_with_number_check');
        let model = {things:[{number:5.0, name:'fuenf'},{number:2.0, name:'zwei'}]};
        var summary = val.validate(model);
        //because of clean, each validator needs to be included within test case

        expect(summary.hasErrors) 
            .toEqual(true);
        expect(summary.errors[0].error)
            .toEqual('error');
    });
/*
    it('run WHERE function integration with number check - other example', () => {
        var val = require('../../validators/TESTValidator_where_function_in_first_function_integration_object_with_number_check');
        let model = {things:[{number:5.0, name:'ja'}]};
        var summary = val.validate(model);
        //because of clean, each validator needs to be included within test case

        expect(summary.hasErrors) 
            .toEqual(true);
        expect(summary.errors[0].error)
            .toEqual('error');
    });
*/
    it('run WHERE function in FIRST function on number array with sugar - case 1', () => {
        var val = require('../../validators/TESTValidator_where_function_in_first_function_on_number_array_with_sugar');
        let model = {numbers:[0.5, 0.8, 0.9, 0.99, 0.75, 0.55, 2]};
        var summary = val.validate(model);
        //because of clean, each validator needs to be included within test case

        expect(summary.hasErrors) 
            .toEqual(true);
        expect(summary.errors[0].error)
            .toEqual('error');
    });
/*
    it('run WHERE function in FIRST function on number array with sugar - case 2', () => {
        var val = require('../../validators/TESTValidator_where_function_in_first_function_on_number_array_with_sugar');
        let model = {numbers:[0.5,1,2,3]};
        var summary = val.validate(model);
        //because of clean, each validator needs to be included within test case

        expect(summary.hasErrors) 
            .toEqual(true);
        expect(summary.errors[0].error)
            .toEqual('error');
    });

    it('run WHERE function in FIRST function on number array with sugar - case 3', () => {
        var val = require('../../validators/TESTValidator_where_function_in_first_function_on_number_array_with_sugar');
        let model = {numbers:[1,2,3]};
        var summary = val.validate(model);
        //because of clean, each validator needs to be included within test case

        expect(summary.hasErrors) 
            .toEqual(true);
        expect(summary.errors[0].error)
            .toEqual('error');
    });

    it('run WHERE function in FIRST function on number array with sugar - case 4', () => {
        var val = require('../../validators/TESTValidator_where_function_in_first_function_on_number_array_with_sugar');
        let model = {numbers:[2]};
        var summary = val.validate(model);
        //because of clean, each validator needs to be included within test case

        expect(summary.hasErrors) 
            .toEqual(true);
        expect(summary.errors[0].error)
            .toEqual('error');
    });*/

    it('run WHERE function in FIRST function on number array without sugar', () => {
        var val = require('../../validators/TESTValidator_where_function_in_first_function_on_number_array_without_sugar');
        let model = {numbers:[0.5, 0.8, 0.9, 0.99, 0.75, 0.55, 2]};
        var summary = val.validate(model);
        //because of clean, each validator needs to be included within test case

        expect(summary.hasErrors) 
            .toEqual(true);
        expect(summary.errors[0].error)
            .toEqual('error');
    });

    it('run WHERE function in FIRST function on simple number array', () => {
        var val = require('../../validators/TESTValidator_where_function_in_first_function_on_simple_number_array');
        let model = {numbers: [0.5, 1.0, 2.0, 3.0]};
        var summary = val.validate(model);
        //because of clean, each validator needs to be included within test case

        expect(summary.hasErrors) 
            .toEqual(true);
        expect(summary.errors[0].error)
            .toEqual('error');
    });
/*
    it('run WHERE function in FIRST function on simple number array - case 2', () => {
        var val = require('../../validators/TESTValidator_where_function_in_first_function_on_simple_number_array');
        let model = {numbers: [0.5, 1.0, 2.0, 3.0]};
        var summary = val.validate(model);
        //because of clean, each validator needs to be included within test case

        expect(summary.hasErrors) 
            .toEqual(true);
        expect(summary.errors[0].error)
            .toEqual('error');
    });
*/
    it('run WHERE function in FIRST function on variable with number array with sugar', () => {
        var val = require('../../validators/TESTValidator_where_function_in_first_function_on_variable_with_number_array_with_sugar');
        let model = {numbers:[0.5, 0.8, 0.9, 0.99, 0.75, 0.55, 2]};
        var summary = val.validate(model);
        //because of clean, each validator needs to be included within test case

        expect(summary.hasErrors) 
            .toEqual(true);
        expect(summary.errors[0].error)
            .toEqual('error');
    });

    it('run WHERE function in FIRST function on variable with number array without sugar', () => {
        var val = require('../../validators/TESTValidator_where_function_in_first_function_on_variable_with_number_array_without_sugar');
        let model = {numbers:[0.5, 0.8, 0.9, 0.99, 0.75, 0.55, 2]};
        var summary = val.validate(model);
        //because of clean, each validator needs to be included within test case

        expect(summary.hasErrors) 
            .toEqual(true);
        expect(summary.errors[0].error)
            .toEqual('error');
    });

    it('run WHERE function in FIRST function on variable with simple number array', () => {
        var val = require('../../validators/TESTValidator_where_function_in_first_function_on_variable_with_simple_number_array');
        let model = {numbers: [0.5, 1.0, 2.0, 3.0]};
        var summary = val.validate(model);
        //because of clean, each validator needs to be included within test case

        expect(summary.hasErrors) 
            .toEqual(true);
        expect(summary.errors[0].error)
            .toEqual('error');
    });
});