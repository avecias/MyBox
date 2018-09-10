/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avecias.mx.mybox;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author nash Created on Aug 3, 2018, 5:16:38 PM
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Logger LOG = Logger.getLogger(SwaggerConfig.class);

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("public-api")
                .apiInfo(apiInfo())
                .select()
                //                .paths(postPaths())
                .paths(PathSelectors.any())
                .build();
    }

//    private Predicate<String> postPaths() {
//        return or(regex("/user.*"));
//    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Titulo")
                .description("Descripcion de la pagina")
                .termsOfServiceUrl("http://urldelapagina.com")
                .contact("pagina@gmail.com")
                .license("Pagina License")
                .licenseUrl("pagina-licencia@gmail.com")
                .version("1.0")
                .build();
    }
}
