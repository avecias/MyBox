/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avecias.mx.mybox.model.db;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.sqlite.SQLiteConnection;

/**
 *
 * @author nash Created on Aug 9, 2018, 4:07:27 PM
 */
public class ConnectionUtil {

    public static final Logger LOG = Logger.getLogger(ConnectionUtil.class);
    private static SQLiteConnection connection;

    public static SQLiteConnection getSQLiteConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new SQLiteConnection("", "my-box.db");
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
