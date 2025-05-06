package workshop.library.entity;

import org.springframework.stereotype.Component;

@Component
public class Book {
	
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isBorrowed;
	
	public Book(String title, String author, String isbn, int publishYear) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
		this.isBorrowed = false;
	}
	
	public String getTitle() {return title;}
	public String getAuthor() {return author;}
	public String getIsbn() {return isbn;}
	public int getPublishYear() {return publishYear;}
	public boolean isBorrowed() {return isBorrowed;}

	public void borrowBook() {
		isBorrowed = true;
	}
	
	public void returnBook() {
		isBorrowed = false;
	}
	
	@Override
	public String toString() {
		return "[" + title + "] 저자: " + author + ", ISBN: " + isbn +
				", 출판년도: " + publishYear + ", 대출중: " + (isBorrowed ? "예" : "아니오");
	}
	
}
