/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avecias.mx.mybox.model.entity.result;

import avecias.mx.mybox.model.entity.Result;
import avecias.mx.mybox.model.entity.dto.UserDto;

/**
 *
 * @author nash Created on Aug 3, 2018, 5:34:18 PM
 */
public class ResultUser extends Result {

    private UserDto user;

    public ResultUser() {
    }

    public ResultUser(UserDto user) {
        this.user = user;
    }

    public ResultUser(UserDto user, int status, String message) {
        super(status, message);
        this.user = user;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

}
