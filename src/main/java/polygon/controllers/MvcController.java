package polygon.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableTransactionManagement
public class MvcController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/performance").setViewName("performance");
        registry.addViewController("/selectRoom").setViewName("selectRoom");

        registry.addViewController("/films").setViewName("films");
        registry.addViewController("/cinemas").setViewName("cinemas");
        registry.addViewController("/events").setViewName("events");
        registry.addViewController("/stocks").setViewName("stocks");
        registry.addViewController("/imax").setViewName("imax");

        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").
                addResourceLocations("classpath:/images/");
        registry.addResourceHandler("/js/**").
                addResourceLocations("classpath:/js/");
    }


}
