package riwi_academy.entities;

import java.util.Objects;

public class Enrollments {
    private int idenrollments;
    private String studentenrolled;
    private String courseenrolled;

    public Enrollments() {
    }

    public Enrollments(int idenrollments) {
        this.idenrollments = idenrollments;
    }

    public Enrollments(String studentenrolled, String courseenrolled) {
        this.studentenrolled = studentenrolled;
        this.courseenrolled = courseenrolled;
    }

    public int getIdenrollments() {
        return idenrollments;
    }

    public void setIdenrollments(int idenrollments) {
        this.idenrollments = idenrollments;
    }

    public String getStudentenrolled() {
        return studentenrolled;
    }

    public void setStudentenrolled(String studentenrolled) {
        this.studentenrolled = studentenrolled;
    }

    public String getCourseenrolled() {
        return courseenrolled;
    }

    public void setCourseenrolled(String courseenrolled) {
        this.courseenrolled = courseenrolled;
    }

    @Override
    public String toString() {
        return "Enrollments{" +
                "idenrollments=" + idenrollments +
                ", studentenrolled='" + studentenrolled + '\'' +
                ", courseenrolled='" + courseenrolled + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollments that = (Enrollments) o;
        return idenrollments == that.idenrollments && Objects.equals(studentenrolled, that.studentenrolled) && Objects.equals(courseenrolled, that.courseenrolled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idenrollments, studentenrolled, courseenrolled);
    }
}
