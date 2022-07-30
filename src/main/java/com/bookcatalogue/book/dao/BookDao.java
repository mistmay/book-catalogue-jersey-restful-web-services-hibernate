package com.bookcatalogue.book.dao;

import java.util.ArrayList;
import java.util.List;

import com.bookcatalogue.book.model.Author;
import com.bookcatalogue.book.model.Book;
import com.bookcatalogue.book.model.Genre;
import com.bookcatalogue.book.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class BookDao {
	public static List<Book> getAllBooks() {
		List<Book> bookList = new ArrayList<>();
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		TypedQuery<Book> query = entityManager.createQuery("select i from Book i", Book.class);
		bookList = query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return bookList;
	}
	
	public static Book addBook(String title, int authorId, String[] genres) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Author currentAuthor = entityManager.find(Author.class, authorId);
		List<Genre> currentGenres = new ArrayList<>();
		for (String current : genres) {
			currentGenres.add(entityManager.find(Genre.class, Integer.parseInt(current)));
		}
		Book book = new Book();
		book.setAuthor(currentAuthor);
		book.setGenres(currentGenres);
		book.setTitle(title);
		entityManager.persist(book);
		entityManager.getTransaction().commit();
	    entityManager.close();
	    return book;
	}
	
	public static Book addBook(Book book) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(book);
		entityManager.getTransaction().commit();
	    entityManager.close();
	    return book;
	}
	
	public static Book updateBook(String title, int authorId, String[] genres, int idBook) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Author currentAuthor = entityManager.find(Author.class, authorId);
		List<Genre> currentGenres = new ArrayList<>();
		for (String current : genres) {
			currentGenres.add(entityManager.find(Genre.class, Integer.parseInt(current)));
		}
		Book book = entityManager.find(Book.class, idBook);
		book.setAuthor(currentAuthor);
		book.setGenres(currentGenres);
		book.setTitle(title);
		entityManager.getTransaction().commit();
	    entityManager.close();
	    return book;
	}
	
	public static Book updateBook(Book book) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Book currentBook = entityManager.find(Book.class, book.getId());
		currentBook = book;
		entityManager.getTransaction().commit();
	    entityManager.close();
	    return currentBook;
	}
	
	public static void removeBook(int id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Book book = entityManager.find(Book.class, id);
		entityManager.remove(book);
		entityManager.getTransaction().commit();
	    entityManager.close();
	}
	
	public static Book getBookById(int id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return book;
	}
}
