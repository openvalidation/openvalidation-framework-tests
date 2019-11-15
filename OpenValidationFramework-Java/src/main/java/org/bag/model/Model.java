package org.bag.model;

public class Model {
    private String name;
    private String profession;
    private Address address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public class Address{
        private String city;
        private String street;
        private double number;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public double getNumber() {
            return number;
        }

        public void setNumber(double number) {
            this.number = number;
        }
    }
    
    public class Vehicle{
        private String modelname;
        private double registerYear;

        public String getModelname() {
            return modelname;
        }

        public void setModelname(String modelname) {
            this.modelname = modelname;
        }

        public double getRegisterYear() {
            return registerYear;
        }
    }
}
