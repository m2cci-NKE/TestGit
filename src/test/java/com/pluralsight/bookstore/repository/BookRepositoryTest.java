package com.pluralsight.bookstore.repository;

import static org.junit.Assert.*;

import java.sql.Date;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.pluralsight.bookstore.model.Book;
import com.pluralsight.bookstore.model.Language;
import com.pluralsight.bookstore.util.IsbnGenerator;
import com.pluralsight.bookstore.util.NumberGenerator;
import com.pluralsight.bookstore.util.TextUtil;


@RunWith(Arquillian.class)

public class BookRepositoryTest {
	@Inject
    private BookRepository bookRepository;
	
	@Test(expected = Exception.class)
	
	public void  findWithInvalidId() {
		bookRepository.find(null);
	}
	
	@Test(expected = Exception.class)
	public void createInvalidBook() {
		Book book = new Book("isbn", null,"description", 12F, 123, 
						Language.ENGLISH, new Date(0), "http://blhblahl");
        
        book=bookRepository.create(book);
        Long bookId = book.getId();
      //Check 
        assertNotNull(bookId);
        
        bookRepository.delete(bookId);
	}
	
	
	@Test
	public void testCreate() throws Exception {
		
		// Count all
//	       assertEquals(Long.valueOf(0), bookRepository.countAll());
//	        // Find all
//	       assertEquals(0, bookRepository.findAll().size());
	       
  // Create book
		        Book book = new Book("isbn", "a  title","description", 12F, 123, Language.ENGLISH, new Date(0), "http://blhblahl");
		        
		        book=bookRepository.create(book);
			
		        Long bookId = book.getId();
		        
		        //Check
		     assertNotNull(bookId);
		     // find created book
		
		     Book bookFound = bookRepository.find(bookId);
		     
		     assertEquals("a title", bookFound.getTitle());
		     assertTrue(bookFound.getIsbn().startsWith("13"));      
		       
		        // delete
		       bookRepository.delete(bookId);
		        
//		    	// Count all
//		        assertEquals(Long.valueOf(0), bookRepository.countAll());
//		        // Find all
//	       assertEquals(0, bookRepository.findAll().size());
	      
	}


	 @Deployment
	    public static JavaArchive createDeployment() {

	        return ShrinkWrap.create(JavaArchive.class)
	           
	            .addClass(BookRepository.class)
	            .addClass(Language.class)
	            .addClass(Book.class)
	            .addClass(TextUtil.class)
	            .addClass(NumberGenerator.class)
	            .addClass(IsbnGenerator.class)
	            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
	            .addAsManifestResource("META-INF/persistence.xml", "persistence.xml");
	    }




}
