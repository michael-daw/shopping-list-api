package com.mdaw.ShoppingListAPI;

import com.mdaw.ShoppingListAPI.config.StoreProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StoreProperties.class) // Optional but useful for clarity
public class ShoppingListApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShoppingListApiApplication.class, args);
	}
}
