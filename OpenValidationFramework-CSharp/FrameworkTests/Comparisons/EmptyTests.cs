using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;

namespace FrameworkTests.Comparisons
{
    [TestClass]
    public class EmptyTests
    {
        [TestMethod]
        public void null_should_be_empty()
        {
            var huml = new HUMLFramework();
            object input = null;
            
            Assert.IsTrue(huml.EMPTY(input));
        }
        
        [TestMethod]
        public void string_jerry_should_not_be_empty()
        {
            var huml = new HUMLFramework();
            String input = "Jerry";
            
            Assert.IsFalse(huml.EMPTY(input));
        }
    }
}