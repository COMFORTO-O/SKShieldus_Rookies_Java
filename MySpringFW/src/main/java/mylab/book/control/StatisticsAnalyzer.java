package mylab.book.control;

import mylab.book.entity.*;
import java.util.*;
import java.text.DecimalFormat;

public class StatisticsAnalyzer {

    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Integer> sumMap = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
            sumMap.put(type, sumMap.getOrDefault(type, 0) + pub.getPrice());
        }

        Map<String, Double> avgMap = new HashMap<>();
        for (String type : countMap.keySet()) {
            avgMap.put(type, sumMap.get(type) / (double) countMap.get(type));
        }
        return avgMap;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> countMap = new HashMap<>();
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> percentMap = new HashMap<>();
        int total = publications.length;
        for (String type : countMap.keySet()) {
            percentMap.put(type, countMap.get(type) * 100.0 / total);
        }
        return percentMap;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int total = publications.length;
        int count = 0;

        for (Publication pub : publications) {
            if (pub.getPublishDate().startsWith(year)) count++;
        }

        return count * 100.0 / total;
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "소설";
        else if (pub instanceof Magazine) return "잡지";
        else if (pub instanceof ReferenceBook) return "참고서";
        else return "기타";
    }

    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");

        System.out.println("\n===== 출판물 통계 분석 =====");
        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avgMap = calculateAveragePriceByType(publications);
        avgMap.forEach((k, v) -> System.out.printf("   - %s: %s원\n", k, df.format(v)));

        System.out.println("\n2. 출판물 유형 분포:");
        Map<String, Double> distMap = calculatePublicationDistribution(publications);
        distMap.forEach((k, v) -> System.out.printf("   - %s: %.2f%%\n", k, v));

        System.out.println("\n3. 2007년에 출판된 출판물 비율: " +
                String.format("%.2f%%", calculatePublicationRatioByYear(publications, "2007")));
    }
}
