using System;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Model;
using OpenValidationFramework_CSharp.Model.Primitive;

namespace OpenValidationFramework_CSharp.Validator.Last
{
    public class LastFunctionOnSimpleBoolArrayValidator : HUMLFramework.IOpenValidator
    {
        public HUMLFramework huml;

        public LastFunctionOnSimpleBoolArrayValidator()
        {
            huml = new HUMLFramework();

            var X = huml.CreateVariable("X", (BooleanModel model) => huml.LAST(model.Booleans));

            huml.appendRule("",
                new String[] {"booleans"},
                "error",
                (BooleanModel model) => huml.EQUALS(X.GetValue(model), true),
                false
            );
        }

        public String ValidatorID
        {
            get { return ""; }
        }

        public HUMLFramework.OpenValidationSummary Validate(BooleanModel model)
        {
            return huml.validate(model);
        }

        public HUMLFramework.OpenValidationSummary Validate(Object model)
        {
            return this.Validate((BooleanModel) model);
        }
    }
}