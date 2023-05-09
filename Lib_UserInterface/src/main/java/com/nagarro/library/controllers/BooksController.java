package com.nagarro.library.controllers;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarro.library.dao.BooksDao;
import com.nagarro.library.entities.Books;

@Controller
public class BooksController {

	@RequestMapping("/updatebook")
	public void updatebook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String bookName = request.getParameter("bookName");
		int bookId = Integer.parseInt(request.getParameter("bookCode"));
		String author = request.getParameter("authors");
		String date= request.getParameter("DateUpdated");
		BooksDao.updateBook(new Books(bookId, bookName, author, date));
		response.sendRedirect("admin.jsp");
	}
	
	@RequestMapping("/addbooks")
	public void addbooks(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String bookName = request.getParameter("bookName");
		int bookId = Integer.parseInt(request.getParameter("bookCode"));
		String author = request.getParameter("authors");
		String date= request.getParameter("DateUpdated");
		BooksDao.addbook(new Books(bookId, bookName, author, date));
		response.sendRedirect("admin.jsp");
	}
		
	@RequestMapping(value = "/deletebook/{bookId}")
	public void deletebook(@PathVariable int id) {
		BooksDao.delete(id);
	}
	
}
