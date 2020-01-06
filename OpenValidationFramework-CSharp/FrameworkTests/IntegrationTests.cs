using System.Collections.Generic;
using io.openvalidation.integration.tests;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Validator;
using OpenValidationFramework_CSharp.Model;
using OpenValidationFramework_CSharp.Model.Primitive;
using OpenValidationFramework_CSharp.Validator.Last;

namespace FrameworkTests
{
    [TestClass]
    public class IntegrationTests
    {
        [TestMethod]
        [Ignore]
        public void executeRunner() //use this method to run individual validators defined in runner class
        {
            Runner runner = new Runner();
            runner.run();
        }

        [TestMethod]
        public void Validator_should_have_errors()
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

        [TestMethod]
        public void LastFunctionOnVariableContainingAnArrayValidator()
        {
            DoubleModel mod = new DoubleModel();
            mod.Doubles = new[] {3d, 2d, 1d};
            
            var val = new LastFunctionOnVariableContainingAnArrayValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
            Assert.IsTrue(res.Errors[0].Error.Equals("error"));
        }
        
        [TestMethod]
        public void LastFunctionOnVariableContainingAVariableContainingAVariableContainingAnArrayValidator()
        {
            DoubleModel mod = new DoubleModel();
            mod.Doubles = new[] {3d, 2d, 1d};
            
            var val = new LastFunctionOnVariableContainingAVariableContainingAVariableContainingAnArrayValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
            Assert.IsTrue(res.Errors[0].Error.Equals("error"));
        }
        
        [TestMethod]
        public void LastFunctionOnVariableContainingAFunctionWithVariableValidator()
        {
            DoubleModel mod = new DoubleModel();
            mod.Doubles = new[] {3d, 2d, 1d};
            
            var val = new LastFunctionOnVariableContainingAFunctionWithVariableValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
            Assert.IsTrue(res.Errors[0].Error.Equals("error"));
        }
        
        [TestMethod]
        public void LastFunctionOnVariableContainingAFunctionWithPropertyValidator()
        {
            DoubleModel mod = new DoubleModel();
            mod.Doubles = new[] {3d, 2d, 1d};
            
            var val = new LastFunctionOnVariableContainingAFunctionWithPropertyValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
            Assert.IsTrue(res.Errors[0].Error.Equals("error"));
        }
        
        [TestMethod]
        public void LastFunctionOnVariableContainingAFunctionValidator()
        {
            DoubleModel mod = new DoubleModel();
            mod.Doubles = new[] {3d, 2d, 1d};
            
            var val = new LastFunctionOnVariableContainingAFunctionValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
            Assert.IsTrue(res.Errors[0].Error.Equals("error"));
        }
        
        [TestMethod]
        public void LastFunctionOnSimpleStringArrayValidator()
        {
            StringModel mod = new StringModel();
            mod.Strings = new[] {"apple", "pear", "banana"};
            
            var val = new LastFunctionOnSimpleStringArrayValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
            Assert.IsTrue(res.Errors[0].Error.Equals("error"));
        }
        
        [TestMethod]
        public void LastFunctionOnSimpleNumberArrayValidator()
        {
            IntModel mod = new IntModel();
            mod.Ints = new[] {1,2,3};
            
            var val = new LastFunctionOnSimpleNumberArrayValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
            Assert.IsTrue(res.Errors[0].Error.Equals("error"));
        }
        
        [TestMethod]
        public void LastFunctionOnSimpleBoolArrayValidator()
        {
            BooleanModel mod = new BooleanModel();
            mod.Booleans = new[] {false,false,true};
            
            var val = new LastFunctionOnSimpleBoolArrayValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
            Assert.IsTrue(res.Errors[0].Error.Equals("error"));
        }
    }
}