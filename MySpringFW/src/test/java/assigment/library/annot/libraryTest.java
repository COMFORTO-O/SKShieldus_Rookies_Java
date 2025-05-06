package assigment.library.annot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import workshop.library.entity.Book;
import workshop.library.entity.Library;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class libraryTest {

    private Library library;
    private Book book1, book2, book3;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("어린 왕자", "생텍쥐페리", "111-111", 1943);
        book2 = new Book("자바의 정석", "남궁성", "222-222", 2016);
        book3 = new Book("이펙티브 자바", "조슈아 블로크", "333-333", 2018);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
    }

    @Test
    public void testAddBook() {
        assertEquals(3, library.search("어린 왕자").size(), "어린 왕자 책이 추가되어야 함");
    }

    @Test
    public void testSearchBookByTitle() {
        List<Book> result = library.search("자바");
        assertEquals(1, result.size(), "자바와 관련된 책이 있어야 함");
        assertEquals("자바의 정석", result.get(0).getTitle(), "책 제목이 맞아야 함");
    }

    @Test
    public void testBorrowBook() {
        boolean result = library.borrowBook("222-222");
        assertTrue(result, "대출이 성공해야 함");

        assertTrue(book2.isBorrowed(), "자바의 정석은 대출 중이어야 함");
    }

    @Test
    public void testReturnBook() {
        library.borrowBook("222-222");
        boolean result = library.returnBook("222-222");
        assertTrue(result, "반납이 성공해야 함");

        assertFalse(book2.isBorrowed(), "자바의 정석은 반납 후 대출 상태가 아니어야 함");
    }

    @Test
    public void testPrintAvailableBooks() {
        library.borrowBook("222-222");
        library.printAvailableBooks();
    }
}
