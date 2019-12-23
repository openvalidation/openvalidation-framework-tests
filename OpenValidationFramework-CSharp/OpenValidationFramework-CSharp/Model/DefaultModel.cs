namespace OpenValidationFramework_CSharp.Model
{
    public class DefaultModel
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