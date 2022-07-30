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
import com.bookcatalogue.book.dao.GenreDao;
import com.bookcatalogue.book.model.Author;
import com.bookcatalogue.book.model.Book;
import com.bookcatalogue.book.model.Genre;

@WebServlet("/ToUpdateForm")
public class ToUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		int id = Integer.parseInt(request.getParameter("toUpdate"));
		Book book = BookDao.getBookById(id);
		List<Author> authorList = AuthorDao.getAllAuthors();
		List<Genre> genreList = GenreDao.getAllGenres();
		request.setAttribute("bookUpdate", book);
		request.setAttribute("authorList", authorList);
		request.setAttribute("genreList", genreList);
		request.setAttribute("formType", "update");
		dispatcher.forward(request, response);
	}

}
