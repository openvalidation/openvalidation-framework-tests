using io.openvalidation.integration.Variables;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using NUnit.Framework;
using OpenValidationFramework_CSharp.Model;
using Assert = Microsoft.VisualStudio.TestTools.UnitTesting.Assert;

namespace FrameworkTests.ValidatorRunners
{
    /*
     * Peter as nameVar
     * 
     * Hans, name and stringVar as nameArray
     * 
     * The profession should not be one of nameArray
     * 
     * 
     * {name: "", profession: ""}
     */

    [TestClass]
    public class VariableValidationRunner
    {
        ValidatorVariableArrayContainingStaticPropertyVariable validator = new ValidatorVariableArrayContainingStaticPropertyVariable();

        [DataTestMethod]
        [DataRow("Peter", true)]
        [DataRow("Hans", true)]
        [DataRow("Klaus", true)]
        [DataRow("Simon", false)]
        public void VariableValidator_variable_contains_static_string_proeprty_string_and_variable_string(string input, bool expected)
        {
            DefaultModel model = new DefaultModel();
            model.Name = "Klaus";
            model.Profession = input;

            var res = validator.Validate(model);

            Assert.AreEqual(expected, res.HasErrors);

            if(expected)
            {
                Assert.AreEqual(1, res.Errors.Length);
                Assert.AreEqual("The profession should not be one of nameArray", res.Errors[0].Error);
            }
        }

    }
}
