/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avecias.mx.mybox.model.dao.impl;

import avecias.mx.mybox.model.dao.ConfigurationDao;
import avecias.mx.mybox.model.db.ConnectionUtil;
import avecias.mx.mybox.model.entity.config.Configuration;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.sqlite.SQLiteConnection;

/**
 *
 * @author nash Created on Aug 9, 2018, 5:13:43 PM
 */
public class ConfigurationDaoImpl implements ConfigurationDao {

    private static final String SQL_CREATE = "select * from Configuration";
    private static final String SQL_READ = "select * from Configuration";
    private static final String SQL_UPDATE = "select * from Configuration";
    private static final String SQL_DELETE = "select * from Configuration";
    private static final String SQL_READ_ALL = "select * from Configuration";

    @Override
    public Configuration create(Configuration orm) throws SQLException {
        SQLiteConnection s = ConnectionUtil.getSQLiteConnection();
        ConnectionUtil.closeConnection();
        return orm;
    }

    @Override
    public Configuration read(Configuration orm) throws SQLException {
        SQLiteConnection s = ConnectionUtil.getSQLiteConnection();
        ConnectionUtil.closeConnection();
        return orm;
    }

    @Override
    public Configuration update(Configuration orm) throws SQLException {
        SQLiteConnection s = ConnectionUtil.getSQLiteConnection();
        ConnectionUtil.closeConnection();
        return orm;
    }

    @Override
    public Configuration delete(Configuration orm) throws SQLException {
        SQLiteConnection s = ConnectionUtil.getSQLiteConnection();
        ConnectionUtil.closeConnection();
        return orm;
    }

    @Override
    public List<Configuration> readAll() throws SQLException {
        SQLiteConnection s = ConnectionUtil.getSQLiteConnection();
        List<Configuration> configurations = new ArrayList<>();
        PreparedStatement ps = s.prepareStatement(SQL_READ_ALL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Configuration c = new Configuration();
            c.setRootDirectory(rs.getString("rootDirectory"));
            c.setUrl(rs.getString("url"));
            configurations.add(c);
        }
        ConnectionUtil.closeConnection();
        return configurations;
    }

}
