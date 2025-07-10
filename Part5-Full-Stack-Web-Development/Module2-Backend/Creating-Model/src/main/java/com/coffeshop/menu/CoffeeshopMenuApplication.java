package com.coffeshop.menu;

import com.coffeshop.menu.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoffeeshopMenuApplication {


	public static void main(String[] args) {
		SpringApplication.run(CoffeeshopMenuApplication.class, args);
//		Product espresso = new Product(1,"Espresso", 2.3);
//		Product croissant = new Product(1,"Croissant", 3.45);
//
//		System.out.println(espresso);
//		System.out.println(croissant);
	}


}
