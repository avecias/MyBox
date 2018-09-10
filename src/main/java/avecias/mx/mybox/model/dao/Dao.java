/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avecias.mx.mybox.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author nash Created on Aug 9, 2018, 4:59:19 PM
 * @param <T> Class
 */
public interface Dao<T extends Serializable> {

    public T create(T orm) throws SQLException;

    public T read(T orm) throws SQLException;

    public T update(T orm) throws SQLException;

    public T delete(T orm) throws SQLException;

    public List<T> readAll() throws SQLException;

}
