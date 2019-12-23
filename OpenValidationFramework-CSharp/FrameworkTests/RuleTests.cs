using System;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Model;

namespace FrameworkTests
{
    [TestClass]
    public class RuleTests
    {
        [TestMethod]
        public void append_rule_should_exist()
        {
            HUMLFramework huml = new HUMLFramework();
            var rule = huml.appendRule("",
                new String[]{ "Name" },
                "Name MUST be Jerry",
                ( DefaultModel model) => huml.NOT_EQUALS(model.Name, "Jerry"),
                false
            );
            
            Assert.AreEqual(huml.Rules.First(), rule);
            
        }
        
        [TestMethod]
        public void create_validtion_result_from_rule()
        {
            DefaultModel mod = new DefaultModel();
            mod.Name = "Heinz";
            
            HUMLFramework huml = new HUMLFramework();
            var rule = huml.appendRule("",
                new String[]{ "Name" },
                "Name MUST be Jerry",
                ( DefaultModel model) => huml.NOT_EQUALS(model.Name, "Jerry"),
                false
            );

            var result = rule.Validate(mod);
            
            Assert.IsNotNull(result);
            Assert.IsTrue(rule.ExecuteCondition(mod));
        }

    }
}