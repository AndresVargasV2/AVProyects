package com.av.main;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.av.main.controller.mainController;

@SpringBootApplication
@ComponentScan({"com.av.main", "com.av.main.controller"})
public class GliCrudTestApplication {

	public static void main(String[] args) {
		new File(mainController.uploadDirectory).mkdir();
		SpringApplication.run(GliCrudTestApplication.class, args);
	}

}
