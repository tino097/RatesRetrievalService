package com.ks.rrs;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.ks.rrs.config.JerseyInitialization;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	   @Bean
	    public ServletRegistrationBean jerseyServlet() {
	        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/*");
	        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyInitialization.class.getName());
	        return registration;
	    }
}
