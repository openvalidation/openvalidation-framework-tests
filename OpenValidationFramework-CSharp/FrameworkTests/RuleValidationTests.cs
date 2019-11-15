using System;

using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Data;

namespace FrameworkTests
{
    [TestClass]
    public class RuleValidationTests
    {
        [TestMethod]
        public void validate_rule_test_should_succeed()
        {
            Model person = new Model();
            person.Name = "Jerry";
            var huml = new HUMLFramework();
            var rule = huml.appendRule<Model>("JerryRule",
                new String[]
                {
                    "Name"
                },
                "Name must be Jerry",
                model => huml.NOT_EQUALS(model.Name,
                    "Jerry"),
                false);

            var result = rule.Validate(person);
            
            Assert.IsFalse(result.HasErrors);
        }
        
        [TestMethod]
        public void validate_rule_test_should_fail()
        {
            Model person = new Model();
            person.Name = "Karl";
            var huml = new HUMLFramework();
            var rule = huml.appendRule<Model>("JerryRule",
                new String[]
                {
                    "Name"
                },
                "Name must be Jerry",
                model => huml.NOT_EQUALS(model.Name,
                    "Jerry"),
                false);

            var result = rule.Validate(person);
            
            Assert.IsTrue(result.HasErrors);
        }
        
        [TestMethod]
        public void validate_framework_error_should_match_rule_error()
        {
            Model person = new Model();
            person.Name = "Karl";
            var huml = new HUMLFramework();
            var rule = huml.appendRule<Model>("firstRule",
                new String[]
                {
                    "Name"
                },
                "Name must be Jerry",
                model => huml.NOT_EQUALS(model.Name,
                    "Jerry"),
                false);

            var result = huml.validate(person);
            
            Assert.IsTrue(result.HasErrors);
            Assert.AreEqual(result.Errors[0].Error, rule.Error);
        }
        
        [TestMethod]
        public void validateRule_framework_error_should_match_rule_error()
        {
            Model person = new Model();
            person.Name = "Karl";
            var huml = new HUMLFramework();
            var rule = huml.appendRule<Model>("",
                new String[]
                {
                    "Name"
                },
                "Name must be Jerry",
                model => huml.NOT_EQUALS(model.Name,
                    "Jerry"),
                false);

            var rules = huml.Rules;
            
            var result = huml.ValidateRule(person, rule.Name);
            
            Assert.IsTrue(result.HasErrors);
            Assert.AreEqual(result.GetError(), rule.Error);
        }
        
        
    }
}