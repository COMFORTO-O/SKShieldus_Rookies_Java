package lab.student.entity;

public class Student {
    private String studentId;
    private String name;
    private String major;
    private int grade;

    // Getter and Setter
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if (grade >= 1 && grade <= 4) {
            this.grade = grade;
        } else {
            System.out.println("학년은 1~4 사이여야 합니다.");
        }
    }

    // toString 메서드 추가
    @Override
    public String toString() {
        return name + " / " + major + " / " + grade + "학년";
    }
}
