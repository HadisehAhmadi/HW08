package org.example.service;

import org.example.entity.*;
import org.example.repository.*;

import javax.sound.midi.Soundbank;
import java.sql.ResultSet;
import java.util.Scanner;

public class Menu {
    Scanner scanner;
    String addedStringValues;
    int addedIntValues;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void runMenu() throws Exception {
        int choice;
        System.out.println("Welcome to program:");
        System.out.println("How use this program?(Insert 1 or 2)\t1.Share Holder   2. User");
        choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("1.Regist New Share Holder\n2.Add brand to your list\n3.Your Brands list\t(Insert 1 or 2 or 3)");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> shareHolderRegistration();
                    case 2 -> ShareHolderAddBrand();
                    case 3 -> ShareHolderBrandsList();
                    default -> {
                        System.out.println("Wrong number inserted please try again");
                        System.exit(0);
                    }
                }
            }
            case 2 -> {
                System.out.println("What do you want to do?" +
                        "\n1.Regist\n2.Visit Brands\n3.Visit Categories\n4.Visit Products\n5.Insert Product");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> UserRegister();
                    case 2 -> VisitBrands();
                    case 3 -> VisitCategories();
                    case 4 -> VisitProducts();
                    case 5 -> {
                        int brandID = InsertBrand();
                        int CatID =InsertCategory();
                        InsertProduct(brandID,CatID);
                    }
                    default -> {
                        System.out.println("Wrong number inserted please try again");
                        System.exit(0);
                    }
                }
            }
            default -> {
                System.out.println("Wrong number inserted please try again");
                System.exit(0);
            }
        }
    }

    public void shareHolderRegistration() throws Exception {
        ShareHolder shareHolder = new ShareHolder();
        ShareHolderRepasitory shareHolderRepasitory = new ShareHolderRepasitory();

        System.out.println("Fill this form:");
        System.out.println("Name:");
        addedStringValues = scanner.nextLine();

        shareHolder.setName(addedStringValues);
        System.out.println("Phone: (valid form: 09XXXXXXXXX)");
        addedIntValues = scanner.nextInt();
        if (Validation.isValidPhoneNumber(addedIntValues))
            shareHolder.setPhoneNumber(addedIntValues);
        else
            System.out.println("Wrong phone number,phone didn't add");

        System.out.println("National Code: (valid form: XXXXXXXXXX)");
        addedIntValues = scanner.nextInt();
        if (Validation.isValidNationalCode(addedIntValues))
            shareHolder.setNationalCode(addedIntValues);
        else
            System.out.println("Wrong National Code,National Code didn't add");

        shareHolderRepasitory.save(shareHolder);
        System.out.println("Register Finished");
        System.exit(0);
    }

    public void ShareHolderAddBrand() throws Exception {
        ShareHolderBrands shareHolderBrands = new ShareHolderBrands();
        ShareHolderBrandRepository holderBrandRepository = new ShareHolderBrandRepository();
        System.out.println("insert Your shareHolderID:");
        addedIntValues = scanner.nextInt();
        shareHolderBrands.setShareholderID(addedIntValues);
        System.out.println("insert Your new brandID:");
        addedIntValues = scanner.nextInt();
        shareHolderBrands.setShareholderID(addedIntValues);
        holderBrandRepository.save(shareHolderBrands);
        System.out.println("Brand added successfully");
        System.exit(0);
    }

    public void ShareHolderBrandsList() throws Exception{
        ShareHolderBrandRepository holderBrandRepository = new ShareHolderBrandRepository();
        System.out.println("insert Your shareHolderID:");
        addedIntValues = scanner.nextInt();
        holderBrandRepository.loadBrands(addedIntValues);
        System.out.println("Brands loaded successfully");
        System.exit(0);
    }

    public void UserRegister() throws Exception{
        User user = new User();
        UserRepasitory userRepasitory = new UserRepasitory();
        System.out.println("Fill this form:");
        System.out.println("Name:");
        addedStringValues = scanner.nextLine();
        user.setName(addedStringValues);

        System.out.println("UserName:");
        addedStringValues = scanner.nextLine();
        user.setUsername(addedStringValues);

        System.out.println("Email: (valid form: XX@XX.XX)");
        addedStringValues = scanner.nextLine();
        if (Validation.isValidEmail(addedStringValues))
            user.setEmail(addedStringValues);
        else
            System.out.println("Wrong Email,Email didn't add");

        System.out.println("Password: (At least 8 characters long\n" +
                "Contains at least one digit (0-9)\n" +
                "Contains at least one lowercase letter (a-z)\n" +
                "Contains at least one uppercase letter (A-Z)\n" +
                "Contains at least one special character from the set @#$%^&+=\n" +
                "Does not contain whitespace characters");
        addedStringValues = scanner.nextLine();
        if (Validation.isValidPassword(addedStringValues))
            user.setPassword(addedStringValues);
        else
            System.out.println("Wrong Password,Password didn't add");

        userRepasitory.save(user);
        System.out.println("Register Finished");
        System.exit(0);
    }

    public void VisitBrands() throws Exception{
        BrandRepasitory brandRepasitory = new BrandRepasitory();
        brandRepasitory.load();
        System.out.println("Brands Loaded");
        System.exit(0);
    }

    public void VisitCategories() throws Exception{
        CategoryRepasitory categoryRepasitory = new CategoryRepasitory();
        categoryRepasitory.load();
        System.out.println("Categories Loaded");
        System.exit(0);
    }

    public int InsertBrand() throws Exception{
        BrandRepasitory brandRepasitory = new BrandRepasitory();
        Brand brand = new Brand();
        System.out.println("You Should add a Brand:");
        System.out.println("Brands Name:");
        addedStringValues = scanner.nextLine();
        brand.setName(addedStringValues);

        System.out.println("Brands Website:");
        addedStringValues = scanner.nextLine();
        if(Validation.isValidWebsite(addedStringValues))
            brand.setWebsite(addedStringValues);
        else
            System.out.println("Wrong website,website didn't add");

        System.out.println("Brands Description:");
        addedStringValues = scanner.nextLine();
        brand.setDescription(addedStringValues);

        int brandID = brandRepasitory.save(brand);
        System.out.println("Add Brand Finished");
        return brandID;

    }

    public int InsertCategory() throws Exception{
        CategoryRepasitory categoryRepasitory = new CategoryRepasitory();
        Category category = new Category();
        System.out.println("You Should add a Catagory:");
        System.out.println("Category Name:");
        addedStringValues = scanner.nextLine();
        category.setName(addedStringValues);

        System.out.println("Category Description:");
        addedStringValues = scanner.nextLine();
        category.setDescription(addedStringValues);

        int catID= categoryRepasitory.save(category);
        System.out.println("Add Category Finished");
        return catID;
    }

    public void InsertProduct(int brandID,int CatID) throws Exception{
        Product product = new Product();
        ProductRepasitory productRepasitory = new ProductRepasitory();

        System.out.println("Add Product:");
        System.out.println("Product Name:");
        addedStringValues = scanner.nextLine();
        product.setName(addedStringValues);

        System.out.println("Product Create Date:");
        addedIntValues = scanner.nextInt();
        product.setCreateDate(addedIntValues);

        product.setBrandID(brandID);
        product.setCategoryID(CatID);

        productRepasitory.save(product);
        System.out.println("Add Product Finished");
    }

    public void VisitProducts() throws Exception{
        ProductRepasitory productRepasitory = new ProductRepasitory();
        productRepasitory.load();
    }
}

