package com.example.validation.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ObjectCoverter {

	@Autowired
	private  ObjectMapper objectMapper;
	
	@SuppressWarnings("unchecked")
	public  Map<String, Object> convertObjectToMap(Object obj){
		try {
		return objectMapper.convertValue(obj, Map.class);
		}catch (Exception ex) {
			log.error("Exception occurred",ex);
			return null;
		}
	}
	
}
