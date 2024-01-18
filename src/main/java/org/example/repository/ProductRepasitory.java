package org.example.repository;

import org.example.entity.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductRepasitory {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ProductRepasitory() throws Exception{
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","myjava123");
    }

    public void save(Product product) throws Exception
    {
        preparedStatement=connection.prepareStatement("insert into product values (DEFAULT,?,?,?,?);");
        preparedStatement.setString(1,product.getName());
        preparedStatement.setInt(2,product.getCreateDate());
        preparedStatement.setInt(3,product.getCategoryID());
        preparedStatement.setInt(4,product.getBrandID());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public Product load () throws Exception{
        Product product=new Product();
        preparedStatement=connection.prepareStatement("select * from product");
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()) {
            product.setId(Integer.parseInt(resultSet.getString("id")));
            product.setName(resultSet.getString("name"));
            product.setCreateDate(Integer.parseInt(resultSet.getString("website")));
            product.setCategoryID(Integer.parseInt(resultSet.getString("categoryID")));
            product.setBrandID(Integer.parseInt(resultSet.getString("brandID")));
        }
        resultSet.close();
        preparedStatement.close();
        return product;
    }
}
