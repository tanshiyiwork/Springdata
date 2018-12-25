package com.wonders.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类：
 * 1） 获取Connection
 * 2） 释放资源
 */
public class JDBCUtil {
    public static Connection getConnection() throws Exception {
        /*String url="jdbc:mysql:///spring_data";
        String user="root";
        String password="wonders";
        String driverClass="com.mysql.jdbc.Driver";*/
        InputStream inputStream=JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties=new Properties();
        properties.load(inputStream);
        String url=properties.getProperty("jdbc.url");
        String user=properties.getProperty("jdbc.user");
        String password=properties.getProperty("jdbc.password");
        String driverClass=properties.getProperty("jdbc.driverClass");
        Class.forName(driverClass);
        Connection connection=DriverManager.getConnection(url,user,password);
        return connection;
    }

    public static void release(Connection connection,Statement statement,ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
