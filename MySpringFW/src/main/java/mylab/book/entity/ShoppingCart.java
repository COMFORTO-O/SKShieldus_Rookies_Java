package mylab.book.entity;

import java.util.*;
import java.text.DecimalFormat;

public class ShoppingCart {
    private List<Publication> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + " 이(가) 장바구니에 추가되었습니다.");
    }

    public boolean removeItem(String title) {
        Iterator<Publication> iterator = items.iterator();
        while (iterator.hasNext()) {
            Publication pub = iterator.next();
            if (pub.getTitle().equals(title)) {
                iterator.remove();
                System.out.println(title + " 이(가) 장바구니에서 제거되었습니다.");
                return true;
            }
        }
        System.out.println(title + " 을(를) 찾을 수 없습니다.");
        return false;
    }

    public void displayCart() {
        DecimalFormat df = new DecimalFormat("#,###원");
        System.out.println("\n==== 장바구니 목록 ====");
        for (Publication pub : items) {
            System.out.println(pub.toString());
        }
        System.out.println("\n총 가격: " + df.format(calculateTotalPrice()));
        System.out.println("할인 적용 가격: " + df.format(calculateDiscountedPrice()));
    }

    public int calculateTotalPrice() {
        int sum = 0;
        for (Publication pub : items) {
            sum += pub.getPrice();
        }
        return sum;
    }

    public int calculateDiscountedPrice() {
        int sum = 0;
        for (Publication pub : items) {
            int price = pub.getPrice();
            if (pub instanceof Magazine) {
                sum += price * 0.9;
            } else if (pub instanceof Novel) {
                sum += price * 0.85;
            } else if (pub instanceof ReferenceBook) {
                sum += price * 0.8;
            } else {
                sum += price;
            }
        }
        return sum;
    }

    public void printStatistics() {
        Map<String, Integer> countMap = new HashMap<>();
        for (Publication pub : items) {
            String type = getPublicationType(pub);
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        System.out.println("\n===== 장바구니 통계 =====");
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            System.out.printf("- %s: %d개\n", entry.getKey(), entry.getValue());
        }
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "소설";
        else if (pub instanceof Magazine) return "잡지";
        else if (pub instanceof ReferenceBook) return "참고서";
        else return "기타";
    }
}
