package utd.library.service;

import java.util.List;

import utd.library.entity.Book;

public interface IBookService {
	List<Book> getAllBooks();

	Book getBookById(Long id);

	List<Book> getBookByTitle(String title);

	List<Book> getBooksByAuthorName(String authorName);

	List<Book> getBooksByKey(String key);

	
}