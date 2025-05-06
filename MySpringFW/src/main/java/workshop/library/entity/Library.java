package workshop.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    // 도서 추가
    public void addBook(Book book) {
        books.add(book);
        System.out.println("도서 추가됨: " + book.getTitle());
    }

    // 도서 검색: 제목, 저자, ISBN
    public List<Book> search(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(keyword) ||
                book.getAuthor().contains(keyword) ||
                book.getIsbn().contains(keyword)) {
                result.add(book);
            }
        }
        return result;
    }

    // 도서 대출
    public boolean borrowBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && !book.isBorrowed()) {
                book.borrowBook();
                System.out.println("대출 완료: " + book.getTitle());
                return true;
            }
        }
        System.out.println("대출 실패: 책이 없거나 이미 대출 중");
        return false;
    }

    // 도서 반납
    public boolean returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.isBorrowed()) {
                book.returnBook();
                System.out.println("반납 완료: " + book.getTitle());
                return true;
            }
        }
        System.out.println("반납 실패: 해당 ISBN으로 대출 중인 책 없음");
        return false;
    }

    // 대출 가능한 도서 목록 출력
    public void printAvailableBooks() {
        System.out.println("현재 대출 가능한 도서 목록:");
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println(book);
            }
        }
    }
}
