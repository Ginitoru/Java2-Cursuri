package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost/java2curs1";
        String user = "root";
        String password = "";
        String sql = "INSERT INTO angajat VALUES (null, ?,?)";

        try ( Connection con = DriverManager.getConnection(url, user, password);

              PreparedStatement stmt = con.prepareStatement(sql);


        ){

            stmt.setString(1, "gigel");
            stmt.setInt(2, 5);
            stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
