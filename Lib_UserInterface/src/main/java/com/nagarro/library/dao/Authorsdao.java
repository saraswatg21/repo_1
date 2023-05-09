package com.nagarro.library.dao;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.library.entities.Authors;


public class Authorsdao {

	static RestTemplate restTemplate = new RestTemplate();

	public static List<Authors> getallAuthors() {

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = restTemplate.getForObject("http://localhost:4000/author", JsonNode.class);
		List<Authors> authors = mapper.convertValue(node, new TypeReference<List<Authors>>() {
		});
		return authors;
	}
}
