using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;

namespace FrameworkTests.Comparisons
{
    [TestClass]
    public class NotEqualsTests
    {
        [TestMethod]
        public void string_name_not_equals_name_should_be_false()
        {
            var huml = new HUMLFramework();
            string input = "name";
            Assert.IsFalse(huml.NOT_EQUALS(input, "name"));
        }

        [TestMethod]
        public void int_1_not_equals_1_should_be_false()
        {
            var huml = new HUMLFramework();
            int input = 1;
            Assert.IsFalse(huml.NOT_EQUALS(input, 1));
        }

        [TestMethod]
        public void double_1_not_equals_1_should_be_false()
        {
            var huml = new HUMLFramework();
            double input = 1.0;
            Assert.IsFalse(huml.NOT_EQUALS(input, 1.0));
        }

        [TestMethod]
        public void double_1_not_equals_int_1_should_be_false()
        {
            var huml = new HUMLFramework();
            double input = 1.0;
            Assert.IsFalse(huml.NOT_EQUALS(input, 1));
        }

        [TestMethod]
        public void int_1_not_equals_double_1_should_be_false()
        {
            var huml = new HUMLFramework();
            int input = 1;
            Assert.IsFalse(huml.NOT_EQUALS(input, 1.0));
        }

        [TestMethod]
        public void int_1_not_equals_int_2_should_be_true()
        {
            var huml = new HUMLFramework();
            int input = 1;
            Assert.IsTrue(huml.NOT_EQUALS(input, 2));
        }
    }
}