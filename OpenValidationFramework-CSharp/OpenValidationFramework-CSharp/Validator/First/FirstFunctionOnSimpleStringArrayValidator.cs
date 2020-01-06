using System;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Model;
using OpenValidationFramework_CSharp.Model.Primitive;

namespace OpenValidationFramework_CSharp.Validator.First
{
    public class FirstFunctionOnSimpleStringArrayValidator : HUMLFramework.IOpenValidator
    {
        public HUMLFramework huml;

        public FirstFunctionOnSimpleStringArrayValidator()
        {
            huml = new HUMLFramework();


            var X = huml.CreateVariable("X", (StringModel model) => huml.FIRST(model.Strings));

            huml.appendRule("",
                new String[] {"fruits"},
                "error",
                (StringModel model) => huml.EQUALS(X.GetValue(model), "banana"),
                false
            );
        }

        public String ValidatorID
        {
            get { return ""; }
        }

        public HUMLFramework.OpenValidationSummary Validate(StringModel model)
        {
            return huml.validate(model);
        }

        public HUMLFramework.OpenValidationSummary Validate(Object model)
        {
            return this.Validate((StringModel) model);
        }
    }
}