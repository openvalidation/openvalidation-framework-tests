namespace OpenValidationFramework_CSharp.Data
{
    public class Model
    {
        public string Name { get; set; }
        public string Profession;
        public AddressClass Address;
        public Vehicle[] Vehicles;
        
        public class AddressClass
        {
            public string City;
            public string Street;
            public double Number;
        }
        
        public class Vehicle
        {
            public string Modelname;
            public double RegisterYear;
        }
    }
}