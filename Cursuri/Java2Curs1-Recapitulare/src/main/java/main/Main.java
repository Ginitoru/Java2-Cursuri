package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost/java2c1";
        String user = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);


            String sql = "INSERT INTO angajat VALUES (null, ? ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,"gigel" );
            stmt.setInt(2, 20);

            stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
