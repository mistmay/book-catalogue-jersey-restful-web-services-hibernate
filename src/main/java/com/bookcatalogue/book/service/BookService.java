package com.bookcatalogue.book.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bookcatalogue.book.dao.BookDao;
import com.bookcatalogue.book.model.Book;

@Path("/book")
public class BookService {
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Book> getBooks_JSON() {
		return BookDao.getAllBooks();
	}

	@GET
	@Path("/book/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Book getBookByIdJson(@PathParam("id") int id) {
		return BookDao.getBookById(id);
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Book addBook(Book book) {
		return BookDao.addBook(book);
	}

	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Book updateBook(Book book) {
		return BookDao.updateBook(book);
	}

	@DELETE
	@Path("/book/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteBook(@PathParam("id") int id) {
		BookDao.removeBook(id);
	}
}
