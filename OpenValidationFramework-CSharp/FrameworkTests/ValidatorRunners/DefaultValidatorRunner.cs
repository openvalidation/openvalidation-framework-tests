using io.openvalidation.integration.tests;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Validator;
using OpenValidationFramework_CSharp.Model;
using OpenValidationFramework_CSharp.Model.Primitive;
using OpenValidationFramework_CSharp.Validator.First;
using OpenValidationFramework_CSharp.Validator.Last;

namespace FrameworkTests.ValidatorRunners
{
    [TestClass]
    public class DefaultValidatorRunner
    {
        [TestMethod]
        [Ignore]
        public void ExecuteRunner() //use this method to run individual validators defined in runner class
        {
            Runner runner = new Runner();
            runner.run();
        }

        [TestMethod]
        public void DefaultValidator_should_have_errors()
        {
            DefaultModel mod = new DefaultModel();
            mod.Name = "Berry";
            HUMLValidator val = new HUMLValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
        }

        [TestMethod]
        public void LastValidator_should_have_errors()
        {
            LastModel mod = new LastModel();
            mod.Numbers.Add(3);
            mod.Numbers.Add(2);
            mod.Numbers.Add(1);

            LastTestValidator val = LastTestValidator.createValidatorWithMultipleArraysInVars();
            var res = val.Validate(mod);
            
            Assert.IsTrue(res.HasErrors);
        }
        
        [TestMethod]
        public void EnumValidator_should_have_errors()
        {
            EnumModel mod = new EnumModel();
            mod.Enums = new[] {Color.Red, Color.Green};

            EnumValidator val = EnumValidator.createValidatorWithMultipleArraysInVars();
            var res = val.Validate(mod);
            
            Assert.IsTrue(res.HasErrors);
            Assert.IsTrue(res.Errors[0].Error.Equals("error"));
        }
    }
}