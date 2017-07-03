package lv.javaguru.java2.smvc;

import lv.javaguru.java2.configs.SpringConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by admin on 07.06.2017.
 */
public class SpringWebMvcSimpleInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                SpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class[]{
                SpringMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {

        return new String[]{"/smvc/*"};
    }
}
