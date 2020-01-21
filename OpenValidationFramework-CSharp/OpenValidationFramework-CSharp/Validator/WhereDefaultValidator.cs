using System;
using OpenValidationFramework_CSharp.Model.Primitive;

namespace OpenValidationFramework_CSharp.Validator
{
    
    public class WhereDefaultValidator : HUMLFramework.IOpenValidator
    {
        public HUMLFramework huml;

        public WhereDefaultValidator()
        {
            huml = new HUMLFramework();





            var myCandidates = huml.CreateVariable("myCandidates", (Model.WhereModel.Model model) => huml.WHERE(model.Numbers, x_7166607 => huml.EQUALS(x_7166607.number, 42.0)));

            var myNumber = huml.CreateVariable("myNumber", (Model.WhereModel.Model model) => huml.FIRST(myCandidates.GetValue(model)));

            var yourCandidates = huml.CreateVariable("yourCandidates", (Model.WhereModel.Model model) => huml.WHERE(model.Numbers, x_6762895 => huml.GREATER_THAN(x_6762895.number, 30.0)));

            var yourNumber = huml.CreateVariable("yourNumber", (Model.WhereModel.Model model) => huml.FIRST(myCandidates.GetValue(model)));

            huml.appendRule("",
                   new String[]{ "numbers", "number", "numbers", "number" },
                   "error",
                   (Model.WhereModel.Model model) => huml.EQUALS(myNumber.GetValue(model), yourNumber.GetValue(model)),
                   false
                );

    

        }

        public String ValidatorID {
            get {
                return "";
            }
        }

        public HUMLFramework.OpenValidationSummary Validate(Model.WhereModel.Model model) {
            return huml.validate(model);
        }

        public HUMLFramework.OpenValidationSummary Validate(Object model) {
            return this.Validate((Model.WhereModel.Model)model);
        }

        
    }

}