using System;
using OpenValidationFramework_CSharp.Model;

namespace OpenValidationFramework_CSharp.Validator
{
    public class LastTestValidator
    {
        public HUMLFramework huml;

        public LastTestValidator() //TESTValidator_last_function_on_variable_containing_a_function_with_variable
        {
            huml = new HUMLFramework();

            var array = huml.CreateVariable("array", (LastModel model) => model.Numbers);

            var last2Array = huml.CreateVariable("last2Array", (LastModel model) => huml.LAST(array.GetValue(model), 2.0));

            var X = huml.CreateVariable("X", (LastModel model) => huml.LAST(last2Array.GetValue(model)));

            huml.appendRule("",
                new String[]{ "numbers" },
                "error",
                (LastModel model) => huml.EQUALS(X.GetValue(model), 1.0),
                false
            );

    

        }

        public String ValidatorID {
            get {
                return "";
            }
        }

        public HUMLFramework.OpenValidationSummary Validate(LastModel model) {
            return huml.validate(model);
        }

        public HUMLFramework.OpenValidationSummary Validate(Object model) {
            return this.Validate((LastModel)model);
        }

        
    }
}