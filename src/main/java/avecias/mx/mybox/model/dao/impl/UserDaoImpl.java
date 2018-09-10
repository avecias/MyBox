/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avecias.mx.mybox.model.dao.impl;

import avecias.mx.mybox.model.dao.UserDao;
import avecias.mx.mybox.model.db.ConnectionUtil;
import avecias.mx.mybox.model.entity.dto.UserDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.sqlite.SQLiteConnection;

/**
 *
 * @author nash Created on Aug 10, 2018, 11:44:40 AM
 */
public class UserDaoImpl implements UserDao {

    private static final String SQL_CREATE = "insert into User values((select seq from sqlite_sequence where name = 'User') + 1,?,?,?)";
    private static final String SQL_READ_SEQ = "select seq from sqlite_sequence where name = 'User'";
    private static final String SQL_READ = "select * from User where idUser = ?";
    private static final String SQL_UPDATE = "update User set username = ?, password = ?, registration = ? where idUser = ?";
    private static final String SQL_DELETE = "delete from User where idUser = ?";
    private static final String SQL_READ_ALL = "select * from User";

    @Override
    public UserDto create(UserDto orm) throws SQLException {
        SQLiteConnection s = ConnectionUtil.getSQLiteConnection();
        PreparedStatement ps = s.prepareStatement(SQL_CREATE);
        ps.setString(1, orm.getUsername());
        ps.setString(2, orm.getPassword());
        ps.setLong(3, orm.getRegistration().getTime());
        if (ps.execute()) {
            throw new SQLException("No se logró guardar el nuevo user");
        }
        ps = s.prepareStatement(SQL_READ_SEQ);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            orm.setIdUser(rs.getInt(1));
        }
        ConnectionUtil.closeConnection();
        return orm;
    }

    @Override
    public UserDto read(UserDto orm) throws SQLException {
        SQLiteConnection s = ConnectionUtil.getSQLiteConnection();
        PreparedStatement ps = s.prepareStatement(SQL_READ);
        ps.setInt(1, orm.getIdUser());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            orm.setIdUser(rs.getInt("idUser"));
            orm.setUsername(rs.getString("username"));
            orm.setPassword(rs.getString("password"));
            orm.setRegistration(new Date((long) rs.getDouble("registration")));
        }
        ConnectionUtil.closeConnection();
        return orm;
    }

    @Override
    public UserDto update(UserDto orm) throws SQLException {
        SQLiteConnection s = ConnectionUtil.getSQLiteConnection();
        PreparedStatement ps = s.prepareStatement(SQL_UPDATE);
        ps.setString(1, orm.getUsername());
        ps.setString(2, orm.getPassword());
        ps.setLong(3, orm.getRegistration().getTime());
        ps.setInt(4, orm.getIdUser());
        if (ps.executeUpdate() <= 0) {
            throw new SQLException("No se logró actualizar el user con id = " + orm.getIdUser());
        }
        ConnectionUtil.closeConnection();
        return orm;
    }

    @Override
    public UserDto delete(UserDto orm) throws SQLException {
        SQLiteConnection s = ConnectionUtil.getSQLiteConnection();
        PreparedStatement ps = s.prepareStatement(SQL_DELETE);
        ps.setInt(1, orm.getIdUser());
        if (ps.execute()) {
            throw new SQLException("No se logró borrar el user con id = " + orm.getIdUser());
        }
        ConnectionUtil.closeConnection();
        return orm;
    }

    @Override
    public List<UserDto> readAll() throws SQLException {
        List<UserDto> users = new ArrayList<>();
        SQLiteConnection s = ConnectionUtil.getSQLiteConnection();
        PreparedStatement ps = s.prepareStatement(SQL_READ_ALL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            UserDto userDto = new UserDto();
            userDto.setIdUser(rs.getInt("idUser"));
            userDto.setUsername(rs.getString("username"));
            userDto.setPassword(rs.getString("password"));
            userDto.setRegistration(new Date((long) rs.getDouble("registration")));
            users.add(userDto);
        }
        ConnectionUtil.closeConnection();
        return users;
    }

}
