package com.example.gustav.androidmenyer;

public class Supplier {

    private String id;
    private String companyName;
    private String phone;
    private String email;
    private String address;
    private String postalCode;
    private String city;

    public Supplier(String id, String companyName, String phone, String email, String address, String postalCode, String city) {
        this.id = id;
        this.companyName = companyName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}
