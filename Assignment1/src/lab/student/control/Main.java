package lab.student.control;

import lab.student.entity.Student;

public class Main {
    public static void main(String[] args) {
        Student s = new Student();

        s.setStudentId("2025001");
        s.setName("ȫ�浿");
        s.setMajor("����������");
        s.setGrade(3);  // ���� ����

        System.out.println(s); // �� ȫ�浿 / ���������� / 3�г�

        System.out.println("2�г����� ����");
        s.setGrade(5); // �� ���� �޽��� ���
    }
}
