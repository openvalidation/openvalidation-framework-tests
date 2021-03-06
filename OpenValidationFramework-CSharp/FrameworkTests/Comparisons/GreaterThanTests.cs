using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;

namespace FrameworkTests.Comparisons
{
    [TestClass]
    public class GreaterThanTests
    {
        
        [TestMethod]
        public void int_2_greater_than_1_should_be_true()
        {
            var huml = new HUMLFramework();
            int input = 2;
            Assert.IsTrue(huml.GREATER_THAN(input, 1));
        }

        [TestMethod]
        public void int_1_greater_than_2_should_be_false()
        {
            var huml = new HUMLFramework();
            int input = 1;
            Assert.IsFalse(huml.GREATER_THAN(input, 2));
        }

        [TestMethod]
        public void double_2_greater_than_1_should_be_true()
        {
            var huml = new HUMLFramework();
            double input = 2.0;
            Assert.IsTrue(huml.GREATER_THAN(input, 1.0));
        }

        [TestMethod]
        public void double_1_greater_than_2_should_be_false()
        {
            var huml = new HUMLFramework();
            double input = 1.0;
            Assert.IsFalse(huml.GREATER_THAN(input, 2.2));
        }
    }
}