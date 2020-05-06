package com.pluralsight.bookstore.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pluralsight.bookstore.model.Book;
import com.pluralsight.bookstore.repository.BookRepository;


@Path("/Books") /* path annotation: to make this class REST endpoint */ 
public class BookEndpoint {
	
	@Inject
	private BookRepository bookRepository;

	public Book getBook(Long id) {
		return bookRepository.find(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON) /* return all the books in JSON format */
	public Response getBooks() {
		
		List<Book> books = bookRepository.findAll();
		
		if (books.size()==0) 
			return Response.noContent().build();
		return Response.ok(books).build();
	  }

	public Long countBook() {
		return bookRepository.countAll();
	}

	public Book createBook(Book book) {
		return bookRepository.create(book);
	}

	public void deleteBook(Long id) {
		bookRepository.delete(id);
	}
	

}
