

using System;
using System.Runtime.InteropServices;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Data;

namespace OpenValidationFramework_CSharp
{
    public class Runner
    {
        public HUMLValidator Validator;
        public Model MyModel;

        
        
        public Runner()
        {
            Validator = new HUMLValidator();
            MyModel = createDummyModel();
        }

        public void run()
        {
            var result = Validator.Validate(MyModel);

            if (result.HasErrors)
            {
                foreach (var error in result.Errors)
                {
                    Console.Out.WriteLine("Error was: " + error.Error);    
                }
                
            }
            else
            {
                Console.Out.WriteLine("No Errors in run");
            }

        }

        private Model createDummyModel()
        {
            Model mod = new Model();
            mod.Name = "Berry";
            mod.Profession = "Police Officer";
            mod.Address = new Model.AddressClass();
            mod.Address.City = "New York";
            mod.Address.Street = "Broadway";
            mod.Address.Number = 100;

            mod.Vehicles = new[]
                {
                    new Model.Vehicle() {Modelname = "Ferrari", RegisterYear = 1999}
                    , new Model.Vehicle(){Modelname = "Tesla", RegisterYear = 2015}
                };

            return mod;
        }
        
        
    }
}