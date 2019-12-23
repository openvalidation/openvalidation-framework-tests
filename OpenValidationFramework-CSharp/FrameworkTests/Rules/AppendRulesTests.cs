using System;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Validator;
using OpenValidationFramework_CSharp.Model;

namespace FrameworkTests.Rules
{
    [TestClass]
    public class AppendRulesTests
    {
        [TestMethod]
        public void Validator_hasErrors()
        {
            DefaultModel mod = new DefaultModel();
            mod.Name = "Berry";
            HUMLValidator val = new HUMLValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
        }
        
        [TestMethod]
        public void Validator_has4Rules()
        {
            DefaultModel mod = new DefaultModel();
            mod.Name = "Berry";
            HUMLValidator val = new HUMLValidator();

            Assert.AreEqual(val.huml.Rules.Count, 4);
        }

        [TestMethod]
        public void appendRuleCount()
        {
            HUMLFramework huml = new HUMLFramework();
            huml.appendRule("",
                new String[]{ "name" },
                "name must be Jerry",
                (DefaultModel model) => huml.NOT_EQUALS(model.Name, "Jerry"),
                false
            );
            
            Assert.AreEqual(huml.Rules.Count, 1);
        }
        
        [TestMethod]
        public void appendRuleisEqual()
        {
            HUMLFramework huml = new HUMLFramework();
            var rule = huml.appendRule("",
                new String[]{ "name" },
                "name must be Jerry",
                (DefaultModel model) => huml.NOT_EQUALS(model.Name, "Jerry"),
                false
            );
            
            Assert.AreEqual(huml.Rules.FirstOrDefault(), rule);
        }
    }
}