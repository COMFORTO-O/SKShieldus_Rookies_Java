package mylab.book.control;

import mylab.book.entity.*;

public class ManageBook {

    public static void main(String[] args) {
        Publication[] books = new Publication[] {
            new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"),
            new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"),
            new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"),
            new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"),
            new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"),
            new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설"),
            new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설")
        };

        System.out.println("==== 도서 정보 출력 ====");
        for (int i = 0; i < books.length; i++) {
            System.out.printf("%d. %s\n", i + 1, books[i].toString());
        }

        // 가격 변경 테스트
        Publication target = books[6];
        System.out.println("\n==== 가격 변경 ====");
        System.out.println(target.getTitle() + " 변경 전 가격: " + target.getPrice() + "원");
        int oldPrice = target.getPrice();
        modifyPrice(target);
        System.out.println(target.getTitle() + " 변경 후 가격: " + target.getPrice() + "원");
        System.out.println("차액: " + (oldPrice - target.getPrice()) + "원");

        // 통계 분석
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
        analyzer.printStatistics(books);

        // 장바구니
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(books[0]);
        cart.addItem(books[2]);
        cart.addItem(books[4]);
        cart.addItem(books[6]);
        cart.displayCart();

        // 빠삐용 제거
        cart.removeItem("빠삐용");
        cart.displayCart();
        cart.printStatistics();
    }

    public static void modifyPrice(Publication pub) {
        int price = pub.getPrice();
        if (pub instanceof Magazine) {
            pub.setPrice((int)(price * 0.6));
        } else if (pub instanceof Novel) {
            pub.setPrice((int)(price * 0.8));
        } else if (pub instanceof ReferenceBook) {
            pub.setPrice((int)(price * 0.9));
        }
    }
}
