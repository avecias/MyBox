/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avecias.mx.mybox.controller.service;

import avecias.mx.mybox.model.entity.ResultStatus;
import avecias.mx.mybox.model.entity.dto.UserDto;
import avecias.mx.mybox.model.entity.result.ResultUser;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nash Created on Aug 3, 2018, 5:22:20 PM
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    public static final Logger LOG = Logger.getLogger(UserController.class);

    @RequestMapping(path = "/get/{idUser}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResultUser getOneById(@PathVariable int idUser) {
        UserDto userDto = new UserDto();
        userDto.setIdUser(idUser);
        ResultUser result = new ResultUser(userDto, ResultStatus.OBJECT_NULL.getValue(), ResultStatus.OBJECT_NULL.name());
        return result;
    }

}
