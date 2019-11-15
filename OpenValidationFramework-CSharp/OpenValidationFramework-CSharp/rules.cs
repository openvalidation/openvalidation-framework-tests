

using System;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Data;


namespace OpenValidationFramework_CSharp
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
                   (Model model) => huml.EMPTY(model.Address),
                   false
                );

    
    //++++++++++++++++++++++++++++++++
    
    huml.appendRule("",
                   new String[]{ "name" },
                   "name must be Jerry",
                   (Model model) => huml.NOT_EQUALS(model.Name, "Jerry"),
                   false
                );

            var placeOfResidence = huml.CreateVariable("placeOfResidence", (Model model) => model.Address.City);

            huml.appendRule("",
                   new String[]{ "adress.city" },
                   "placeOfResidence must be London",
                   (Model model) => ((model.Address != null) && (huml.NOT_EQUALS(placeOfResidence.GetValue(model), "London"))),
                   false
                );

            huml.appendRule("",
                   new String[]{ "adress.number" },
                   "adress.number must be less than 1000",
                   (Model model) => ((model.Address != null) && (huml.GREATER_OR_EQUALS(model.Address.Number, 1000.0))),
                   false
                );

    

        }

        public String ValidatorID {
            get {
                return "";
            }
        }

        public HUMLFramework.OpenValidationSummary Validate(Model model) {
            return huml.validate(model);
        }

        public HUMLFramework.OpenValidationSummary Validate(Object model) {
            return this.Validate((Model)model);
        }

        
    }
}