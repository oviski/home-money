package lv.javaguru.java2.smvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by admin on 07.06.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "lv.javaguru.java2/smvc")
public class SpringMvcConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/smvc-jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
/*
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("*//**").addResourceLocations("/");
    }*/

    @Bean("modelAndView")
    @Scope("request")
    public ModelAndView getModelAndView(){
        return new ModelAndView();
    }


}