package app;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(MainApp.class, args);
	}

}