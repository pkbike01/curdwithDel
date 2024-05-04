package com.crudoperationRestApi;

import org.springdoc.core.GroupedOpenApi;
//import org.springdoc.core.models.GroupedOpenApi;
//import org.springdoc.core.GroupedOpenApi;
//import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
//@EnableSwagger2
public class SwaggerConfig {
	
	
	
//	@Configuration
//	public class SpringFoxConfig {                                    
//	    @Bean
//	    public Docket api() { 
//	        return new Docket(DocumentationType.SWAGGER_2)  
//	          .select()                                  
//	          .apis(RequestHandlerSelectors.any())              
//	          .paths(PathSelectors.any())                          
//	          .build();                                           
//	    }
//	}
	
	
	@Bean
    public GroupedOpenApi customOpenAPI() {
        return GroupedOpenApi.builder().group("user").pathsToMatch("/**").build();
//                .info(new Info().title("Your API").version("1.0.0"));
    }
	
	
	
//    @Bean
//    public GroupedOpenApi publicApi() {
//        String[] paths = {"/public/**"};
//        return GroupedOpenApi.builder().group("public-api").pathsToMatch(paths)
//                .build();
//    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
	

}
