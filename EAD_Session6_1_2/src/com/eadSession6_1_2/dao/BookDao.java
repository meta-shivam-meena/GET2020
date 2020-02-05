package com.eadSession6_1_2.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.metacube.eadSession6_1_2.model.Book;

public class BookDao {
	private Connection connection;
	private static BookDao bookDao;

	private BookDao() {
		createConnection();
	}

	public static BookDao getBookDao() {
		if (bookDao == null) {
			bookDao = new BookDao();
		}
		return bookDao;
	}

	private void createConnection() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/EAD_Session6_1_2";
		String user = "root";
		String password = "shivam";

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean addBook(Book book) {
		if (connection == null) {
			createConnection();
		}
		try {
			int id = book.getId();
			String title = book.getTitle();
			String writer = book.getWriter();
			String publisher = book.getPublisher();
			int publishedYear = book.getPublishedYear();
			
			String sql = "INSERT INTO Books VALUES(?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2,title);
			preparedStatement.setString(3, writer);
			preparedStatement.setString(4, publisher);
			preparedStatement.setInt(5, publishedYear);
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public List<Book> getAllBooks() {
		if (connection == null) {
			createConnection();
		}
		
		List<Book> books = null;
		try {
			books = new ArrayList<Book>();
			String sql = "SELECT * FROM Books";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet tuples = preparedStatement.executeQuery();
			Book book;
			while (tuples.next()) {
				int id = tuples.getInt("id");
				String title = tuples.getString("title");
				String writer = tuples.getString("writer");
				String publisher = tuples.getString("publisher");
				int publishedYear = tuples.getInt("publishedYear");
				book = new Book(id, title, writer, publisher, publishedYear);
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	public List<Book> getBook(String title) {
		if (connection == null) {
			createConnection();
		}
		
		List<Book> books = null;
		try {
			books = new ArrayList<Book>();
			String sql = "SELECT * FROM Books WHERE title=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, title);
			ResultSet tuples = preparedStatement.executeQuery();
			Book book;
			while (tuples.next()) {
				int id = tuples.getInt("id");
				title = tuples.getString("title");
				String writer = tuples.getString("writer");
				String publisher = tuples.getString("publisher");
				int publishedYear = tuples.getInt("publishedYear");
				book = new Book(id, title, writer, publisher, publishedYear);
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	public boolean updateBook(String title, int publishedYear, Book book) {
		if (connection == null) {
			createConnection();
		}
		
		try {
			String sql = "UPDATE Books SET id=?, author=?, writer=?, publisher=?, publishedYear=?, WHERE title=? AND publishedYear=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean deleteBook(int id) {
		if (connection == null) {
			createConnection();
		}
		
		try {
			String sql = "DELETE FROM Books WHERE id=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean deleteAllBooks() {
		if (connection == null) {
			createConnection();
		}
		
		try {
			String sql = "DELETE FROM Books";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

	public static void main(String[] args) {
		BookDao bookDao = BookDao.getBookDao();
		Book book = new Book(0, "Tanmay", "Tanmay", "Tanmay", 2020);
		bookDao.addBook(book);
	}
}
