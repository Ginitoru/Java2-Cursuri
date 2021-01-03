package main;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main2 {
    public static void main(String[] args) {
        String sql = "SELECT * FROM angajat";
        String url = "jdbc:mysql://localhost/java2curs1";


        try {
            var con = DriverManager.getConnection(url,"root", "");
            var stmt = con.prepareStatement(sql);

            var result = stmt.executeQuery();

            while(result.next()){
                System.out.println(
                        result.getInt("id") +" "+
                        result.getString("nume") + " " +
                        result.getInt("varsta")

                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
