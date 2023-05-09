package com.nagarro.library.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.library.entities.Books;

public class BooksDao {

	static RestTemplate restTemplate = new RestTemplate();
	
	public static void updateBook(Books books) {
		restTemplate.postForEntity("http://localhost:8080/booksupdate", books,Books.class);
	}

	public static List<Books> getallBooks() {

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = restTemplate.getForObject("http://localhost:4000/books", JsonNode.class);
		List<Books> books = mapper.convertValue(node, new TypeReference<List<Books>>() {
		});
		return books;
	}
	public static void addbook(Books book) {
	restTemplate.postForEntity("http://localhost:4000/books", book, Books.class);
	
	}
	
	public static Books getBookById(int id) {
		Map<String, Integer> param=new HashMap<String, Integer>();
		param.put("bookId", id);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = restTemplate.getForObject("http://localhost:4000/books/{bookId}", JsonNode.class,param);
		Books books= mapper.convertValue(node, new TypeReference<Books>() {
		});
		return books;
	}
	public static void delete(int id) {
		Map<String, Integer> param=new HashMap<String, Integer>();
		param.put("bookId", id);
		restTemplate.delete("http://localhost:4000/books/{bookId}",param);
	}
}
