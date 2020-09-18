package com.poc.userprofile.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.userprofile.schemas.userprofile.GetUserProfileRequest;
import com.poc.userprofile.schemas.userprofile.GetUserProfileResponse;
import com.poc.userprofile.schemas.userprofile.NewUserProfileRequest;
import com.poc.userprofile.schemas.userprofile.NewUserProfileResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserProfileController {


	@Autowired
	SOAPConnector soapConnector;
	
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully inserted new user"),
			@ApiResponse(code = 401, message = "You are not authorized to call the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	@ApiOperation(value = "This service will insert new user.")
	@PostMapping("/newuser")
	public @ResponseBody NewUserProfileResponse newUserProfileResponse(@RequestBody NewUserProfileRequest request) {
		log.info("Inserting new user request");
		NewUserProfileResponse response =(NewUserProfileResponse) soapConnector.callWebService("http://localhost:8080/service/user-profile", request);
		return response;
	}
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved user"),
			@ApiResponse(code = 401, message = "You are not authorized to call the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	@ApiOperation(value = "This service will get user.")
	@PostMapping("/getuser")
	public @ResponseBody GetUserProfileResponse getUserProfileResponse(@RequestBody GetUserProfileRequest request) {
		log.info("Retrieving user ");
		GetUserProfileResponse response = (GetUserProfileResponse) soapConnector.callWebService("http://localhost:8080/service/get-user-profile", request);
		return response;
	}
}
