package org.example.repository;

import org.example.entity.Category;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CategoryRepasitory {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public CategoryRepasitory() throws Exception{
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","myjava123");
    }

    public void save(Category category) throws Exception
    {
        preparedStatement=connection.prepareStatement("insert into category values (DEFAULT,?,?);");
        preparedStatement.setString(1,category.getName());
        preparedStatement.setString(2,category.getDescription());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public Category load (int categoryID) throws Exception{
        Category category=new Category();
        preparedStatement=connection.prepareStatement("select * from category where id=?");
        preparedStatement.setInt(1,categoryID);
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()) {
            category.setId(Integer.parseInt(resultSet.getString("id")));
            category.setName(resultSet.getString("name"));
            category.setDescription(resultSet.getString("description"));
        }
        resultSet.close();
        preparedStatement.close();
        return category;
    }
}
