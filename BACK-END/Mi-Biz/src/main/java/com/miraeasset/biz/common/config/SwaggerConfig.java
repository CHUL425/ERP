package com.miraeasset.biz.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2

public class SwaggerConfig extends WebMvcConfigurationSupport {


    @Bean
    public Docket swaggerApi(){

        //.apis(RequestHandlerSelectors.any())
        //.apis(RequestHandlerSelectors.basePackage("com.miraeasset.biz.budget.controller"))
        //.apis(RequestHandlerSelectors.basePackage("com.miraeasset.biz"))
        //.paths(PathSelectors.ant("/**"))
        //.paths(PathSelectors.ant("/api/main/budget/**"))
        //.paths(PathSelectors.regex("/api/(main/budget|common/login)/.*"))

        return new Docket(DocumentationType.SWAGGER_2)
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .select()
                .paths((PathSelectors.any()))
                .build().apiInfo(apiInfo());
    }

    private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");
        return consumes;
    }

    private Set<String> getProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        produces.add("application/json;charset=UTF-8");
        return produces;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        super.addResourceHandlers(registry);
    }


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("MI-SUPPORT WEB API 명세서")
                .description("MI-SUPPORT WEB API 명세서")
                .version("v0.1")
                .build();
    }
}
