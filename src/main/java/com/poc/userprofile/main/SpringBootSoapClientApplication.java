package com.poc.userprofile.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSoapClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapClientApplication.class, args);
	}
	
	
	/*@Bean
	CommandLineRunner lookup(SOAPConnector soapConnector) {
		return args -> {
			String name = "Sajal";//Default Name
			if(args.length>0){
				name = args[0];
			}
			UserProfileRequest request = new UserProfileRequest();
			request.setUserName(name);
			UserProfileResponse response =(UserProfileResponse) soapConnector.callWebService("http://localhost:8080/service/student-details", request);
			System.out.println("Got Response As below ========= : ");
			System.out.println("Name : "+response.getUserProfile().getUserName());
			System.out.println("Standard : "+response.getUserProfile().getUserId());
			System.out.println("Address : "+response.getUserProfile().getUserStatus());
		};
	}*/
	
	
}
