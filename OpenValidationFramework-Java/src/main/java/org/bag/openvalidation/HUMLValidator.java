package org.bag.openvalidation;


import org.bag.model.Model;

public class HUMLValidator implements HUMLFramework.IOpenValidator
{
    public HUMLFramework huml;

    public HUMLValidator()
    {
        huml = new HUMLFramework();


//pre validation null checks rules
        huml.appendRule("",
           new String[]{ "adress" },
           "field: &#x27;adress&#x27; should not be null or empty",
           (Model model) -> huml.EMPTY(model.getAddress()),
           false
        );


//++++++++++++++++++++++++++++++++


        huml.appendRule("",
           new String[]{ "name" },
           "name must be Jerry",
           (Model model) -> huml.NOT_EQUALS(model.getName(), "Jerry"),
           false
        );

        HUMLFramework.Variable placeOfResidence = huml.CreateVariable("placeOfResidence", (Model model) -> model.getAddress().getCity());

        huml.appendRule("",
           new String[]{ "adress.city" },
           "placeOfResidence must be London",
           (Model model) -> ((model.getAddress() != null) && (huml.NOT_EQUALS(placeOfResidence.GetValue(model), "London"))),
           false
        );

        huml.appendRule("",
           new String[]{ "adress.number" },
           "adress.number must be less than 1000",
           (Model model) -> ((model.getAddress() != null) && (huml.GREATER_OR_EQUALS(model.getAddress().getNumber(), 1000.0))),
           false
        );



    }

    public String getValidatorID(){
        return "";
    }

    public HUMLFramework.OpenValidationSummary validate(Model model) {
        return huml.validate(model);
    }

    @Override
    public HUMLFramework.OpenValidationSummary validate(Object model) {
        return this.validate((Model)model);
    }

    
}