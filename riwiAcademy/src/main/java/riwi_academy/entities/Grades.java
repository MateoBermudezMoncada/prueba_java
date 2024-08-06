package riwi_academy.entities;

import java.util.Objects;

public class Grades {
    private int idgrades;
    private int grade;
    private int gradeStudent;
    private String gradeCourse;

    public Grades() {
    }

    public Grades(int idgrades, int grade, int gradeStudent, String gradeCourse) {
        this.idgrades = idgrades;
        this.grade = grade;
        this.gradeStudent = gradeStudent;
        this.gradeCourse = gradeCourse;
    }

    public int getIdgrades() {
        return idgrades;
    }

    public void setIdgrades(int idgrades) {
        this.idgrades = idgrades;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGradeStudent() {
        return gradeStudent;
    }

    public void setGradeStudent(int gradeStudent) {
        this.gradeStudent = gradeStudent;
    }

    public String getGradeCourse() {
        return gradeCourse;
    }

    public void setGradeCourse(String gradeCourse) {
        this.gradeCourse = gradeCourse;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "idgrades=" + idgrades +
                ", grade=" + grade +
                ", gradeStudent=" + gradeStudent +
                ", gradeCourse='" + gradeCourse + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grades grades = (Grades) o;
        return idgrades == grades.idgrades && grade == grades.grade && gradeStudent == grades.gradeStudent && Objects.equals(gradeCourse, grades.gradeCourse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idgrades, grade, gradeStudent, gradeCourse);
    }
}
