package riwi_academy.entities;

import java.util.Objects;

public class Students {
    private int idstudents;
    private String emailstudents;
    private int status;
    private String name;
    private String lastname;
    private String courseenrolled;

    // CONSTRUCTOR VACÍO
    public Students() {
    }

    // CONSTRUCTOR SOLO ID
    public Students(int idstudents) {
        this.idstudents = idstudents;
    }

    // RESTO DE CONSTRUCTOR

    public Students(String emailstudents, int status, String name, String lastname, String courseenrolled) {
        this.emailstudents = emailstudents;
        this.status = status;
        this.name = name;
        this.lastname = lastname;
        this.courseenrolled = courseenrolled;
    }

    public static void add(Students student) {
    }


    public int getIdstudents() {
        return idstudents;
    }

    public void setIdstudents(int idstudents) {
        this.idstudents = idstudents;
    }

    public String getEmailstudents() {
        return emailstudents;
    }

    public void setEmailstudents(String emailstudents) {
        this.emailstudents = emailstudents;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCourseenrolled() {
        return courseenrolled;
    }

    public void setCourseenrolled(String courseenrolled) {
        this.courseenrolled = courseenrolled;
    }

    // OVERRIDE TO STRING

    @Override
    public String toString() {
        return "Students{" +
                "idstudents=" + idstudents +
                ", emailstudents='" + emailstudents + '\'' +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", courseenrolled='" + courseenrolled + '\'' +
                '}';
    }

    // HASH AND EQUALS PARA MEJORAR LA RAPIDEZ EN LA COMPARACIÓN DE OBJETOS

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return idstudents == students.idstudents && Objects.equals(emailstudents, students.emailstudents) && Objects.equals(status, students.status) && Objects.equals(name, students.name) && Objects.equals(lastname, students.lastname) && Objects.equals(courseenrolled, students.courseenrolled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idstudents, emailstudents, status, name, lastname, courseenrolled);
    }
}
