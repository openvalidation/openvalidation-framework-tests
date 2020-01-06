using System;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Model;
using OpenValidationFramework_CSharp.Model.Primitive;

namespace OpenValidationFramework_CSharp.Validator.First
{
    public class FirstFunctionOnVariableContainingAnArrayValidator : HUMLFramework.IOpenValidator
    {
        public HUMLFramework huml;

        public FirstFunctionOnVariableContainingAnArrayValidator()
        {
            huml = new HUMLFramework();


            var array = huml.CreateVariable("array", (DoubleModel model) => model.Doubles);

            var X = huml.CreateVariable("X", (DoubleModel model) => huml.FIRST(array.GetValue(model)));

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