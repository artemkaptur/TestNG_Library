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

import by.htp.library.bean.Employee;
import by.htp.library.dao.impl.EmployeeDaoDBImpl;
import by.htp.library.dao.impl.util.DBConnectionHelper;

public class EmployeeDAOTest {

	private Connection connection;
	private List<Employee> expectedList;
	private EmployeeDAO employeeDao;
	private Statement st;

	@BeforeClass
	public void initDBConnection() throws SQLException {
		connection = DBConnectionHelper.connect();
		st = connection.createStatement();
		System.out.println("BeforeClass: connected to DB");
	}

	@BeforeMethod
	public void ititDao() {
		employeeDao = new EmployeeDaoDBImpl();
		System.out.println("BeforeMethod: employeeDao was initialized");
	}
	
	@Test
	public void testCreatedCorrectEmployeek() throws SQLException {
		Employee employee = new Employee (3, "Ivan", "Ivanych");
		employeeDao.create(employee);

		int expectedCount = 0;
		ResultSet rs = st.executeQuery("SELECT COUNT(id) FROM employees WHERE surname = 'Ivanych'");
		while (rs.next()) {
			expectedCount = rs.getInt("COUNT(id)");
		}
		Assert.assertTrue(expectedCount > 0, "The employee wasn't inserted in DB");
	}
	
	@Test
	public void testDeletedCorrectEmployee() throws SQLException {
		employeeDao.delete(3);

		int expectedCount = 0;
		ResultSet rs = st.executeQuery("SELECT COUNT(id) FROM employees WHERE surname = 'Ivanych'");
		while (rs.next()) {
			expectedCount = rs.getInt("COUNT(id)");
		}
		Assert.assertTrue(expectedCount == 0, "The employee wasn't deleted from DB");
	}

	@Test
	public void testReceviedCorrectEmployeeCount() throws SQLException {
		int expectedCount = 0;
		ResultSet rs = st.executeQuery("SELECT COUNT(id) FROM employees");

		while (rs.next()) {
			expectedCount = rs.getInt("COUNT(id)");
		}
		List<Employee> actualList = employeeDao.readAll();
		Assert.assertEquals(actualList.size(), expectedCount,
				"The recieved count of employees is not equal real count in DB");
	}

	@Test
	public void testReceviedCorrectEmployees() throws SQLException {
		ResultSet rs = st.executeQuery("SELECT * FROM employees");
		expectedList = new ArrayList<>();

		while (rs.next()) {
			Employee employee = new Employee();
			employee.setId(rs.getInt("id"));
			employee.setName(rs.getString("name"));
			employee.setSurname(rs.getString("surname"));
			expectedList.add(employee);
		}
		List<Employee> actualList = employeeDao.readAll();
		Assert.assertEquals(actualList, expectedList, "The recieved employees are not equal real employees in DB");
	}

	@Test
	public void testReceviedEmptyList() throws SQLException {
		ResultSet rs = st.executeQuery("SELECT * FROM employees WHERE surname = 'King in the Game'");
		expectedList = new ArrayList<>();
		while (rs.next()) {
			expectedList.add(new Employee());
		}
		List<Employee> actualList = employeeDao.readBySurname("King in the Game");
		Assert.assertEquals(actualList, expectedList, "The recieved list is not empty");
	}

	@Test
	public void testReceviedCorrectEmployee() throws SQLException {
		ResultSet rs = st.executeQuery("SELECT * FROM employees WHERE surname = 'Anderson'");
		expectedList = new ArrayList<>();

		while (rs.next()) {
			Employee employee = new Employee();
			employee.setId(rs.getInt("id"));
			employee.setName(rs.getString("name"));
			employee.setSurname(rs.getString("surname"));
			expectedList.add(employee);
		}
		List<Employee> actualList = employeeDao.readBySurname("Anderson");
		Assert.assertEquals(actualList, expectedList, "The recieved book is not equal real book in DB");
	}

	@AfterMethod
	public void m3() {
		expectedList = null;
		employeeDao = null;
		System.out.println("AfterMethod: expectedList and employeeDao are null values");
	}

	@AfterClass
	public void m4() {
		DBConnectionHelper.disconnect(connection);
		System.out.println("AfterClass: disconnect from DB");
	}

}
