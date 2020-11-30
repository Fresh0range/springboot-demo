package org.jzy.demo.jpa;

import com.github.xiaoymin.knife4j.spring.annotations.EnableSwaggerBootstrapUi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUi
public class Swagger2Configuration {
    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.jzy.demo.jpa.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("JPA Demo")
                .description("JPA功能演示")
                .termsOfServiceUrl(null)
                .license(null)
                .licenseUrl(null)
                .contact(new Contact("Fresh0range", null, "1834888164@qq.com"))
                .version(null)
                .build();
    }
}
