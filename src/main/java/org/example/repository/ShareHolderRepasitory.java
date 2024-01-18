package org.example.repository;

import org.example.entity.ShareHolder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShareHolderRepasitory {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ShareHolderRepasitory() throws Exception{
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","myjava123");
    }

    public void save(ShareHolder shareHolder) throws Exception
    {
        preparedStatement=connection.prepareStatement("insert into shareholder values (DEFAULT,?,?,?);");
        preparedStatement.setString(1, shareHolder.getName());
        preparedStatement.setInt(2, shareHolder.getPhoneNumber());
        preparedStatement.setInt(3,shareHolder.getNationalCode());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public ShareHolder load (int shareHolderID) throws Exception{
        ShareHolder shareHolder=new ShareHolder();
        preparedStatement=connection.prepareStatement("select * from shareholder where id=?");
        preparedStatement.setInt(1,shareHolderID);
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()) {
            shareHolder.setId(Integer.parseInt(resultSet.getString("id")));
            shareHolder.setName(resultSet.getString("name"));
            shareHolder.setPhoneNumber(Integer.parseInt(resultSet.getString("phone")));
            shareHolder.setNationalCode(Integer.parseInt(resultSet.getString("nationalcode")));
        }
        resultSet.close();
        preparedStatement.close();
        return shareHolder;
    }
}
