using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Text;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Model;

namespace FrameworkTests
{
    [TestClass]
    public class CreateArrayTest
    {
        HUMLFramework huml = new HUMLFramework();

        [TestMethod]
        public void create_array_on_string_params()
        {
            string[] stringArr = huml.CREATE_ARRAY("Berlin", "Paris", "London");
            Assert.AreEqual(stringArr.Length, 3);
            Assert.AreEqual(stringArr[0], "Berlin");
            Assert.AreEqual(stringArr[1], "Paris");
            Assert.AreEqual(stringArr[2], "London");
        }

        [TestMethod]
        public void create_array_on_string_array()
        {
            string[] stringArr = huml.CREATE_ARRAY(new string[] { "Berlin", "Paris", "London" });
            Assert.AreEqual(stringArr.Length, 3);
            Assert.AreEqual(stringArr[0], "Berlin");
            Assert.AreEqual(stringArr[1], "Paris");
            Assert.AreEqual(stringArr[2], "London");
        }

        [TestMethod]
        public void create_array_on_number_params()
        {
            double[] stringArr = huml.CREATE_ARRAY(-1, 0, 3.1415);
            Assert.AreEqual(stringArr.Length, 3);
            Assert.AreEqual(stringArr[0], -1);
            Assert.AreEqual(stringArr[1], 0);
            Assert.AreEqual(stringArr[2], 3.1415);
        }

        [TestMethod]
        public void create_array_on_number_array()
        {
            double[] stringArr = huml.CREATE_ARRAY(new double[] { -1, 0, 3.1415 });
            Assert.AreEqual(stringArr.Length, 3);
            Assert.AreEqual(stringArr[0], -1);
            Assert.AreEqual(stringArr[1], 0);
            Assert.AreEqual(stringArr[2], 3.1415);
        }
    }
}
