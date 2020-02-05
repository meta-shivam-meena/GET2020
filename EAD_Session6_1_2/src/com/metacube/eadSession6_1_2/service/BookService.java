package com.metacube.eadSession6_1_2.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.eadSession6_1_2.dao.BookDao;
import com.metacube.eadSession6_1_2.model.Book;
import com.metacube.eadSession6_1_2.model.Response;

@Path("/books")
public class BookService {
	BookDao bookDao;

	public BookService() {
		bookDao = BookDao.getBookDao();
	}

	@POST
	@Path("/addBook")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createNewBook(@FormParam("id") int id,
			@FormParam("title") String title,
			@FormParam("writer") String writer,
			@FormParam("publisher") String publisher,
			@FormParam("publishedYear") int publishedYear) {
		Book book = new Book(id, title, writer, publisher, publishedYear);
		bookDao.addBook(book);
	}

	@GET
	@Path("/getAllBooks")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAllBooks() {
		List<Book> books = bookDao.getAllBooks();
		return books;
	}

	@PUT
	@Path("/getBook")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Book> getBook(@FormParam("title") String title) {
		List<Book> books = bookDao.getBook(title);
		return books;
	}

	@PUT
	@Path("/updateBook")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateBook(@FormParam("oldTitle") String oldTitle,
			@FormParam("oldPublishedYear") int oldPublishedYear,
			@FormParam("newId") int newId,
			@FormParam("newTitle") String newTitle,
			@FormParam("newWriter") String newWriter,
			@FormParam("newPublisher") String newPublisher,
			@FormParam("newPublishedYear") int newPublishedYear) {
		Book book = new Book(newId, newTitle, newWriter, newPublisher,
				newPublishedYear);
		bookDao.updateBook(oldTitle, oldPublishedYear, book);
	}
	
	@DELETE
	@Path("/deleteBook")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteBook(@FormParam("id") int id) {
		bookDao.deleteBook(id);
	}
	
	@DELETE
	@Path("/deleteAllBooks")
	public void deleteAllBooks() {
		bookDao.deleteAllBooks();
	}
}
