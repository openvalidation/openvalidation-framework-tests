using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;

namespace FrameworkTests.Functions
{
    [TestClass]
    public class atPositionTests
    {
        [TestMethod]
        public void list_atPosition_numbers()
        {
            HUMLFramework huml = new HUMLFramework();
            List<int> nums = new List<int>() { 1, 2, 3, 4, 5, 6};
            
            Assert.AreEqual(huml.atPosition(nums, 0), 1);
            Assert.AreEqual(huml.atPosition(nums, 1), 2);
            Assert.AreEqual(huml.atPosition(nums, 2), 3);
            Assert.AreEqual(huml.atPosition(nums, 3), 4);
            Assert.AreEqual(huml.atPosition(nums, 4), 5);
            Assert.AreEqual(huml.atPosition(nums, 5), 6);
        }
        
        [TestMethod]
        public void array_atPosition_numbers()
        {
            HUMLFramework huml = new HUMLFramework();
            int[] nums = new int[] { 1, 2, 3, 4, 5, 6};
            
            Assert.AreEqual(huml.atPosition(nums, 0), 1);
            Assert.AreEqual(huml.atPosition(nums, 1), 2);
            Assert.AreEqual(huml.atPosition(nums, 2), 3);
            Assert.AreEqual(huml.atPosition(nums, 3), 4);
            Assert.AreEqual(huml.atPosition(nums, 4), 5);
            Assert.AreEqual(huml.atPosition(nums, 5), 6);
        }
        
        [TestMethod]
        public void generic_atPosition_numbers()
        {
            HUMLFramework huml = new HUMLFramework();
            IEnumerable<int> nums = new List<int>();
            for (int i = 0; i < 6; i++)
                nums = nums.Append(i + 1);
            
            Assert.AreEqual(huml.atPosition(nums, 0), 1);
            Assert.AreEqual(huml.atPosition(nums, 1), 2);
            Assert.AreEqual(huml.atPosition(nums, 2), 3);
            Assert.AreEqual(huml.atPosition(nums, 3), 4);
            Assert.AreEqual(huml.atPosition(nums, 4), 5);
            Assert.AreEqual(huml.atPosition(nums, 5), 6);
        }
    }
}