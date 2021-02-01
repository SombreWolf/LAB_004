package junia.lab04.web.config;

import com.shieldsolutions.velocity.view.VelocityConfigurer;
import com.shieldsolutions.velocity.view.VelocityViewResolver;
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
    @Bean
    public VelocityConfigurer velocityConfigurer(){
        VelocityConfigurer v = new VelocityConfigurer();
        v.setResourceLoaderPath("/WEB-INF/velocity");
        return v;
    }

    @Bean
    public VelocityViewResolver velocityViewResolver(){
        VelocityViewResolver v = new VelocityViewResolver();
        v.setSuffix(".vm");
        return v;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }
}
