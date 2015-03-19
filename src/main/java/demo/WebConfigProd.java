package demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Profile("prod")
public class WebConfigProd extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/app/**").addResourceLocations("/webapp/");
	registry.addResourceHandler("/scripts/**").addResourceLocations(
		"/webapp/scripts/");
	registry.addResourceHandler("/styles/**").addResourceLocations(
		"/webapp/styles/");
	registry.addResourceHandler("/views/**").addResourceLocations(
		"/webapp/views/");
	registry.addResourceHandler("/images/**").addResourceLocations(
		"/webapp/images/");
	registry.addResourceHandler("/fonts/**").addResourceLocations(
		"/webapp/fonts/");
    }
}