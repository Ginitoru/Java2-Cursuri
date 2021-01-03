package main;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex2 {
    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/java2c2";

        try {
            var con = DriverManager.getConnection(url, "root", "");
            var sql = "SELECT  * FROM produse";

            var stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            try(con; stmt; rs){

                while(rs.next()){
                 var id =    rs.getInt("id");
                 var nume = rs.getString("nume");

                    System.out.println(id + " " + nume);

                }
            }




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
