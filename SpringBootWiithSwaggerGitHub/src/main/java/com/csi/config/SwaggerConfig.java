package com.csi.config;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Bean;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2).select()
                    .apis(RequestHandlerSelectors.basePackage("com.csi")).paths(PathSelectors.ant("/foos/*")).build()
                    .apiInfo(apiEndPointsInfo());
        }

        private ApiInfo apiEndPointsInfo() {
            return new ApiInfoBuilder().title("HRM - Spring Boot Swagger Configuration")
                    .description("\" Human Management System \"").version("1.1.0").license("Apache 2.0")
                    .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                    .contact(new Contact("Kiran Jadhav", "http://www.lms.com/", "jadhavkiran150590@gmail.com")).build();
        }
    }


