using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Model;
using OpenValidationFramework_CSharp.Model.Primitive;
using System;
using System.Collections.Generic;
using System.Text;

namespace io.openvalidation.integration.Variables
{
    public class ValidatorVariableArrayContainingStaticPropertyVariable
    {
        public HUMLFramework huml;

        public ValidatorVariableArrayContainingStaticPropertyVariable()
        {
            huml = new HUMLFramework();

            var nameVar = huml.CreateVariable("nameVar", (DefaultModel model) => "Peter"); 

            var nameArray = huml.CreateVariable("nameArray", (DefaultModel model) => huml.CREATE_ARRAY("Hans", model.Name, nameVar.GetValue(model)));

            huml.appendRule("",
                new String[] { "Name" },
                "The profession should not be one of nameArray",
                (DefaultModel model) => huml.ONE_OF(model.Profession, nameArray.GetValue(model)),
                false
            );
        }

        public String ValidatorID
        {
            get { return ""; }
        }

        public HUMLFramework.OpenValidationSummary Validate(DefaultModel model)
        {
            return huml.validate(model);
        }

        public HUMLFramework.OpenValidationSummary Validate(Object model)
        {
            return this.Validate((DefaultModel)model);
        }
    }
}
