package demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Profile("dev")
public class WebConfigDev extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/app/**").addResourceLocations(
		"classpath:/static/app/");
	registry.addResourceHandler("/bower_components/**")
		.addResourceLocations("classpath:/static/bower_components/");
	registry.addResourceHandler("/scripts/**").addResourceLocations(
		"classpath:/static/app/scripts/");
	registry.addResourceHandler("/styles/**").addResourceLocations(
		"classpath:/static/app/styles/");
	registry.addResourceHandler("/views/**").addResourceLocations(
		"classpath:/static/app/views/");
	registry.addResourceHandler("/images/**").addResourceLocations(
		"classpath:/static/app/images/");
    }
}