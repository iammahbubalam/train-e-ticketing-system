package com.mahbubalam.traineticketingsystem.server.entity;

public class Address {
    private int userId;
    private String division;
    private String district;
    private String thana;

    public Address(int userId, String division, String district, String thana) {
        this.userId = userId;
        this.division = division;
        this.district = district;
        this.thana = thana;
    }

    public Address() {
    }

    public Address(String division, String district, String thana) {
        this.division = division;
        this.district = district;
        this.thana = thana;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getThana() {
        return thana;
    }

    public void setThana(String thana) {
        this.thana = thana;
    }

    @Override
    public String toString() {
        return "Address{" +
                ", userId=" + userId +
                ", division='" + division + '\'' +
                ", district='" + district + '\'' +
                ", thana='" + thana + '\'' +
                '}';
    }
}
