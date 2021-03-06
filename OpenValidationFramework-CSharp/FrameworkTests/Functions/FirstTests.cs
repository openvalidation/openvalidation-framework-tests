using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Model;

namespace FrameworkTests.Functions
{
    [TestClass]
    public class FirstTests
    {
        private HUMLFramework _huml = new HUMLFramework();
        [TestMethod]
        public void First_numbersInList_1()
        {
            List<int> nums = new List<int>() { 1, 2, 3, 4, 5, 6};
            
            Assert.AreEqual(_huml.FIRST(nums, 1).Length, 1);
            Assert.AreEqual(_huml.FIRST(nums, 1).FirstOrDefault(), 1);
        }
        
        [TestMethod]
        public void First_numbersInList_3()
        {
            List<int> nums = new List<int>() { 1, 2, 3, 4, 5, 6};
            
            Assert.AreEqual(_huml.FIRST(nums, 3).Length, 3);
            Assert.AreEqual(_huml.FIRST(nums, 3).ElementAt(0), 1);
            Assert.AreEqual(_huml.FIRST(nums, 3).ElementAt(1), 2);
            Assert.AreEqual(_huml.FIRST(nums, 3).ElementAt(2), 3);
        }
        
        [TestMethod]
        public void First_numbersInArray_3()
        {
            int[] nums = new int[] { 1, 2, 3, 4, 5, 6};
            
            Assert.AreEqual(_huml.FIRST(nums, 3).Length, 3);
            Assert.AreEqual(_huml.FIRST(nums, 3).ElementAt(0), 1);
            Assert.AreEqual(_huml.FIRST(nums, 3).ElementAt(1), 2);
            Assert.AreEqual(_huml.FIRST(nums, 3).ElementAt(2), 3);
        }

        [TestMethod]
        public void First_with_generic_variable_array()
        {
            Object objectStringA = "a";
            Object objectStringZ = "z";

            var var = _huml.CreateVariable("var", (DefaultModel model) => new String[] { "a", "b", "c" });

            Assert.AreEqual("a", _huml.FIRST(var.GetValue(new DefaultModel())));
            Assert.AreNotEqual("z", _huml.FIRST(var.GetValue(new DefaultModel())));

            Assert.AreEqual(objectStringA, _huml.FIRST(var.GetValue(new DefaultModel())));
            Assert.AreNotEqual(objectStringZ, _huml.FIRST(var.GetValue(new DefaultModel())));
        }

        [TestMethod]
        public void First_with_generic_variable_list()
        {
            string objectStringA = "a";
            string objectStringZ = "z";

            var var = _huml.CreateVariable("var", (DefaultModel model) => new List<string>{ "a" , "b", "c" });

            Assert.AreEqual("a", _huml.FIRST(var.GetValue(new DefaultModel())));
            Assert.AreNotEqual("z", _huml.FIRST(var.GetValue(new DefaultModel())));

            Assert.AreEqual(objectStringA, _huml.FIRST(var.GetValue(new DefaultModel())));
            Assert.AreNotEqual(objectStringZ, _huml.FIRST(var.GetValue(new DefaultModel())));
        }
    }
}