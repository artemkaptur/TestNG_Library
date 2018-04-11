package by.htp.library.console;

import static by.htp.library.console.util.InputFromConsole.*;
import static by.htp.library.console.util.OutputToConsole.*;

import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.bean.Employee;
import by.htp.library.dao.BookDAO;
import by.htp.library.dao.EmployeeDAO;
import by.htp.library.dao.impl.BookDaoDBImpl;
import by.htp.library.dao.impl.EmployeeDaoDBImpl;

public class MainApp {

	public static void main(String[] args) {

		BookDAO daoBook = new BookDaoDBImpl();
		List<Book> allBooks = daoBook.readAll();
		List<Book> booksByTitle = daoBook.readByTitle(scanInfo());

		printList(allBooks);
		printList(booksByTitle);

		Book book = new Book(3, "War and piece", "History", "Tolstoy");
		daoBook.create(book);
		allBooks = daoBook.readAll();
		printList(allBooks);

		daoBook.delete(3);
		allBooks = daoBook.readAll();
		printList(allBooks);

		EmployeeDAO daoEmployee = new EmployeeDaoDBImpl();
		List<Employee> allEmployees = daoEmployee.readAll();
		List<Employee> employeesBySurame = daoEmployee.readBySurname(scanInfo());

		printList(allEmployees);
		printList(employeesBySurame);

		Employee employee = new Employee(3, "Bill", "Turner");
		daoEmployee.create(employee);
		allEmployees = daoEmployee.readAll();
		printList(allEmployees);

		daoEmployee.delete(3);
		allEmployees = daoEmployee.readAll();
		printList(allEmployees);

	}

}