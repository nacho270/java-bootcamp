
package com.Controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.Services.AppConfig;

@SpringBootApplication
public class ShoppingCartApplication {
	
    public static void main(String[] args) {

    	SpringApplication.run(ShoppingCartApplication.class);
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    }
}
