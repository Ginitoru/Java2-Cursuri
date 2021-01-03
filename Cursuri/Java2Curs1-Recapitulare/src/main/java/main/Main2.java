package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main2 {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost/java2c1";
        String user = "root";
        String password = "";

        Connection con = DriverManager.getConnection(url, user, password);

        String aql = "SELECT * FROM angajat";

       var stmt=  con.prepareStatement(aql);

        ResultSet result = stmt.executeQuery();

        try(con; stmt; result){
            while(result.next()){
                System.out.println(result.getInt("id") +
                                    result.getString("nume")+
                                    result.getInt("varsta"));
            }

        }





    }
}
