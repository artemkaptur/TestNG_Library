package by.htp.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.library.bean.Book;
import by.htp.library.dao.impl.BookDaoDBImpl;
import by.htp.library.dao.impl.util.DBConnectionHelper;

public class BookDAOTest {

	private Connection connection;
	private List<Book> expectedList;
	private BookDAO bookDao;
	private Statement st;

	@BeforeClass
	public void initDBConnection() throws SQLException {
		connection = DBConnectionHelper.connect();
		st = connection.createStatement();
		System.out.println("BeforeClass: connected to DB");
	}

	@BeforeMethod
	public void ititDao() {
		bookDao = new BookDaoDBImpl();
		System.out.println("BeforeMethod: bookDao was initialized");
	}

	@Test
	public void testCreatedCorrectBook() throws SQLException {
		Book book = new Book(3, "Run baby run", "Adventure", "Biber");
		bookDao.create(book);

		int expectedCount = 0;
		ResultSet rs = st.executeQuery("SELECT COUNT(id) FROM books WHERE title = 'Run baby run'");
		while (rs.next()) {
			expectedCount = rs.getInt("COUNT(id)");
		}
		Assert.assertTrue(expectedCount > 0, "The book wasn't inserted in DB");
	}
	
	@Test
	public void testDeletedCorrectBook() throws SQLException {
		bookDao.delete(3);

		int expectedCount = 0;
		ResultSet rs = st.executeQuery("SELECT COUNT(id) FROM books WHERE title = 'Run baby run'");
		while (rs.next()) {
			expectedCount = rs.getInt("COUNT(id)");
		}
		Assert.assertTrue(expectedCount == 0, "The book wasn't deleted from DB");
	}

	@Test
	public void testReceviedCorrectBookCount() throws SQLException {
		int expectedCount = 0;
		ResultSet rs = st.executeQuery("SELECT COUNT(id) FROM books");

		while (rs.next()) {
			expectedCount = rs.getInt("COUNT(id)");
		}
		List<Book> actualList = bookDao.readAll();
		Assert.assertEquals(actualList.size(), expectedCount,
				"The recieved count of books is not equal real count in DB");
	}

	@Test
	public void testReceviedCorrectBooks() throws SQLException {
		ResultSet rs = st.executeQuery("SELECT * FROM books");
		expectedList = new ArrayList<>();

		while (rs.next()) {
			Book book = new Book();
			book.setId(rs.getInt("id"));
			book.setTitle(rs.getString("title"));
			book.setDescription(rs.getString("description"));
			book.setAuthor(rs.getString("author"));
			expectedList.add(book);
		}
		List<Book> actualList = bookDao.readAll();
		Assert.assertEquals(actualList, expectedList, "The recieved books are not equal real books in DB");
	}

	@Test
	public void testReceviedEmptyList() throws SQLException {
		ResultSet rs = st.executeQuery("SELECT * FROM books WHERE title = 'War and piece 2'");
		expectedList = new ArrayList<>();
		while (rs.next()) {
			expectedList.add(new Book());
		}
		List<Book> actualList = bookDao.readByTitle("War and piece 2");
		Assert.assertEquals(actualList, expectedList, "The recieved list is not empty");
	}

	@Test
	public void testReceviedCorrectBook() throws SQLException {
		ResultSet rs = st.executeQuery("SELECT * FROM books WHERE title = 'Capital'");
		expectedList = new ArrayList<>();

		while (rs.next()) {
			Book book = new Book();
			book.setId(rs.getInt("id"));
			book.setTitle(rs.getString("title"));
			book.setDescription(rs.getString("description"));
			book.setAuthor(rs.getString("author"));
			expectedList.add(book);
		}
		List<Book> actualList = bookDao.readByTitle("Capital");
		Assert.assertEquals(actualList, expectedList, "The recieved book is not equal real book in DB");
	}

	@AfterMethod
	public void m3() {
		expectedList = null;
		bookDao = null;
		System.out.println("AfterMethod: expectedList and bookDao are null values");
	}

	@AfterClass
	public void m4() {
		DBConnectionHelper.disconnect(connection);
		System.out.println("AfterClass: disconnect from DB");
	}

}