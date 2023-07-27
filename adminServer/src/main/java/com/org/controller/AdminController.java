package com.org.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.dto.AdminDTO;
import com.org.exception.AdminServiceException;
import com.org.service.AdminService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@CrossOrigin
@RestController
@Tag(name = "AdminController" , description = "Endpoints for Admin")
@RequestMapping("/admin")
public class AdminController {

		@Autowired 
		private AdminService adminService;

		@PostMapping (value="/register")
		public ResponseEntity<String> registration (@RequestBody @Valid AdminDTO admin) throws AdminServiceException{

			String msg = adminService.adminRegistration(admin);
			return new ResponseEntity<> (msg, HttpStatus.OK);

		}

		@Operation(summary = "Logging API for admin", description = "To login please enter userId and password")
		@ApiResponse(responseCode = "200", description = "logged in to system successfully",content = @Content(mediaType = "application/json", schema = @Schema(implementation = AdminDTO.class)))
		@GetMapping (value="/login/{userName}/{password}") 
		public ResponseEntity<AdminDTO> login(@PathVariable String userName, @PathVariable String password) throws AdminServiceException {

			AdminDTO admin = adminService.adminLogin(userName, password);
			return new ResponseEntity<> (admin, HttpStatus.OK);

		}

		@GetMapping (value="/test")
		public ResponseEntity<String> test() throws AdminServiceException {
			return new ResponseEntity<>("success", HttpStatus.OK);
		}
}
