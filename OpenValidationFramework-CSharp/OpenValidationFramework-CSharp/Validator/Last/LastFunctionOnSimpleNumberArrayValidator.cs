using System;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Model;
using OpenValidationFramework_CSharp.Model.Primitive;

namespace io.openvalidation.integration.tests
{
    public class LastFunctionOnSimpleNumberArrayValidator : HUMLFramework.IOpenValidator
    {
        public HUMLFramework huml;

        public LastFunctionOnSimpleNumberArrayValidator()
        {
            huml = new HUMLFramework();


            var X = huml.CreateVariable("X", (IntModel model) => huml.LAST(model.Ints));

            huml.appendRule("",
                new String[] {"numbers"},
                "error",
                (IntModel model) => huml.EQUALS(X.GetValue(model), 3.0),
                false
            );
        }

        public String ValidatorID
        {
            get { return ""; }
        }

        public HUMLFramework.OpenValidationSummary Validate(IntModel model)
        {
            return huml.validate(model);
        }

        public HUMLFramework.OpenValidationSummary Validate(Object model)
        {
            return this.Validate((IntModel) model);
        }
    }
}