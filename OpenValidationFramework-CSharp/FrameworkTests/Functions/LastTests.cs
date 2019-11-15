using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;

namespace FrameworkTests.Functions
{
    [TestClass]
    public class LastTests
    {
        [TestMethod]
        public void Last_numbersInList_1()
        {
            HUMLFramework huml = new HUMLFramework();
            List<int> nums = new List<int>() { 1, 2, 3, 4, 5, 6};
            
            Assert.AreEqual(huml.LAST(nums, 1).Length, 1);
            Assert.AreEqual(huml.LAST(nums, 1).FirstOrDefault(), 6);
        }
        
        [TestMethod]
        public void Last_numbersInList_3()
        {
            HUMLFramework huml = new HUMLFramework();
            List<int> nums = new List<int>() { 1, 2, 3, 4, 5, 6};
            
            Assert.AreEqual(huml.LAST(nums, 3).Length, 3);
            Assert.AreEqual(huml.LAST(nums, 3).ElementAt(0), 4);
            Assert.AreEqual(huml.LAST(nums, 3).ElementAt(1), 5);
            Assert.AreEqual(huml.LAST(nums, 3).ElementAt(2), 6);
        }
        
        [TestMethod]
        public void LAST_numbersInArray_3()
        {
            HUMLFramework huml = new HUMLFramework();
            int[] nums = new int[] { 1, 2, 3, 4, 5, 6};
            
            Assert.AreEqual(huml.LAST(nums, 3).Length, 3);
            Assert.AreEqual(huml.LAST(nums, 3).ElementAt(0), 4);
            Assert.AreEqual(huml.LAST(nums, 3).ElementAt(1), 5);
            Assert.AreEqual(huml.LAST(nums, 3).ElementAt(2), 6);
        }
    }
}