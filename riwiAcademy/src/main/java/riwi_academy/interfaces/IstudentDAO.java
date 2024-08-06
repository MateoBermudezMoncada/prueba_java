package riwi_academy.interfaces;

import riwi_academy.entities.Students;

import java.util.List;

public interface IstudentDAO {
    List<Students> listarStudents();
    boolean buscarStudentporId(Students students);
    boolean agregarStudent (Students students);
    boolean modificarStudent (Students students);
    boolean eliminarStudent (Students students);
}
