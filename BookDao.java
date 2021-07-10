package utd.library.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import utd.library.dao.IBookDAO;
import utd.library.entity.Authors;
import utd.library.entity.Book;

@Repository
public class BookDAO implements IBookDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Book> getAllBooks() {
		String hql = "FROM Book";
		return (List<Book>) hibernateTemplate.find(hql);
	}

	@Override
	public Book getBookById(Long id) {
		Book book = hibernateTemplate.get(Book.class, id);
		return book;
	}

	@Override
	public List<Book> getBookByTitle(String title) {
		Criteria c = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Book.class);
		c.add(Restrictions.like("title", title + "%", MatchMode.END));
		List<Book> books = c.list();
		return books;
	}

	@Override
	public List<Book> getBooksByAuthorName(String title) {
		Criteria c = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Book.class);
		c.createAlias("authers", "au").add(Restrictions.like("au.name", title + "%", MatchMode.END));
		List<Book> books = c.list();
		return books;
	}

	@Override
	public List<Book> getBooksByKey(String key) {
		Criteria c = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Book.class);
		c.add(Restrictions.like("title", key, MatchMode.END));
		c.createAlias("authers", "au").add(Restrictions.like("au.name", key, MatchMode.END));
		List<Book> books = c.list();
		return books;
	}



}