package com.bookcatalogue.book.dao;

import java.util.ArrayList;
import java.util.List;

import com.bookcatalogue.book.model.Author;
import com.bookcatalogue.book.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class AuthorDao {
	public static List<Author> getAllAuthors() {
		List<Author> authorList = new ArrayList<>();
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		TypedQuery<Author> query = entityManager.createQuery("select i from Author i", Author.class);
		authorList = query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return authorList;
	}
	
	public static Author addAuthor(String name, String surname) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Author author = new Author();
		author.setName(name);
		author.setSurname(surname);
		entityManager.persist(author);
		entityManager.getTransaction().commit();
		entityManager.close();
		return author;
	}
	
	public static Author addAuthor(Author author) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(author);
		entityManager.getTransaction().commit();
		entityManager.close();
		return author;
	}
	
	public static Author updateAuthor(Author author) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Author currentAuthor = entityManager.find(Author.class, author.getId());
		currentAuthor = author;
		entityManager.getTransaction().commit();
	    entityManager.close();
	    return currentAuthor;
	}
	
	public static void removeAuthor(int id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Author author = entityManager.find(Author.class, id);
		entityManager.remove(author);
		entityManager.getTransaction().commit();
	    entityManager.close();
	}
	
	public static Author getAuthorById(int id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author;
	}
}
