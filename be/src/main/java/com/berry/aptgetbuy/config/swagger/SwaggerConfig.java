package com.berry.aptgetbuy.config.swagger;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//	Swagger-UI 2.x
//	http://localhost:8080/swagger-ui.html
//	Swagger-UI 3.x
//	http://localhost:8080/swagger-ui/index.html

    private static final String title = "AptGetBuy";
    private static final String version = "3.0";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).consumes(getConsumeContentTypes()).produces(getProduceContentTypes())
                .apiInfo(apiInfo()).groupName(version).select()
                .apis(RequestHandlerSelectors.basePackage("com.straw.aptgetbuy.controller"))
                .paths(regex("/.*")).build()
                .useDefaultResponseMessages(false);
    }

    private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        consumes.add("application/xml;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");
        return consumes;
    }

    private Set<String> getProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        produces.add("application/json;charset=UTF-8");
        return produces;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(title)
                .description("<h3>AptGetBuy</h3>with Spring Boot 2, Vue 2<br>")
                .contact(new Contact("berry2971", "https://ddoongi.tistory.com/", "berry2971@hanmail.net"))
                .license("MIT License")
                .licenseUrl("https://opensource.org/licenses/MIT")
                .version(version).build();
    }

}
