package org.example.entity;

public class ShareHolderBrands {
    private int id;
    private int shareholderID;
    private int brandID;

    public ShareHolderBrands(int shareholderID, int brandID) {
        this.shareholderID = shareholderID;
        this.brandID = brandID;
    }

    public ShareHolderBrands() {
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
