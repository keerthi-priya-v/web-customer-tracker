package com.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {


        public static void main(String[] args){
            String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
            String user ="springstudent";
            String pass = "springstudent";
            try{
                System.out.println("Connecting to DB : "+jdbcUrl);
                Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
                System.out.println("Connection successful");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
