package org.example.repository;

import org.example.entity.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepasitory {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public UserRepasitory() throws Exception{
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","myjava123");
    }

    public void save(User user) throws Exception
    {
        preparedStatement=connection.prepareStatement("insert into users values (DEFAULT,?,?,?,?);");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3,user.getEmail());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public User load (int userID) throws Exception{
        User user=new User();
        preparedStatement=connection.prepareStatement("select * from users where id=?");
        preparedStatement.setInt(1,userID);
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()) {
            user.setId(Integer.parseInt(resultSet.getString("id")));
            user.setName(resultSet.getString("name"));
            user.setUsername(resultSet.getString("username"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
        }
        resultSet.close();
        preparedStatement.close();
        return user;
    }
}
