package com.ks.rrs.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyInitialization extends ResourceConfig {
	    /**
	     * Register JAX-RS application components.
	     */
	    public JerseyInitialization(){
	        this.packages("com.ks.rrs");
	    }
	}

