using System;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Model;

namespace FrameworkTests.Functions
{
    [TestClass]
    public class NoneOfTests
    {
        HUMLFramework huml = new HUMLFramework();

        [TestMethod]
        public void int_1_none_of_int_array_should_be_false()
        {
            int input = 1;
            int[] values = {1, 2, 3, 4, 5, 6, 7, 19};

            Assert.IsFalse(huml.NONE_OF(input, values));
        }
        
        [TestMethod]
        public void int_1_none_of_int_array_should_be_true()
        {
            int input = 17;
            int[] values = {1, 2, 3, 4, 5, 6, 7, 19};

            Assert.IsTrue(huml.NONE_OF(input, values));
        }
        
        [TestMethod]
        public void string_name_none_of_string_array_should_be_false()
        {
            string input = "Heinz";
            string[] values = {"Heinz", "Peter", "Karl", "Klaus", "Dieter"};

            Assert.IsFalse(huml.NONE_OF(input, values));
        }
        
        [TestMethod]
        public void string_name_none_of_string_array_should_be_true()
        {
            string input = "Friedhelm";
            string[] values = {"Heinz", "Peter", "Karl", "Klaus", "Dieter"};

            Assert.IsTrue(huml.NONE_OF(input, values));
        }
        
        [TestMethod]
        public void object_guid_none_of_object_array_should_be_false()
        {
            object input = Guid.NewGuid();
            object[] values = {input, "Peter", "Karl", "Klaus", "Dieter"};

            Assert.IsFalse(huml.NONE_OF(input, values));
        }
        
        [TestMethod]
        public void object_guid_none_of_object_array_should_be_true()
        {
            object input = Guid.NewGuid();
            object[] values = {"Heinz", "Peter", "Karl", "Klaus", "Dieter", Guid.NewGuid()};

            Assert.IsTrue(huml.NONE_OF(input, values));
        }
    }
}