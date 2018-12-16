package com.sys.book.model;

public interface ILibrary {

	public boolean addBook(Book m);
	
//	public boolean addMaga(Magazine m);
	
	public boolean delBook(String isbn);
	
	public Book[] allBooks();
	
	public void showAll();
	
	public void showAllBooks();
	
	public void showAllMagazines();
	
	public int size(String type);
	
	public Book getBook(String title);
}
