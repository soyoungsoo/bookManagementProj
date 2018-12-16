package com.sys.book.model;

import java.util.Scanner;


public class BookMain {	

	public static int bn = 1;
	public static int mbn = 1;
	public static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {	
		LibraryManagement lm = new LibraryManagement();
		int status = 0;		
		
	try {	 
		do {
			System.out.println("***************");
			System.out.println("도서관리 프로그램 시작");
			System.out.println("1번 도서 추가");
			System.out.println("2번 도서 삭제");
			System.out.println("3번 도서 검색");
			System.out.println("4번 일반 도서 목록");
			System.out.println("5번 잡지 목록");
			System.out.println("6번 도서 총권");
			status = s.nextInt();
			//Book b = new Book();
			Magazine b = new Magazine();
			Magazine m = new Magazine();
			switch (status) {
				case 1:						
					System.out.println("1번 일반도서 추가        2번 잡지추가");
					status = s.nextInt();
					s.nextLine();
					switch (status) {
					case 1:
						if (bn<10) {
							b.setIsbn("B00"+bn);							
						}else if(bn<99) {
							b.setIsbn("B0"+bn);
						}else {
							b.setIsbn("B"+bn);
						}
						bn++;
						System.out.println("책 제목을 입력하세요!");	
						if(BookValidation(b,s.nextLine(),"title")) {		
							System.out.println("책 저자 이름을 입력하세요!");							
							if(BookValidation(b,s.nextLine(),"author")) {
								System.out.println("춢판사 이름을 입력하세요!");							
								if(BookValidation(b,s.nextLine(),"publisher")) {
									System.out.println("가격을 입력하세요!");									
									if(BookValidation(b,s.nextLine(),"price")) {
										System.out.println("책 설명을 입력하세요!");
										if(BookValidation(b,s.nextLine(),"desc")) {											
											lm.addBook(b);
										}
									}
								}
							}
						}																															
						break;
					case 2:
						if (mbn<10) {
							m.setIsbn("M00"+mbn);							
						}else if(mbn<99) {
							m.setIsbn("M0"+mbn);
						}else {
							m.setIsbn("M"+mbn);
						}
						mbn++;
						System.out.println("잡지 제목을 입력하세요!");
						if(MagazValidation(m, s.nextLine(),"title")) {									
							System.out.println("잡지 저자 이름을 입력하세요!");							
							if(MagazValidation(m, s.nextLine(),"author")) {							
								System.out.println("춢판사 이름을 입력하세요!");							
								if(MagazValidation(m, s.nextLine(),"publisher")) {
									System.out.println("가격을 입력하세요!");									
									if(MagazValidation(m, s.nextLine(),"price")) {
										System.out.println("책 설명을 입력하세요!");
										if(MagazValidation(m, s.nextLine(),"desc")) {	
											System.out.println("년도를 입력하세요!");
											if(MagazValidation(m, s.nextLine(),"year")) {	
												System.out.println("월을 입력하세요!");
												if(MagazValidation(m, s.nextLine(),"month")) {											
													lm.addBook(m);
												}
											}											
										}
									}
								}
							}
						}									
						break;
					}
					break;
		
				case 2:
					s.nextLine();
					System.out.println("삭제할 도서 번호를 입력하세요");
					String deln = s.nextLine();
					boolean delBook = lm.delBook(deln);
					if (delBook) {
						System.out.println("도서 삭제 완료!!");
						lm.showAll();
						break;
					}else {
						System.out.println("도서 번호를 제대로 입력해주세요 !");						
					}
					break;
				case 3:
					System.out.println();
					System.out.println("찾고 싶은 도서의 제목을 입력해주세요!");
					s.nextLine();
					String SearchTitle = s.nextLine();
					Book getbook = lm.getBook(SearchTitle);		
					System.out.println("***** 검색 결과: " +getbook.getTitle() +" *****" );
					System.out.println();
					break;
				case 4:			
					lm.showAllBooks();
					break;
				case 5:
					lm.showAllMagazines();
					break;
				case 6:
					System.out.println("1. 일본 도서           2. 잡지 ");
					status = s.nextInt();
					s.nextLine();
					switch (status) {
					case 1:
						System.out.println(lm.size("B") + "권입니다.");
						break;
					case 2:
						System.out.println(lm.size("M") + "권입니다.");
						break;
					}
					break;
			}
		} while (true);
	}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println();
			System.out.println("******* ERROR *******");
			System.out.println("******* 오류 발생 *******");
			System.out.println("****** 프로그램 종료 ******");			
			
		}
	}
	
	public static boolean BookValidation(Book b, String str, String type ) {				
		boolean stlg = (str == null || str.trim().length() == 0 || str.equals(""));
			if (type == "price") {
				b.setPrice(Integer.parseInt(str));
				if (str.equals("0") || str.equals("")){			
					System.out.println("가격을 다시 입력해주세요~");
					String price = s.nextLine();				
					if(BookValidation(b, price,"price")) {
						if(!(price.equals("0") || price == null  || price instanceof String)) {
							b.setPrice(Integer.parseInt(price));
							BookValidation(b,price, "price");
						}
					}
				}
			} 		
			else if (type.equals("title")) {			
				b.setTitle(str);										
				if (stlg) {					
					System.out.println("책 제목을 다시 입력 해주세요");				
					String title = s.nextLine();				
					if(BookValidation(b, title,"title")) {		
						b.setTitle(title);					
						return true;
					}
				}
			}else if(type.equals("author")) {
				b.setAuthor(str);
				if (stlg) {			
					System.out.println("책 저자 이름을 다시 입력해주세요");
					String author = s.nextLine();
					if(BookValidation(b, author,"author")) {
						b.setAuthor(author);
						return true;
					}
				}
			}else if(type.equals("publisher")) {
				b.setPublisher(str);
				if (stlg) {			
					System.out.println("출판사 이름을 다시 입력해주세요");
					String publisher = s.nextLine();
					if(BookValidation(b, publisher,"publisher")) {
						b.setPublisher(publisher);
						return true;
					}
				}
			}else if(type.equals("desc")) {
				b.setDesc(str);
				if (stlg) {			
					System.out.println("책 설명을 다시 입력해주세요");
					String desc = s.nextLine();
					if(BookValidation(b, desc,"desc")) {
						b.setDesc(desc);
						return true;
					}
				}
			}
	return true; 
	}
	
	public static boolean MagazValidation(Magazine m, String str, String type ) {		
		boolean stlg = (str == null || str.trim().length() == 0 || str.equals(""));
			if (type == "price") {
				m.setPrice(Integer.parseInt(str));
				if (str.equals("0") || str.equals("")){			
					System.out.println("가격을 다시 입력해주세요~");
					String price = s.nextLine();				
					if(MagazValidation(m, price,"price")) {
						if(!(price.equals("0") || price == null  || price instanceof String)) {
							m.setPrice(Integer.parseInt(price));
							MagazValidation(m, price, "price");
						}
					}
				}
			} 		
			else if (type.equals("title")) {			
				m.setTitle(str);										
				if (stlg) {					
					System.out.println("잡지 제목을 다시 입력 해주세요");				
					String title = s.nextLine();				
					if(MagazValidation(m, title,"title")) {		
						m.setTitle(title);					
						return true;
					}
				}
			}else if(type.equals("author")) {
				m.setAuthor(str);
				if (stlg) {			
					System.out.println("잡지 저자 이름을 다시 입력해주세요");
					String author = s.nextLine();
					if(MagazValidation(m, author,"author")) {
						m.setAuthor(author);					
						return true;
					}
				}
			}else if(type.equals("publisher")) {
				m.setPublisher(str);
				if (stlg) {			
					System.out.println("출판사 이름을 다시 입력해주세요");
					String publisher = s.nextLine();
					if(MagazValidation(m, publisher,"publisher")) {
						m.setPublisher(publisher);
						return true;
					}
				}
			}else if(type.equals("desc")) {
				m.setDesc(str);
				if (stlg) {			
					System.out.println("잡지 설명을 다시 입력해주세요");
					String desc = s.nextLine();
					if(MagazValidation(m, desc,"desc")) {
						m.setDesc(desc);
						return true;
					}
				}
			}else if(type.equals("year")) {
				m.setYear(Integer.parseInt(str));
				if (stlg) {			
					System.out.println("년도을 다시 입력해주세요");
					String year = s.nextLine();
					if(MagazValidation(m, year,"year")) {
						m.setYear(Integer.parseInt(str));
						return true;
					}
				}
			}else if(type.equals("month")) {
				m.setMonth(Integer.parseInt(str));
				if (stlg) {			
					System.out.println("월을 다시 입력해주세요");
					String month = s.nextLine();
					if(MagazValidation(m, month,"month")) {
						m.setMonth(Integer.parseInt(str));
						return true;
					}
				}
			}		
	return true; 
	}
}
