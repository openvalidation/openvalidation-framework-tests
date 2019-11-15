using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Data;

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
            Model mod = new Model();
            mod.Name = "Berry";
            HUMLValidator val = new HUMLValidator();
            var res = val.Validate(mod);

            Assert.IsTrue(res.HasErrors);
        }
    }
}