/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.db;

import avecias.mx.mybox.model.dao.UserDao;
import avecias.mx.mybox.model.dao.impl.UserDaoImpl;
import avecias.mx.mybox.model.entity.dto.UserDto;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author nash Created on Aug 9, 2018, 4:26:40 PM
 */
public class TestQuery {

    public static final Logger LOG = Logger.getLogger(TestQuery.class);

    public static void main(String[] args) {
        try {
            UserDao userDao = new UserDaoImpl();
            UserDto userDto = new UserDto();
            userDto.setIdUser(4);
            userDto.setUsername("nash");
            userDto.setPassword(DigestUtils.sha1Hex("nash"));
            
//            userDto = userDao.read(userDto);
            userDto.setRegistration(new Date());
//            UserDto delete = userDao.delete(userDto);
//            System.out.println(delete);
//            List<UserDto> userDtos = userDao.readAll();
//            userDtos.forEach(u -> {System.out.println(u);});
            userDao.update(userDto);
            System.out.println(userDto);
        } catch (SQLException ex) {
            LOG.error("Error SQL", ex);
        }
    }
}
