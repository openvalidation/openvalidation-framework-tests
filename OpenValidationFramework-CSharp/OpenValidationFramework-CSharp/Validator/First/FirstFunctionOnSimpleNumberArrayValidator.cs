using System;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Model;
using OpenValidationFramework_CSharp.Model.Primitive;

namespace OpenValidationFramework_CSharp.Validator.First
{
    public class FirstFunctionOnSimpleNumberArrayValidator : HUMLFramework.IOpenValidator
    {
        public HUMLFramework huml;

        public FirstFunctionOnSimpleNumberArrayValidator()
        {
            huml = new HUMLFramework();


            var X = huml.CreateVariable("X",
                (IntModel model) =>
                    huml.FIRST(model.Ints));

            huml.appendRule("",
                new String[] {"numbers"},
                "error",
                (IntModel model) =>
                    huml.EQUALS(X.GetValue(model), 1.0),
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