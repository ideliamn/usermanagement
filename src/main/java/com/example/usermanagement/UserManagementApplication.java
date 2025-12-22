package com.example.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usermanagement.dto.ApiResponse;

@SpringBootApplication
public class UserManagementApplication {

	@RestController
	public class HelloController {

		@GetMapping("/hello")
		public ApiResponse<String> hello() {
			return ApiResponse.success();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}

}
