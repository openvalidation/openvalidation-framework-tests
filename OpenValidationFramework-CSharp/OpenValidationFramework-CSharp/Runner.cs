

using System;
using System.Runtime.InteropServices;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Validator;
using OpenValidationFramework_CSharp.Model;

namespace OpenValidationFramework_CSharp
{
    public class Runner
    {
        public HUMLValidator Validator;
        public DefaultModel MyModel;

        
        
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

        private DefaultModel createDummyModel()
        {
            DefaultModel mod = new DefaultModel();
            mod.Name = "Berry";
            mod.Profession = "Police Officer";
            mod.Address = new DefaultModel.AddressClass();
            mod.Address.City = "New York";
            mod.Address.Street = "Broadway";
            mod.Address.Number = 100;

            mod.Vehicles = new[]
                {
                    new DefaultModel.Vehicle() {Modelname = "Ferrari", RegisterYear = 1999}
                    , new DefaultModel.Vehicle(){Modelname = "Tesla", RegisterYear = 2015}
                };

            return mod;
        }
        
        
    }
}