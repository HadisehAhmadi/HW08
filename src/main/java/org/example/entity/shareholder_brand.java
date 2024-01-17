package org.example.entity;

public class shareholder_brand {
    private int id;
    private int shareholderID;
    private int brandID;

    public shareholder_brand(int shareholderID, int brandID) {
        this.shareholderID = shareholderID;
        this.brandID = brandID;
    }

    public shareholder_brand() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShareholderID() {
        return shareholderID;
    }

    public void setShareholderID(int shareholderID) {
        this.shareholderID = shareholderID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    @Override
    public String toString() {
        return "shareholder_brand{" +
                "id=" + id +
                ", shareholderID=" + shareholderID +
                ", brandID=" + brandID +
                '}';
    }
}
