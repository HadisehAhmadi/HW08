package org.example.repository;

import org.example.entity.Brand;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BrandRepasitory {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public BrandRepasitory() throws Exception{
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","myjava123");
    }

    public int save(Brand brand) throws Exception
    {
        preparedStatement=connection.prepareStatement("insert into brand values (DEFAULT,?,?,?);");
        preparedStatement.setString(1,brand.getName());
        preparedStatement.setString(2,brand.getWebsite());
        preparedStatement.setString(3,brand.getDescription());
        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        int id = generatedKeys.getInt(1);
        preparedStatement.close();
        return id;
    }

    public Brand load () throws Exception{
        Brand brand=new Brand();
        preparedStatement=connection.prepareStatement("select * from brand");
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()) {
            brand.setId(Integer.parseInt(resultSet.getString("id")));
            brand.setName(resultSet.getString("name"));
            brand.setWebsite(resultSet.getString("website"));
            brand.setDescription(resultSet.getString("description"));
        }
        resultSet.close();
        preparedStatement.close();
        return brand;
    }
}
