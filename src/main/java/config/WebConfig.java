package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Map the URL path "/uploads/**" to the directory containing the uploaded files
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:C:/uploads/");

        // Specify the absolute path where files are stored
    }
}
