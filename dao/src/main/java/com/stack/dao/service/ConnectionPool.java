package com.stack.dao.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ConnectionPool {
    private static final String URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_chinook";
    private static final String USER = "freedb_client_db";
    private static final String PASSWORD = "8zMA@sKsgS@Bb5s";
    private static final int INITIAL_POOL_SIZE = 10;
    private final List<Connection> connections;
    private static ConnectionPool instance;

    public ConnectionPool() {
        connections = new ArrayList<>();
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            try {
                connections.add(DriverManager.getConnection(URL, USER, PASSWORD));
            } catch (SQLException e) {
                log.error(e.getSQLState());
            }
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        return connections.isEmpty()
               ? null
               : connections.remove(connections.size() - 1);
    }

    public synchronized void releaseConnection(Connection connection) {
        connections.add(connection);
    }
}
