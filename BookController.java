package utd.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import utd.library.entity.Book;
import utd.library.service.IBookService;

@Controller
public class BookController {

	@Autowired
	private IBookService iBookService;

	@RequestMapping(value = "/book/getById/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getBookByIsbn(@PathVariable("id") Long id) throws JsonProcessingException {
		Book book = iBookService.getBookById(id);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(book);
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	@RequestMapping(value = "/book/getByTitle/{title}", method = RequestMethod.GET)
	public ResponseEntity<String> getBookByTitle(@PathVariable("title") String title) throws JsonProcessingException {
		List<Book> books = iBookService.getBookByTitle(title);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(books);
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	@RequestMapping(value = "/book/getBooksByAuthorName/{authorName}", method = RequestMethod.GET)
	public ResponseEntity<String> getBooksByAuthorName(@PathVariable("authorName") String authorName)
			throws JsonProcessingException {
		List<Book> books = iBookService.getBooksByAuthorName(authorName);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(books);
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	@RequestMapping(value = "/book/getBooksByKey/{key}", method = RequestMethod.GET)
	public ResponseEntity<String> getBooksByKey(@PathVariable("key") String key) throws JsonProcessingException {
		List<Book> books = iBookService.getBookByTitle(key);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(books);
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public ResponseEntity<String> getAllBooks() throws JsonProcessingException {
		List<Book> books = iBookService.getAllBooks();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(books);
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	

	

}