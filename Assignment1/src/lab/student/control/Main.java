package lab.student.control;

import lab.student.entity.Student;

public class Main {
    public static void main(String[] args) {
        Student s = new Student();

        s.setStudentId("2025001");
        s.setName("홍길동");
        s.setMajor("정보보안학");
        s.setGrade(3);  // 정상 범위

        System.out.println(s); // → 홍길동 / 정보보안학 / 3학년

        System.out.println("2학년으로 변경");
        s.setGrade(5); // → 오류 메시지 출력
    }
}
