using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Validator;
using OpenValidationFramework_CSharp.Model;

namespace FrameworkTests
{
    [TestClass]
    public class IntegrationTests
    {
        [TestMethod]
        public void executeRunner()
        {
            Runner runner = new Runner();
            runner.run();
        }

        [TestMethod]
        public void Validator_should_have_errors()
        {
            DefaultModel mod = new DefaultModel();
            mod.Name = "Berry";
            HUMLValidator val = new HUMLValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
        }

        [TestMethod]
        public void LastValidator_should_have_errors()
        {
            LastModel mod = new LastModel();
            mod.Numbers.Add(3);
            mod.Numbers.Add(2);
            mod.Numbers.Add(1);
            
            LastTestValidator val = new LastTestValidator();
            var res = val.Validate(mod);
            
            Assert.IsTrue(res.HasErrors);
        }
    }
}