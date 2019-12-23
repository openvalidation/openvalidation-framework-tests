

using System;
using OpenValidationFramework_CSharp.Model;
using OpenValidationFramework_CSharp;


namespace OpenValidationFramework_CSharp.Validator
{
    public class HUMLValidator : HUMLFramework.IOpenValidator
    {
        public HUMLFramework huml;

        public HUMLValidator()
        {
            huml = new HUMLFramework();


    //pre validation null checks rules
            huml.appendRule("",
                   new String[]{ "address" },
                   "field: &#x27;adress&#x27; should not be null or empty",
                   (DefaultModel model) => huml.EMPTY(model.Address),
                   false
                );

    
    //++++++++++++++++++++++++++++++++
    
    huml.appendRule("",
                   new String[]{ "name" },
                   "name must be Jerry",
                   (DefaultModel model) => huml.NOT_EQUALS(model.Name, "Jerry"),
                   false
                );

            var placeOfResidence = huml.CreateVariable("placeOfResidence", (DefaultModel model) => model.Address.City);

            huml.appendRule("",
                   new String[]{ "adress.city" },
                   "placeOfResidence must be London",
                   (DefaultModel model) => ((model.Address != null) && (huml.NOT_EQUALS(placeOfResidence.GetValue(model), "London"))),
                   false
                );

            huml.appendRule("",
                   new String[]{ "adress.number" },
                   "adress.number must be less than 1000",
                   (DefaultModel model) => ((model.Address != null) && (huml.GREATER_OR_EQUALS(model.Address.Number, 1000.0))),
                   false
                );

    

        }

        public String ValidatorID {
            get {
                return "";
            }
        }

        public HUMLFramework.OpenValidationSummary Validate(DefaultModel model) {
            return huml.validate(model);
        }

        public HUMLFramework.OpenValidationSummary Validate(Object model) {
            return this.Validate((DefaultModel)model);
        }

        
    }
}