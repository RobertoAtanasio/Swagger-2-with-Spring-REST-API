package com.swagger2.restapi.swagger2restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

import java.util.Collections;

/*
	Let’s analyze few important points from this code:
	
	1. @EnableSwagger2 annotation enable swagger 2 in our project.
	2. We defined the Docket bean.
	3. The select() method returns the ApiSelectorBuilder instance.
	4. The ApiSelectorBuilder provides was to control endpoints exposed by Swagger.
	5. PathSelectors.any() ensure that all the API documentation is available.
	
	Let’s build and deploy our application. Once the application is up and running, 
	open the following URL http://localhost:8080/v2/api-docs.This URL will return 
	the entire documentation in JSON format.
	
	This looks good, but this output is only for the client which can read the JSON 
	format and can render the output.

 */

@Configuration
@EnableSwagger2 	// main annotation to enable swagger support
public class SwaggerConfig {

	/**
    *
    * @return Docket
    */
   @Bean
   public Docket api() {
       return new Docket(DocumentationType.SWAGGER_2)
           .select()
           .apis(RequestHandlerSelectors.basePackage("com.swagger2.restapi.swagger2restapi.controller"))
           .apis(RequestHandlerSelectors.any())
           .paths(PathSelectors.any())
           .build()
           .apiInfo(getApiInfo());
   }
   
   
   
   private ApiInfo getApiInfo() {
      return new ApiInfo("Documentação da Api com Swagger2",
          "Como gerar a documentação com Swagger para a sua rest API",
          "1.0", "",
          new Contact("Equipe Técnica", "www.google.com", "contato@teste.com"),
          "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
  }
}
