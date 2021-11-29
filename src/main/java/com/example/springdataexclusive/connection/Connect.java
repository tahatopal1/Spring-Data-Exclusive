package com.example.springdataexclusive.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    public static void main(String[] args) {

        String jdbcURL 	   = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false"
                .concat("&useJDBCCompliantTimezoneShift=true")
                .concat("&useLegacyDatetimeCode=false")
                .concat("&serverTimezone=Europe/Moscow");

        String user        = "datauser";
        String pass        = "datauser";

        try{
            System.out.println("Connecting to database: " + jdbcURL);
            Connection connection = DriverManager.getConnection(jdbcURL, user, pass);
            System.out.println("Connection successful!");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
