package junia.lab04.web.config;

import com.shieldsolutions.velocity.view.VelocityConfigurer;
import com.shieldsolutions.velocity.view.VelocityViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "junia.lab04.web.controller")
public class WebConfig implements WebMvcConfigurer {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);

    @Bean
    public VelocityConfigurer velocityConfigurer(){
        LOGGER.info("Bean VelocityConfigurer");
        VelocityConfigurer v = new VelocityConfigurer();
        v.setResourceLoaderPath("/WEB-INF/velocity");
        LOGGER.debug("Bean VelocityConfigurer created : {}", v.toString());
        return v;
    }

    @Bean
    public VelocityViewResolver velocityViewResolver(){
        LOGGER.info("Bean VelocityViewResolver");
        VelocityViewResolver v = new VelocityViewResolver();
        v.setSuffix(".vm");
        LOGGER.debug("Bean VelocityViewResolver : {}", v.toString());
        return v;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        LOGGER.debug("Registry : {}", registry.toString());
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        LOGGER.debug("Registry : {}", registry.toString());
    }
}
