package com.metacube.eadSession6_1_2.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="book")
public class Book {
	private int id;
	private String title;
	private String writer;
	private String publisher;
	private int publishedYear;
	
	public Book(int id, String title, String writer, String publisher,
			int publishedYear) {
		super();
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.publishedYear = publishedYear;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
}
