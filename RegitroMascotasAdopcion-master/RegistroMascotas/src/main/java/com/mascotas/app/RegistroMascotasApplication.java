package com.mascotas.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//You want to create a Pet registry for adoption. 
// The attributes that are of interest are the following: 
//Pet[id,name,dateNac,breed,weight,tiene_chip,url_foto(string)] 
//It is requested to expose a Rest API, so that animal shelters can build apps that connect with the service to show them:
//1) Show Pet by ID 
//2) Show Pet by Name 
//3) Upload a Pet 
//4) List all pets 
//5) List the 20 youngest pets 
//6) Display all pets on pages of 5 
//7) Deleting a Pet 8) Incorporate Swagger

@SpringBootApplication
public class RegistroMascotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroMascotasApplication.class, args);
	}

}
