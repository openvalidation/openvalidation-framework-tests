using System;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Model;
using OpenValidationFramework_CSharp.Model.Primitive;

namespace io.openvalidation.integration.tests
{
    public class
        LastFunctionOnVariableContainingAFunctionWithVariableValidator : HUMLFramework.IOpenValidator
    {
        public HUMLFramework huml;

        public LastFunctionOnVariableContainingAFunctionWithVariableValidator()
        {
            huml = new HUMLFramework();


            var array = huml.CreateVariable("array", (DoubleModel model) => model.Doubles);

            var last2Array =
                huml.CreateVariable("last2Array", (DoubleModel model) => huml.LAST(array.GetValue(model), 2.0));

            var X = huml.CreateVariable("X", (DoubleModel model) => huml.LAST(last2Array.GetValue(model)));

            huml.appendRule("",
                new string[] {"numbers"},
                "error",
                (DoubleModel model) => huml.EQUALS(X.GetValue(model), 1.0),
                false
            );
        }

        public String ValidatorID
        {
            get { return ""; }
        }

        public HUMLFramework.OpenValidationSummary Validate(DoubleModel model)
        {
            return huml.validate(model);
        }

        public HUMLFramework.OpenValidationSummary Validate(Object model)
        {
            return this.Validate((DoubleModel) model);
        }
    }
}