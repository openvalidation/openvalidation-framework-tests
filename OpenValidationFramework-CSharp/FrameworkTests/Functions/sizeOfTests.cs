using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;

namespace FrameworkTests.Functions
{
    [TestClass]
    public class sizeOfTests
    {
        [TestMethod]
        public void list_sizeof_numbers()
        {
            HUMLFramework huml = new HUMLFramework();
            List<int> nums = new List<int>() { 1, 2, 3, 4, 5, 6};
            
            Assert.AreEqual(huml.sizeOf(nums), 6);
        }
        
        [TestMethod]
        public void array_sizeof_numbers()
        {
            HUMLFramework huml = new HUMLFramework();
            int[] nums = new int[]{ 1, 2, 3, 4, 5, 6};
            
            Assert.AreEqual(huml.sizeOf(nums), 6);
        }
        
        [TestMethod]
        public void generic_sizeof_numbers()
        {
            HUMLFramework huml = new HUMLFramework();
            IEnumerable<int> nums = new List<int>();
            for (int i = 0; i < 6; i++)
                nums = nums.Append(i + 1);
            
            Assert.AreEqual(huml.sizeOf(nums), 6);
        }
    }
}