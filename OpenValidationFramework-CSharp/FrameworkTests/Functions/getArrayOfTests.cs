using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;

namespace FrameworkTests.Functions
{
    [TestClass]
    public class getArrayOfTests
    {
        [TestMethod]
        public void list_getArrayOf_numbers()
        {
            HUMLFramework huml = new HUMLFramework();
            List<int> nums = new List<int>() { 1, 2, 3, 4, 5, 6};
            
            Assert.IsTrue(huml.getArrayOf(nums).Contains(1));
            Assert.IsTrue(huml.getArrayOf(nums).Contains(2));
            Assert.IsTrue(huml.getArrayOf(nums).Contains(3));
            Assert.IsTrue(huml.getArrayOf(nums).Contains(4));
            Assert.IsTrue(huml.getArrayOf(nums).Contains(5));
            Assert.IsTrue(huml.getArrayOf(nums).Contains(6));
            Assert.AreEqual(huml.getArrayOf(nums).Length, 6);
            Assert.AreEqual(huml.getArrayOf(nums).First(), 1);
            Assert.AreEqual(huml.getArrayOf(nums).Last(), 6);
            
        }
    }
}