using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;

namespace FrameworkTests.Functions
{
    [TestClass]
    public class WhereTests
    {
        [TestMethod]
        public void where_numSmaller2()
        {
            var huml = new HUMLFramework();

            int[] nums = new int[] {1, 2, 3};
            
            Assert.AreEqual(huml.WHERE(nums, x => x < 2).Length, 1);
            Assert.AreEqual(huml.WHERE(nums, x => x < 2).GetValue(0), 1);
        }
        
        [TestMethod]
        public void where_numMod3Equals0()
        {
            var huml = new HUMLFramework();

            int[] nums = new int[] {1, 2, 3};
            
            Assert.AreEqual(huml.WHERE(nums, x => x % 3 == 0).Length, 1);
            Assert.AreEqual(huml.WHERE(nums, x => x % 3 == 0).GetValue(0), 3);
        }
        
        [TestMethod]
        public void where_numMod3Equals0WithZero()
        {
            var huml = new HUMLFramework();

            int[] nums = new int[] {0, 1, 2, 3};
            
            Assert.AreEqual(huml.WHERE(nums, x => x % 3 == 0).Length, 2);
            Assert.AreEqual(huml.WHERE(nums, x => x % 3 == 0).GetValue(0), 0);
            Assert.AreEqual(huml.WHERE(nums, x => x % 3 == 0).GetValue(1), 3);
        }
    }
}