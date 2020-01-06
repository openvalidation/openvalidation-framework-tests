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
    public class LastValidatorRunner
    {
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