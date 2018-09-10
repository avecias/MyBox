/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.file;

import avecias.mx.mybox.model.dao.UserDao;
import avecias.mx.mybox.model.dao.impl.UserDaoImpl;
import avecias.mx.mybox.model.entity.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 *
 * @author nash Created on Aug 11, 2018, 3:18:25 PM
 */
public class FileToJson {

    public static final Logger LOG = Logger.getLogger(FileToJson.class);

    public static void main(String[] args) throws IOException, SQLException {
        UserDao userDao = new UserDaoImpl();
        UserDto userDto = new UserDto();
        userDto.setIdUser(1);
        userDto = userDao.read(userDto);
        File root = new File("C:\\Users\\nash\\Docs\\");
        ObjectMapper mapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        mapper.writeValue(stringWriter, userDto);
        System.out.println(stringWriter.toString());
    }
}
