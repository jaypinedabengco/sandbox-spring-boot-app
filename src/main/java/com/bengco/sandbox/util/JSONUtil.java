package com.bengco.sandbox.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {

	private JSONUtil() {}
	
	/**
	 * 
	 * @param object
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String convertToJSON(final Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
