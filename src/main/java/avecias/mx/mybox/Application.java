/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avecias.mx.mybox;

import java.io.InputStream;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author nash Created on Aug 3, 2018, 4:36:01 PM
 */
@SpringBootApplication
public class Application {

    public static final Logger LOG = Logger.getLogger(Application.class);

    private static InputStream getResource(String resource) {
        return new Application().getClass().getClassLoader().getResourceAsStream(resource);
    }

    public static void main(String[] args) {
        PropertyConfigurator.configure(getResource("log4j.properties"));
        SpringApplication.run(Application.class, args);
    }

}
