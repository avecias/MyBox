/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avecias.mx.mybox.model.entity;

/**
 *
 * @author nash Created on Aug 3, 2018, 5:42:46 PM
 */
public enum ResultStatus {

    OK(200),
    OBJECT_NULL(100),
    OBJECT_IS_NOT_VALID(300),
    UNAUTHORIZED(401),
    OBJECT_NOT_MAPPED(402),
    FORBIDDEN(403),
    OBJECT_NOT_FOUND(404),
    ERROR_DATA_BASE(405),
    ERROR_HIBERNATE(406),
    ERROR(500);

    private final Integer value;

    private ResultStatus(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
