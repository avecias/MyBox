/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package avecias.mx.mybox.controller.service;

import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nash
 * Created on Aug 15, 2018, 11:55:58 AM
 */
@Controller
@RequestMapping(value = "/file")
public class FileController {

    public static final Logger LOG = Logger.getLogger(FileController.class);
    
    @RequestMapping(name = "/download/{file}", method = RequestMethod.GET, headers = "Accept=application/json")
    public void downloadFile(@PathVariable String file, HttpServletResponse response){
        
    }

}
