package com.bookcatalogue.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookcatalogue.book.dao.AuthorDao;
import com.bookcatalogue.book.dao.BookDao;
import com.bookcatalogue.book.model.Book;

@WebServlet("/AddAuthor")
public class AddAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		AuthorDao.addAuthor(name, surname);
		List<Book> bookList = BookDao.getAllBooks();
		request.setAttribute("bookList", bookList);
		request.setAttribute("formType", "list");
		dispatcher.forward(request, response);
	}

}
