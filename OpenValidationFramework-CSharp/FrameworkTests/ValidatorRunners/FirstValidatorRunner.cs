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
    public class FirstValidatorRunner
    {
        [TestMethod]
        public void FirstFunctionOnVariableContainingAnArrayValidator()
        {
            DoubleModel mod = new DoubleModel();
            mod.Doubles = new[] {1d, 2d, 3d};
            
            var val = new FirstFunctionOnVariableContainingAnArrayValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
            Assert.IsTrue(res.Errors[0].Error.Equals("error"));
        }
        
        [TestMethod]
        public void FirstFunctionOnVariableContainingAVariableContainingAnArrayValidator()
        {
            DoubleModel mod = new DoubleModel();
            mod.Doubles = new[] {1d, 2d, 3d};
            
            var val = new FirstFunctionOnVariableContainingAVariableContainingAnArrayValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
            Assert.IsTrue(res.Errors[0].Error.Equals("error"));
        }
        
        [TestMethod]
        public void FirstFunctionOnVariableContainingAFunctionWithVariableValidator()
        {
            DoubleModel mod = new DoubleModel();
            mod.Doubles = new[] {1d, 2d, 3d};
            
            var val = new FirstFunctionOnVariableContainingAFunctionWithVariableValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
            Assert.IsTrue(res.Errors[0].Error.Equals("error"));
        }
        
        [TestMethod]
        public void FirstFunctionOnVariableContainingAFunctionWithPropertyValidator()
        {
            DoubleModel mod = new DoubleModel();
            mod.Doubles = new[] {1d, 2d, 3d};
            
            var val = new FirstFunctionOnVariableContainingAFunctionWithPropertyValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
            Assert.IsTrue(res.Errors[0].Error.Equals("error"));
        }
        
        [TestMethod]
        public void FirstFunctionOnVariableContainingAFunctionValidator()
        {
            DoubleModel mod = new DoubleModel();
            mod.Doubles = new[] {1d, 2d, 3d};
            
            var val = new FirstFunctionOnVariableContainingAFunctionValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
            Assert.IsTrue(res.Errors[0].Error.Equals("error"));
        }
        
        [TestMethod]
        public void FirstFunctionOnSimpleStringArrayValidator()
        {
            StringModel mod = new StringModel();
            mod.Strings = new[] {"banana","apple", "pear"};
            
            var val = new FirstFunctionOnSimpleStringArrayValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
            Assert.IsTrue(res.Errors[0].Error.Equals("error"));
        }
        
        [TestMethod]
        public void FirstFunctionOnSimpleNumberArrayValidator()
        {
            IntModel mod = new IntModel();
            mod.Ints = new[] {1,2,3};
            
            var val = new FirstFunctionOnSimpleNumberArrayValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
            Assert.IsTrue(res.Errors[0].Error.Equals("error"));
        }
        
        [TestMethod]
        public void FirstFunctionOnSimpleBoolArrayValidator()
        {
            BooleanModel mod = new BooleanModel();
            mod.Booleans = new[] {true,false,false};
            
            var val = new FirstFunctionOnSimpleBoolArrayValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
            Assert.IsTrue(res.Errors[0].Error.Equals("error"));
        }
    }
}