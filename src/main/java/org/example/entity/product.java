package org.example.entity;

public class product {
    private int id;
    private String name;
    private int createDate;
    private int categoryID;
    private int brandID;

    public product(String name, int createDate, int categoryID, int brandID) {
        this.name = name;
        this.createDate = createDate;
        this.categoryID = categoryID;
        this.brandID = brandID;
    }

    public product() {
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

    public int getCreateDate() {
        return createDate;
    }

    public void setCreateDate(int createDate) {
        this.createDate = createDate;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", categoryID=" + categoryID +
                ", brandID=" + brandID +
                '}';
    }
}
