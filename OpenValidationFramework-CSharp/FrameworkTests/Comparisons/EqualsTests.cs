using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;

namespace FrameworkTests.Comparisons
{
    [TestClass]
    public class EqualsTests
    {
        [TestMethod]
        public void equals_string_name_should_be_name()
        {
            var huml = new HUMLFramework();
            string input = "name";
            Assert.IsTrue(huml.EQUALS(input, "name"));
        }

        [TestMethod]
        public void equals_int_1_should_be_1()
        {
            var huml = new HUMLFramework();
            int input = 1;
            Assert.IsTrue(huml.EQUALS(input, 1));
        }

        [TestMethod]
        public void equals_double_1_should_be_1()
        {
            var huml = new HUMLFramework();
            double input = 1.0;
            Assert.IsTrue(huml.EQUALS(input, 1.0));
        }

        [TestMethod]
        public void equals_double_1_should_be_int_1()
        {
            var huml = new HUMLFramework();
            double input = 1.0;
            Assert.IsTrue(huml.EQUALS(input, 1));
        }

        [TestMethod]
        public void equals_int_1_should_be_double_1()
        {
            var huml = new HUMLFramework();
            int input = 1;
            Assert.IsTrue(huml.EQUALS(input, 1.0));
        }

        [TestMethod]
        public void equals_int_1_should_not_be_int_2()
        {
            var huml = new HUMLFramework();
            int input = 1;
            Assert.IsFalse(huml.EQUALS(input, 2));
        }
    }
}