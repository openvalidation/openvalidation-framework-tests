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

        //with numerical values as params
        //int
        //int -> int
        [TestMethod]
        public void number_int_should_be_one_of_list_of_type_int()
        {
            var huml = new HUMLFramework();
            int input_left = 1;
            Assert.IsTrue(huml.ONE_OF(input_left, 1, 2, 3));
        }

        [TestMethod]
        public void number_int_should_not_be_one_of_list_of_type_int()
        {
            var huml = new HUMLFramework();
            int input_left = 1;
            Assert.IsFalse(huml.ONE_OF(input_left, 2, 3, 4));
        }

        //int -> double
        [TestMethod]
        public void number_int_should_be_one_of_list_of_type_double()
        {
            var huml = new HUMLFramework();
            int input_left = 1;
            Assert.IsTrue(huml.ONE_OF(input_left, 1.0, 2.0, 3.0));
        }

        [TestMethod]
        public void number_int_should_not_be_one_of_list_of_type_double()
        {
            var huml = new HUMLFramework();
            int input_left = 1;
            Assert.IsFalse(huml.ONE_OF(input_left, 2.0, 3.0, 4.0));
        }


        //double
        //double -> int
        [TestMethod]
        public void number_double_should_be_one_of_list_of_type_int()
        {
            var huml = new HUMLFramework();
            double input_left = 1.0;
            Assert.IsTrue(huml.ONE_OF(input_left, 1, 2, 3));
        }

        [TestMethod]
        public void number_double_should_not_be_one_of_list_of_type_int()
        {
            var huml = new HUMLFramework();
            double input_left = 1.0;
            Assert.IsFalse(huml.ONE_OF(input_left, 2, 3, 4));
        }


        //double -> double
        [TestMethod]
        public void number_double_should_be_one_of_list_of_type_double()
        {
            var huml = new HUMLFramework();
            double input_left = 1.0;
            Assert.IsTrue(huml.ONE_OF(input_left, 1.0, 2.0, 3.0));
        }

        [TestMethod]
        public void number_double_should_not_be_one_of_list_of_type_double()
        {
            var huml = new HUMLFramework();
            double input_left = 1.0;
            Assert.IsFalse(huml.ONE_OF(input_left, 2.0, 3.0, 4.0));
        }
    }
}