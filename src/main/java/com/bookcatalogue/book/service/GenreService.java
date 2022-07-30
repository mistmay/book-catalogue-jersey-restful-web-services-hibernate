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

import com.bookcatalogue.book.dao.GenreDao;
import com.bookcatalogue.book.model.Genre;

@Path("/genre")
public class GenreService {
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Genre> getGenres_JSON() {
		return GenreDao.getAllGenres();
	}

	@GET
	@Path("/genre/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Genre getGenreByIdJson(@PathParam("id") int id) {
		return GenreDao.getGenreById(id);
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Genre addGenre(Genre genre) {
		return GenreDao.addGenre(genre);
	}

	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Genre updateGenre(Genre genre) {
		return GenreDao.updateGenre(genre);
	}

	@DELETE
	@Path("/genre/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteGenre(@PathParam("id") int id) {
		GenreDao.removeGenre(id);
	}
}
