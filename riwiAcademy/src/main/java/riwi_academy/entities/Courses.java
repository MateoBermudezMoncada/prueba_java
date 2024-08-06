package riwi_academy.entities;

import java.util.Objects;

public class Courses {
    private int idcourse;
    private String namecourse;

    public Courses() {
    }
    // CONSTRUCTOR ID

    public Courses(int idcourse) {
        this.idcourse = idcourse;
    }

    // CONSTRUCTOR

    public Courses(String namecourse) {
        this.namecourse = namecourse;
    }

    public static void add(Courses course) {
    }

    public int getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(int idcourse) {
        this.idcourse = idcourse;
    }

    public String getNamecourse() {
        return namecourse;
    }

    public void setNamecourse(String namecourse) {
        this.namecourse = namecourse;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "idcourse=" + idcourse +
                ", namecourse='" + namecourse + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Courses courses = (Courses) o;
        return idcourse == courses.idcourse && Objects.equals(namecourse, courses.namecourse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcourse, namecourse);
    }
}
