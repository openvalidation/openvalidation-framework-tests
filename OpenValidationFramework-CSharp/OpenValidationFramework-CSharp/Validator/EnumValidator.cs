using System;
using OpenValidationFramework_CSharp.Model;

namespace OpenValidationFramework_CSharp.Validator
{
    public class EnumValidator
    {
        public HUMLFramework huml;

        public static EnumValidator createValidatorWithMultipleArraysInVars() //TESTValidator_last_function_on_variable_containing_a_function_with_variable
        {
            EnumValidator val = new EnumValidator();

            var array = val.huml.CreateVariable("array", (EnumModel model) => model.Enums);

            var last2Array = val.huml.CreateVariable("last2Array", (EnumModel model) => val.huml.LAST(array.GetValue(model), 2.0));

            var X = val.huml.CreateVariable("X", (EnumModel model) => val.huml.LAST(last2Array.GetValue(model)));

            val.huml.appendRule("",
                new String[]{ "colors" },
                "error",
                (EnumModel model) => val.huml.EQUALS(X.GetValue(model), Color.Green),
                false
            );
            
            return val;
        }

        private EnumValidator()
        {
            this.huml = new HUMLFramework();
        }

        public String ValidatorID {
            get {
                return "";
            }
        }

        public HUMLFramework.OpenValidationSummary Validate(EnumModel model) {
            return huml.validate(model);
        }

        public HUMLFramework.OpenValidationSummary Validate(Object model) {
            return this.Validate((EnumModel)model);
        }

        
    }
}