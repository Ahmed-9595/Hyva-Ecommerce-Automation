package com.revton.qa.dto;

public class CheckoutData {

        private String emailAddress;
        private String firstName;
        private String lastName;
        private String streetAddress;
        private String country;
        private String stateProvince;
        private String city;
        private String zipPostalCode;
        private String phoneNumber;
        private String shippingMethod;

        // Getters and Setters
        public String getEmailAddress() {return emailAddress;}
        public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}

        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }

        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }

        public String getStreetAddress() { return streetAddress; }
        public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }

        public String getCountry() { return country; }
        public void setCountry(String country) { this.country = country; }

        public String getStateProvince() { return stateProvince; }
        public void setStateProvince(String stateProvince) { this.stateProvince = stateProvince; }

        public String getCity() { return city; }
        public void setCity(String city) { this.city = city; }

        public String getZipPostalCode() { return zipPostalCode; }
        public void setZipPostalCode(String zipPostalCode) { this.zipPostalCode = zipPostalCode; }

        public String getPhoneNumber() { return phoneNumber; }
        public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    }

