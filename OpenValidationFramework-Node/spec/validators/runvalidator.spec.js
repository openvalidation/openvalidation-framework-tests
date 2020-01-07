describe('Rules - append rule', () => { 

    var huml = require('../../HUMLFramework');
    beforeEach(() =>{
        huml.CLEAN();
    });

    it('run simple bool array test validator', () => {
        var val = require('../../validators/TESTValidator_first_function_on_simple_bool_array');
        let model = {booleans:[true,true,true], name:'hello'};
        var summary = val.validate(model);
        //because of clean, each validator needs to be included within test case

        expect(summary.hasErrors) 
            .toEqual(true); 
    });
    
});