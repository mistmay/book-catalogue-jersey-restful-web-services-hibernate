package com.bookcatalogue.book.dao;

import java.util.ArrayList;
import java.util.List;

import com.bookcatalogue.book.model.Genre;
import com.bookcatalogue.book.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class GenreDao {
	public static List<Genre> getAllGenres() {
		List<Genre> genreList = new ArrayList<>();
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		TypedQuery<Genre> query = entityManager.createQuery("select i from Genre i", Genre.class);
		genreList = query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return genreList;
	}

	public static Genre addGenre(String name) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Genre genre = new Genre();
		genre.setName(name);
		entityManager.persist(genre);
		entityManager.getTransaction().commit();
		entityManager.close();
		return genre;
	}

	public static Genre addGenre(Genre genre) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(genre);
		entityManager.getTransaction().commit();
		entityManager.close();
		return genre;
	}

	public static Genre updateGenre(Genre genre) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Genre currentGenre = entityManager.find(Genre.class, genre.getId());
		currentGenre = genre;
		entityManager.getTransaction().commit();
		entityManager.close();
		return currentGenre;
	}

	public static void removeGenre(int id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Genre genre = entityManager.find(Genre.class, id);
		entityManager.remove(genre);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public static Genre getGenreById(int id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Genre genre = entityManager.find(Genre.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		return genre;
	}
}
