using System;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Model;

namespace FrameworkTests.Rules
{
    [TestClass]
    public class ValidateRulesTests
    {
        
        
        [TestMethod]
        public void validateFramework_NameIsNotJerry()
        {
            HUMLFramework huml = new HUMLFramework();
            var rule = huml.appendRule("",
                new String[]{ "name" },
                "name must be Jerry",
                (DefaultModel model) => huml.NOT_EQUALS(model.Name, "Jerry"),
                false
            );
            
            Assert.IsTrue(huml.validate(new DefaultModel(){Name = "James"}).HasErrors);
        }
        
        [TestMethod]
        public void validateFramework_NameIsJerry()
        {
            HUMLFramework huml = new HUMLFramework();
            var rule = huml.appendRule("",
                new String[]{ "name" },
                "name must be Jerry",
                (DefaultModel model) => huml.NOT_EQUALS(model.Name, "Jerry"),
                false
            );
            
            Assert.IsFalse(huml.validate(new DefaultModel(){Name = "Jerry"}).HasErrors);
        }
        
        [TestMethod]
        public void validateRule_NameIsJerry()
        {
            HUMLFramework huml = new HUMLFramework();
            var rule = huml.appendRule("",
                new String[]{ "name" },
                "name must be Jerry",
                (DefaultModel model) => huml.NOT_EQUALS(model.Name, "Jerry"),
                false
            );
            
            Assert.IsFalse(rule.Validate(new DefaultModel(){Name = "Jerry"}).HasErrors);
        }
        
        [TestMethod]
        public void validateRule_NameIsNotJerry()
        {
            HUMLFramework huml = new HUMLFramework();
            var rule = huml.appendRule("",
                new String[]{ "name" },
                "name must be Jerry",
                (DefaultModel model) => huml.NOT_EQUALS(model.Name, "Jerry"),
                false
            );
            Assert.IsTrue(rule.Validate(new DefaultModel(){Name = "James"}).HasErrors);
        }
        
        [TestMethod]
        public void executeRuleCondition_NameIsNotJerry()
        {
            HUMLFramework huml = new HUMLFramework();
            var rule = huml.appendRule("",
                new String[]{ "name" },
                "name must be Jerry",
                (DefaultModel model) => huml.NOT_EQUALS(model.Name, "Jerry"),
                false
            );
            
            Assert.IsTrue(rule.ExecuteCondition(new DefaultModel(){Name = "James"}));
        }
        
        [TestMethod]
        public void executeRuleCondition_NameIsJerry()
        {
            HUMLFramework huml = new HUMLFramework();
            var rule = huml.appendRule("",
                new String[]{ "name" },
                "name must be Jerry",
                (DefaultModel model) => huml.NOT_EQUALS(model.Name, "Jerry"),
                false
            );
            
            Assert.IsFalse(rule.ExecuteCondition(new DefaultModel(){Name = "Jerry"}));
        }
    }
}