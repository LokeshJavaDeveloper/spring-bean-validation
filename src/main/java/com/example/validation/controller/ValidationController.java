package com.example.validation.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.model.User;
import com.example.validation.util.ObjectCoverter;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ValidationController {

	@Autowired
	ObjectCoverter objectConverter;
	
	
	@GetMapping("hello")
	public String hello() {	
		return "hello!";
	}
	
	@PostMapping("user-new/v1")
	public ResponseEntity<String> userNew(@RequestBody @Valid User user) {	
		
		Map<String, Object> map=objectConverter.convertObjectToMap(user);
		
		log.info("User Object converted to Map:{}", map);
		
		
		return ResponseEntity.status(HttpStatus.OK).body("successfully added new user!");
	}
}
