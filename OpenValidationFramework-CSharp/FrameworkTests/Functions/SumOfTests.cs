using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;

namespace FrameworkTests.Functions
{
    [TestClass]
    public class SumOfTests
    {
        [TestMethod]
        public void sum_of_1_2_3_4_5_should_be_15()
        {
            var huml = new HUMLFramework();

            Assert.AreEqual(huml.SUM_OF(1, 2, 3, 4, 5), 15);
        }

        [TestMethod]
        public void sum_of_1_2_3_4_5_as_decimal_array_should_be_15()
        {
            var huml = new HUMLFramework();
            var arr = new Decimal[]
            {
                1, 2, 3, 4, 5
            };

            Assert.AreEqual(huml.SUM_OF(arr), 15);
        }
        
        [TestMethod]
        public void sum_of_1_2_3_4_5_as_double_array_should_be_15()
        {
            var huml = new HUMLFramework();
            var arr = new Double[]
            {
                1, 2, 3, 4, 5
            };
            
            Assert.AreEqual(huml.SUM_OF(arr), 15);
        }
        
        [TestMethod]
        public void sum_of_1_2_3_4_5_as_int_array_should_be_15()
        {
            var huml = new HUMLFramework();
            var arr = new int[]
            {
                1, 2, 3, 4, 5
            };
            
            Assert.AreEqual(huml.SUM_OF(arr), 15);
        }
    }
}