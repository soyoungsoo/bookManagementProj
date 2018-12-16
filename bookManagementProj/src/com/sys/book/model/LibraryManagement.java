package com.sys.book.model;

import java.util.ArrayList;


public class LibraryManagement implements ILibrary {

	public LibraryManagement() {}
	ArrayList<Book> books = new ArrayList<>();
	String tmp = "";
	@Override
	public boolean addBook(Book book) {
		books.add(book);
		showAll();
		return true;
	}

	@Override
	public boolean delBook(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				books.remove(books.indexOf(book));
				return true;
			}
		}
		return false;
	}

	@Override
	public Book[] allBooks() {
		return null;
	}

	@Override
	public void showAll() {
		for (Book book : books) {
			System.out.println(book.toString());
		}
	}
	@Override
	public void showAllBooks() {
		System.out.println("*** 일반도서 목록 ***");
		for (Book book : books) {
			if (book.getIsbn().contains("B")) {
				System.out.println(book.toString());
			}
		}
	}

	@Override
	public void showAllMagazines() {
		System.out.println("*** 잡지 목록 ***");
		for (Book book : books) {
			if (book.getIsbn().contains("M")) {
				System.out.println(book.toString());
			}
		}
	}

	@Override
	public int size(String type) {
		int Msize = 0,Bsize = 0;
		
		if (type.equals("B")) {
			for (Book book : books) {				
				if (book.getIsbn().substring(0,1).equals("B")) {
					Bsize+=1;
				}
			}
			return Bsize;
		}else {
			for (Book book : books) {		
				System.out.println(book.toString());
				if (book.getIsbn().substring(0,1).equals("M")) {
					Msize+=1;
				}
			}			
		}		
		return Msize;
	}

	@Override
	public Book getBook(String title) {
			for (Book book : books) {
				if (book.getTitle().equals(title)) {
					System.out.println(book.toString());			
				}
				return book;
			}			
		return null;
	}
}
