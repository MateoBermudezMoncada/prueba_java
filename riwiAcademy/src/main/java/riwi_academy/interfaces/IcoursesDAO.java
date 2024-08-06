package riwi_academy.interfaces;

import riwi_academy.entities.Courses;
import riwi_academy.entities.Students;

import java.util.List;

public interface IcoursesDAO {
    List<Courses> listarCourses();
    boolean buscarCourseporId(Courses courses);
    boolean agregarCourse (Courses courses);
    boolean modificarCourse (Courses courses);
    boolean eliminarCourse (Courses courses);
}
