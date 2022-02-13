package store.antawa.apps.backoffice.backend.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
public class AppMultipartConfiguracion {

	
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofBytes(512000000L));
        factory.setMaxRequestSize(DataSize.ofBytes(512000000L));
        return factory.createMultipartConfig();
    }
   /* 
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(100000);
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        return commonsMultipartResolver;
    }*/

	/*
    @Bean(name = "multipartResolver")  
    public MultipartResolver multipartResolver()  
    {  
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();  
        // resolver.setDefaultEncoding("UTF-8");  
        // resolver.setResolveLazily(true);// The resolveLazily property is enabled to defer file parsing to catch file size exceptions in UploadAction
        resolver.setMaxInMemorySize(5011063);  
        resolver.setMaxUploadSize(1000 * 1024 * 1024);// Upload file size 5M 5*1024*1024
        return resolver;  
    }*/

}
