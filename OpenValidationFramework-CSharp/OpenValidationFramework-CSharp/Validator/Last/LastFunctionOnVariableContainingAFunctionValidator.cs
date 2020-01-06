using System;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Model;
using OpenValidationFramework_CSharp.Model.Primitive;

namespace io.openvalidation.integration.tests
{
    public class LastFunctionOnVariableContainingAFunctionValidator : HUMLFramework.IOpenValidator
    {
        public HUMLFramework huml;

        public LastFunctionOnVariableContainingAFunctionValidator()
        {
            huml = new HUMLFramework();


            var array = huml.CreateVariable("array", (DoubleModel model) => huml.LAST(model.Doubles, 2.0));

            var X = huml.CreateVariable("X", (DoubleModel model) => huml.LAST(array.GetValue(model)));

            huml.appendRule("",
                new String[] {"numbers"},
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