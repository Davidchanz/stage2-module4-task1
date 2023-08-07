package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        try {
            Properties props = new Properties();
            props.load(H2ConnectionFactory.class.getClassLoader().getResourceAsStream("h2database.properties"));
            String url = props.getProperty("db_url");
            String password = props.getProperty("password");
            String name = props.getProperty("user");
            return DriverManager.getConnection(url, name, password);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Write your code here!
}

