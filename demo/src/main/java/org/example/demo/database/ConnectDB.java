package org.example.demo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static String dbURL = "jdbc:mysql://localhost:3306/abc_company?useSSL=false";
    private static String dbUser = "root";

    private static String dbPassword = "12082001";


    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            System.out.println("-----------------Kết nối thành công-----------------");
        } catch (SQLException e) {
            System.out.println("-----------------Lỗi kết nối-----------------");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("-----------------Lỗi kết nối abc-----------------");
            e.printStackTrace();
        }
        return connection;
    }
}
