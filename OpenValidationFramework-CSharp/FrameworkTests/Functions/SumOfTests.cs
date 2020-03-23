using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Model;

namespace FrameworkTests.Functions
{
    [TestClass]
    public class SumOfTests
    {
        HUMLFramework huml = new HUMLFramework();


        //arrays
        [TestMethod]
        public void sum_of_1_2_3_4_5_as_decimal_array_should_be_15()
        {
            var arr = new Decimal[]
            {
                1, 2, 3, 4, 5
            };

            Assert.AreEqual(huml.SUM_OF(arr), 15);
        }
        
        [TestMethod]
        public void sum_of_1_2_3_4_5_as_double_array_should_be_15()
        {
            var arr = new Double[]
            {
                1, 2, 3, 4, 5
            };
            
            Assert.AreEqual(huml.SUM_OF(arr), 15);
        }

        [TestMethod]
        public void sum_of_1_2_3_4_5_as_int_array_should_be_15()
        {
            var arr = new int[]
            {
                1, 2, 3, 4, 5
            };

            Assert.AreEqual(huml.SUM_OF(arr), 15);
        }

        [TestMethod]
        public void sum_of_1_2_3_4_5_as_generic_variable_int_array_should_be_15()
        {
            var arr = huml.CreateVariable("arr", (DefaultModel model) => new int[] { 1, 2, 3, 4, 5 });

            Assert.AreEqual(huml.SUM_OF(arr.GetValue(new DefaultModel())), 15);
        }

        //lists
        [TestMethod]
        public void sum_of_1_2_3_4_5_as_decimal_list_should_be_15()
        {
            var arr = new List<decimal>
            {
                1, 2, 3, 4, 5
            };

            Assert.AreEqual(huml.SUM_OF(arr), 15);
        }

        [TestMethod]
        public void sum_of_1_2_3_4_5_as_double_list_should_be_15()
        {
            var arr = new List<double>
            {
                1, 2, 3, 4, 5
            };

            Assert.AreEqual(huml.SUM_OF(arr), 15);
        }

        [TestMethod]
        public void sum_of_1_2_3_4_5_as_int_list_should_be_15()
        {
            var arr = new List<int>
            {
                1, 2, 3, 4, 5
            };

            Assert.AreEqual(huml.SUM_OF(arr), 15);
        }

        [TestMethod]
        public void sum_of_1_2_3_4_5_as_generic_variable_int_list_should_be_15()
        {
            var arr = huml.CreateVariable("arr", (DefaultModel model) => new List<int>(){ 1, 2, 3, 4, 5 });

            Assert.AreEqual(huml.SUM_OF(arr.GetValue(new DefaultModel())), 15);
        }
    }
}