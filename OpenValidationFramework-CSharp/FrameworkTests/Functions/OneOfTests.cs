using System;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;

namespace FrameworkTests.Functions
{
    [TestClass]
    public class OneOfTests
    {

        [TestMethod]
        public void int_1_one_of_int_array_should_be_true()
        {
            var huml = new HUMLFramework();
            int input = 1;
            int[] values = { 1, 2, 3, 4, 5, 6, 7, 19 };

            Assert.IsTrue(huml.ONE_OF(input, values));
        }

        [TestMethod]
        public void int_1_one_of_int_array_should_be_false()
        {
            var huml = new HUMLFramework();
            int input = 17;
            int[] values = { 1, 2, 3, 4, 5, 6, 7, 19 };

            Assert.IsFalse(huml.ONE_OF(input, values));
        }

        [TestMethod]
        public void string_name_one_of_string_array_should_be_true()
        {
            var huml = new HUMLFramework();
            string input = "Heinz";
            string[] values = { "Heinz", "Peter", "Karl", "Klaus", "Dieter" };

            Assert.IsTrue(huml.ONE_OF(input, values));
        }

        [TestMethod]
        public void string_name_one_of_string_array_should_be_false()
        {
            var huml = new HUMLFramework();
            string input = "Friedhelm";
            string[] values = { "Heinz", "Peter", "Karl", "Klaus", "Dieter" };

            Assert.IsFalse(huml.ONE_OF(input, values));
        }

        [TestMethod]
        public void object_guid_one_of_object_array_should_be_true()
        {
            var huml = new HUMLFramework();
            object input = Guid.NewGuid();
            object[] values = { input, "Peter", "Karl", "Klaus", "Dieter" };

            Assert.IsTrue(huml.ONE_OF(input, values));
        }

        [TestMethod]
        public void object_guid_one_of_object_array_should_be_false()
        {
            var huml = new HUMLFramework();
            object input = Guid.NewGuid();
            object[] values = { "Heinz", "Peter", "Karl", "Klaus", "Dieter", Guid.NewGuid() };

            Assert.IsFalse(huml.ONE_OF(input, values));
        }


        [DataTestMethod]
        [DataRow(true, new int[] { 0, 1, 2 })]
        [DataRow(false, new int[] { 1, 2, 3 })]
        [DataRow(false, new int[] { })]
        public void zero_as_int_is_one_of_int_values(bool expected, int[] values)
        {
            var huml = new HUMLFramework();
            Assert.AreEqual(expected, huml.ONE_OF(0, values));
        }


        [DataTestMethod]
        [DataRow(true, new double[] { 0.0, 1.0, 2.0 })]
        [DataRow(false, new double[] { 1.0, 2.0, 3.0 })]
        [DataRow(false, new double[] { })]
        public void zero_as_int_is_one_of_double_values(bool expected, double[] values)
        {
            var huml = new HUMLFramework();
            Assert.AreEqual(expected, huml.ONE_OF(0, values));
        }

        //lazevedo 19.2.20  This testcase gives a syntax error due to the paramterization of huml.ONE_OF. For now this testcase is ignored to see wheather the test scenario is possible
        //[DataTestMethod]
        //[DataRow(true, new int[] { 0, 1, 2 })]
        //[DataRow(false, new int[] { 1, 2, 3 })]
        //[DataRow(false, new int[] { })]
        //public void zero_as_double_is_one_of_int_values(bool expected, int[] values)
        //{
        //    var huml = new HUMLFramework();
        //    Assert.AreEqual(expected, huml.ONE_OF(0.0, values));
        //}


        [DataTestMethod]
        [DataRow(true, new double[] { 0.0, 1.0, 2.0 })]
        [DataRow(false, new double[] { 1.0, 2.0, 3.0 })]
        [DataRow(false, new double[] { })]
        public void zero_as_double_is_one_of_double_values(bool expected, double[] values)
        {
            var huml = new HUMLFramework();
            Assert.AreEqual(expected, huml.ONE_OF(0.0, values));
        }
    }
}