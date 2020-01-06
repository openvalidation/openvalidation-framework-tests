using System;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Model;

namespace OpenValidationFramework_CSharp.Validator.Last
{
    public class LastTestValidator
    {
        public HUMLFramework huml;

        public static LastTestValidator createValidatorWithMultipleArraysInVars() //TESTValidator_last_function_on_variable_containing_a_function_with_variable
        {
            LastTestValidator val = new LastTestValidator();

            var array = val.huml.CreateVariable("array", (LastModel model) => model.Numbers);

            var last2Array = val.huml.CreateVariable("last2Array", (LastModel model) => val.huml.LAST(array.GetValue(model), 2.0));

            var X = val.huml.CreateVariable("X", (LastModel model) => val.huml.LAST(last2Array.GetValue(model)));

            val.huml.appendRule("",
                new String[]{ "numbers" },
                "error",
                (LastModel model) => val.huml.EQUALS(X.GetValue(model), 1.0),
                false
            );
            
            return val;
        }

        private LastTestValidator()
        {
            this.huml = new HUMLFramework();
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