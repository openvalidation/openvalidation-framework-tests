using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;

namespace FrameworkTests.Comparisons
{
    [TestClass]
    public class LessThanTests
    {
        
        [TestMethod]
        public void int_1_less_than_2_should_be_true()
        {
            var huml = new HUMLFramework();
            int input = 1;
            Assert.IsTrue(huml.LESS_THAN(input, 2));
        }

        [TestMethod]
        public void int_2_less_than_1_should_be_false()
        {
            var huml = new HUMLFramework();
            int input = 2;
            Assert.IsFalse(huml.LESS_THAN(input, 1));
        }

        [TestMethod]
        public void double_1_less_than_2_should_be_true()
        {
            var huml = new HUMLFramework();
            double input = 1.0;
            Assert.IsTrue(huml.LESS_THAN(input, 2.2));
        }

        [TestMethod]
        public void double_2_less_than_1_should_be_false()
        {
            var huml = new HUMLFramework();
            double input = 2.2;
            Assert.IsFalse(huml.LESS_THAN(input, 1.1));
        }
    }
}