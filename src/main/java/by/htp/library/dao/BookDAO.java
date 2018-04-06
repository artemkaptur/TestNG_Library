package by.htp.library.dao;

import java.util.List;

import by.htp.library.bean.Book;

public interface BookDAO extends BaseDAO<Book>{
	
	public List<Book> readByTitle(String title);

}
