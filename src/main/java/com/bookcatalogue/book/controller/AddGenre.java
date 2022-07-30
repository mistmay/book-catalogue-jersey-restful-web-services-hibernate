package com.bookcatalogue.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookcatalogue.book.dao.BookDao;
import com.bookcatalogue.book.dao.GenreDao;
import com.bookcatalogue.book.model.Book;

@WebServlet("/AddGenre")
public class AddGenre extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		String name = request.getParameter("name");
		GenreDao.addGenre(name);
		List<Book> bookList = BookDao.getAllBooks();
		request.setAttribute("bookList", bookList);
		request.setAttribute("formType", "list");
		dispatcher.forward(request, response);
	}

}
