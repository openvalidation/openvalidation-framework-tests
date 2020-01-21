using System.Collections.Generic;
using io.openvalidation.integration.tests;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Validator;
using OpenValidationFramework_CSharp.Model.Primitive;
using OpenValidationFramework_CSharp.Model.WhereModel;
using OpenValidationFramework_CSharp.Validator.Last;

namespace FrameworkTests.ValidatorRunners
{
    [TestClass]
    public class WhereValidatorRunner
    {
        [TestMethod]
        public void LastFunctionOnVariableContainingAnArrayValidator()
        {
            OpenValidationFramework_CSharp.Model.WhereModel.Model mod = new OpenValidationFramework_CSharp.Model.WhereModel.Model();
            mod.Numbers = new List<Number>();
            mod.Numbers.Add(new Number(){number = 1});
            mod.Numbers.Add(new Number(){number = 2});
            mod.Numbers.Add(new Number(){number = 42});
            
            var val = new WhereDefaultValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
            Assert.IsTrue(res.Errors[0].Error.Equals("error"));
        }
    }
}