package com.vaccination.classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Person {
    static final String DB_URL = "jdbc:mysql://localhost:3306/vaccination";
    static final String USER = "devappuser";
    static final String PASS = "wecandoit-022";

    Person() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String[][] getData(String firstName, String lastName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM person where first_name=\"%s\" and last_name=\"%s\"", firstName, lastName));
        ) {
            String[][] data = new String[1][3];
            int i =0;
            while(rs.next()){
                //Display values
                System.out.print("ID: " + rs.getInt("idperson"));
                System.out.print(", First: " + rs.getString("first_name"));
                System.out.println(", Last: " + rs.getString("last_name"));
                String ID = String.valueOf(rs.getInt("idperson"));
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                //put data in an array
                String[] current = new String[3];
                current[0] = ID;
                current[1] = first;
                current[2] = last;
                data[i] = current;
                i++;
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return new String[1][1] ;
    }

    public static void main(String[] args) {

    }

}
