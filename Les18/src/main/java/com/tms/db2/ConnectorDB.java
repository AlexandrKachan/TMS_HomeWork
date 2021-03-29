package com.tms.db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectorDB {
    public static Connection getConnection() throws SQLException {
//---------------------первый способ------------------------
//        String url = "jdbc:mysql://localhost:3306/testphones";
//        Properties prop = new Properties();
//        prop.put("user", "root");
//        prop.put("password", "7502456");
//        prop.put("autoReconnect", "true");
//        prop.put("characterEncoding", "UTF-8");
//        prop.put("useUnicode", "true");
//        Connection cn = null;
//        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        // return DriverManager.getConnection(url, prop);
//---------------------второй способ------------------------

//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testphones", "root", "7502456");
//        return conn;
//---------------------третий способ из файла database.properties-папка resources------------------------
        ResourceBundle resource;
        resource = ResourceBundle.getBundle("database");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
         return DriverManager.getConnection(url, user,pass);
    }
}



