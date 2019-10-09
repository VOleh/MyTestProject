package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {

    private DataBaseConnector(){}

    public static  Connection createConnection() {
        String url = "jdbc:mysql://localhost:3306/project";
        String driver = "com.mysql.cj.jdbc.Driver";
        String login = "oleh";
        String passwordDataBase = "oleh";

        Connection connection = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, login, passwordDataBase);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
