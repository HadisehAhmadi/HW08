package org.example.entity;

public class shareholder {
    private int id;
    private String name;
    private int phoneNumber;
    private int nationalCode;

    public shareholder(String name, int phoneNumber, int nationalCode) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
    }

    public shareholder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }

    @Override
    public String toString() {
        return "shareholder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", nationalCode=" + nationalCode +
                '}';
    }
}
