describe('Validators - run WHERE Validators', () => { 

    var huml = require('../../HUMLFramework');
    beforeEach(() =>{
        huml.CLEAN();
    });

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
});