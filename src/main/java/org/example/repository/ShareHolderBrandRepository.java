package org.example.repository;
import org.example.entity.Brand;
import org.example.entity.ShareHolderBrands;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShareHolderBrandRepository {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ShareHolderBrandRepository() throws Exception{
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","myjava123");
    }

    public void save(ShareHolderBrands holderBrands) throws Exception
    {
        preparedStatement=connection.prepareStatement("insert into shareholder_brand values (DEFAULT,?,?);");
        preparedStatement.setInt(1, holderBrands.getShareholderID());
        preparedStatement.setInt(2,holderBrands.getBrandID());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void loadBrands (int shareHolderID) throws Exception{
        ShareHolderBrands holderBrands=new ShareHolderBrands();
        preparedStatement=connection.prepareStatement("select * from brand inner join shareholder_brand sb on brand.id = sb.brandID where shareholderID = ?;");
        preparedStatement.setInt(1,shareHolderID);
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()) {
            Brand brand = new Brand();
            brand.setId(resultSet.getInt("id"));
            brand.setName(resultSet.getString("name"));
            brand.setWebsite(resultSet.getString("website"));
            brand.setDescription(resultSet.getString("description"));
            System.out.println(brand);
            }
        resultSet.close();
        preparedStatement.close();
    }
}
