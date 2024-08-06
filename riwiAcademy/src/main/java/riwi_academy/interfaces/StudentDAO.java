package riwi_academy.interfaces;

import riwi_academy.entities.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static java.lang.reflect.Array.setInt;
import static riwi_academy.connection.Connectiondb.getConnection;

public class StudentDAO implements IstudentDAO{

    @Override
    public List<Students> listarStudents() {
        List<Students> students = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        var sql = "SELECT * FROM students ORDER BY idstudent";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                var student = new Students();
                student.setIdstudents(rs.getInt("idstudent"));
                student.setName(rs.getString("name"));
                student.setLastname(rs.getString("lastname"));
                student.setEmailstudents(rs.getString("emailstudent"));
                student.setStatus(rs.getInt("status"));
                student.setCourseenrolled(rs.getString("courseenrolled"));
                Students.add(student);
            }
        } catch (Exception e){
            System.out.println("Error al listar Students: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("error al cerrar conexión: " + e.getMessage());
            }
        }
        return students;
    }

    @Override
    public boolean buscarStudentporId(Students students) {
        PreparedStatement ps;
        ResultSet rs;
        var con = getConnection();
        var sql = "SELECT * FROM students WHERE idstudent = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, students.getIdstudents());
            rs = ps.executeQuery();
            if (rs.next()){
                students.setCourseenrolled(rs.getString("courseenrolled"));
                students.setName(rs.getString("name"));
                students.setEmailstudents(rs.getString("emailstudent"));
                students.setStatus(rs.getInt("status"));
                students.setLastname(rs.getString("lastname"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("error al recuperar cliente por id: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean agregarStudent(Students students) {
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "INSERT INTO students (emailstudent, status, name, lastname, courseenrolled)" + "VALUES(?, ?, ? ,?, ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, students.getCourseenrolled());
            ps.setString(2, students.getEmailstudents());
            ps.setInt(3, students.getStatus());
            ps.setString(4, students.getName());
            ps.setString(5, students.getLastname());
            ps.execute();
            return true;
        } catch (Exception e){
            System.out.println("error al agregar student: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println("error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificarStudent(Students students) {
        PreparedStatement ps;
        Connection con = getConnection();
        var sql = "UPDATE students SET name = ?, lastname = ?, emailstudent = ?, status = ?, courseenrolled = ?" + "WHERE idstudent = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, students.getName());
            ps.setString(2, students.getLastname());
            ps.setString(3, students.getEmailstudents());
            ps.setString(4, students.getCourseenrolled());
            ps.setInt(4, students.getStatus());
            ps.setInt(4, students.getIdstudents());
            ps.execute();
            return true;
        } catch (Exception e){
            System.out.println("Error al modificar cliente: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminarStudent(Students students) {
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "DELETE FROM students WHERE idstudent = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, students.getIdstudents());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

}
