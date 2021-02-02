package junia.lab04.web;

import junia.lab04.core.config.AppConfig;
import junia.lab04.core.config.DBConfig;
import junia.lab04.web.config.WebConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Initializer.class);

    @Override
    protected Class<?>[] getRootConfigClasses() {
        LOGGER.info("getRootConfigClasses called");
        Class[] rootConfigClasses = new Class[2];
        rootConfigClasses[0] = AppConfig.class;
        rootConfigClasses[1] = DBConfig.class;
        LOGGER.debug("Return : {}", rootConfigClasses.toString());
        return rootConfigClasses;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        LOGGER.info("getServletConfigClasses called");
        Class[] servletConfigClasses = new Class[1];
        servletConfigClasses[0] = WebConfig.class;
        LOGGER.debug("Return : {}", servletConfigClasses.toString());
        return servletConfigClasses;
    }

    @Override
    protected String[] getServletMappings() {
        LOGGER.info("getServletMappings called");
        String[] servletMapping = new String[1];
        servletMapping[0] = "/";
        LOGGER.debug("Return : {}", servletMapping.toString());
        return servletMapping;
    }
}
