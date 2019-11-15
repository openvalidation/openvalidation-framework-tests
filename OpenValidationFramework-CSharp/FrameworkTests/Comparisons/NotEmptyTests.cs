using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;

namespace FrameworkTests.Comparisons
{
    [TestClass]
    public class NotEmptyTests
    {
        [TestMethod]
        public void null_not_empty_should_be_false()
        {
            var huml = new HUMLFramework();
            object input = null;
            
            Assert.IsFalse(huml.NOT_EMPTY(input));
        }
        
        [TestMethod]
        public void string_jerry_not_empty_should_be_true()
        {
            var huml = new HUMLFramework();
            String input = "Jerry";
            
            Assert.IsTrue(huml.NOT_EMPTY(input));
        }
    }
}