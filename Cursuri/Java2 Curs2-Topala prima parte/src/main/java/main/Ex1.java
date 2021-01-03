package main;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex1 {
    public static void main(String[] args) throws SQLException {
        var url = "jdbc:mysql://localhost:3306/java2c2";




            var con = DriverManager.getConnection(url, "root", "");

            var sql = "INSERT INTO produse VALUES(null, ?)";

            var stms = con.prepareStatement(sql);

            stms.setString(1, "ciocolata");
            stms.executeUpdate();


            con.close();




    }
}
