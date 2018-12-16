package com.sys.book.model;

public class Magazine extends Book {

	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String desc;	
	private int year;
	private int month;
	
	public Magazine() {}

	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year,
			int month) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
		this.year = year;
		this.month = month;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		if (year == 0 || month ==0) {
			return  isbn + " | " + title + " | " + author + " | " + publisher
					+ " | " + price + "원 | " + desc;
		}else {
			return  isbn + " | " + title + " | " + author + " | " + publisher
					+ " | " + price + "원 | " + desc + " | " + year + " | " + month;
		}
	}
	
	
}
