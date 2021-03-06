using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;

namespace FrameworkTests.Functions
{
    [TestClass]
    public class AtLeastOneOfTests
    {
        
        [TestMethod]
        public void int_1_at_least_one_of_int_array_should_be_true()
        {
            var huml = new HUMLFramework();
            int input = 1;
            int[] values = {1, 2, 3, 4, 5, 6, 7, 19};

            Assert.IsTrue(huml.AT_LEAST_ONE_OF(input, values));
        }
        
        [TestMethod]
        public void int_1_at_least_one_of_int_array_should_be_false()
        {
            var huml = new HUMLFramework();
            int input = 17;
            int[] values = {1, 2, 3, 4, 5, 6, 7, 19};

            Assert.IsFalse(huml.AT_LEAST_ONE_OF(input, values));
        }
        
        [TestMethod]
        public void string_name_at_least_one_of_string_array_should_be_true()
        {
            var huml = new HUMLFramework();
            string input = "Heinz";
            string[] values = {"Heinz", "Peter", "Karl", "Klaus", "Dieter"};

            Assert.IsTrue(huml.AT_LEAST_ONE_OF(input, values));
        }
        
        [TestMethod]
        public void string_name_at_least_one_of_string_array_should_be_false()
        {
            var huml = new HUMLFramework();
            string input = "Friedhelm";
            string[] values = {"Heinz", "Peter", "Karl", "Klaus", "Dieter"};

            Assert.IsFalse(huml.AT_LEAST_ONE_OF(input, values));
        }
        
        [TestMethod]
        public void object_guid_at_least_one_of_object_array_should_be_true()
        {
            var huml = new HUMLFramework();
            object input = Guid.NewGuid();
            object[] values = {input, "Peter", "Karl", "Klaus", "Dieter"};

            Assert.IsTrue(huml.AT_LEAST_ONE_OF(input, values));
        }
        
        [TestMethod]
        public void object_guid_at_least_one_of_object_array_should_be_false()
        {
            var huml = new HUMLFramework();
            object input = Guid.NewGuid();
            object[] values = {"Heinz", "Peter", "Karl", "Klaus", "Dieter", Guid.NewGuid()};

            Assert.IsFalse(huml.AT_LEAST_ONE_OF(input, values));
        }
        
    }
}