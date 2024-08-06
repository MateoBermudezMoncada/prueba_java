package riwi_academy.interfaces;

import riwi_academy.entities.Courses;
import riwi_academy.entities.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static riwi_academy.connection.Connectiondb.getConnection;

public class CoursesDAO implements IcoursesDAO {

    @Override
    public List<Courses> listarCourses() {
        List<Courses> courses= new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        var sql = "SELECT * FROM courses ORDER BY idcourse";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                var course = new Courses();
                course.setIdcourse(rs.getInt("idcourse"));
                course.setNamecourse(rs.getString("namecourse"));
                Courses.add(course);
            }
        } catch (Exception e) {
            System.out.println("Error al listar courses: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("error al cerrar conexión: " + e.getMessage());
            }
        }
        return courses;
    }

    @Override
    public boolean buscarCourseporId(Courses courses) {
        PreparedStatement ps;
        ResultSet rs;
        var con = getConnection();
        var sql = "SELECT * FROM courses WHERE idcourse = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, courses.getIdcourse());
            rs = ps.executeQuery();
            if (rs.next()){
                courses.setNamecourse(rs.getString("namecourse"));
                courses.setIdcourse(rs.getInt("idcourse"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("error al recuperar course por id: " + e.getMessage());
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
    public boolean agregarCourse(Courses courses) {
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "INSERT INTO courses (namecourse, idcourse )" + "VALUES(?, ?,)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, courses.getNamecourse());
            ps.setInt(2, courses.getIdcourse());
            ps.execute();
            return true;
        } catch (Exception e){
            System.out.println("error al agregar course: " + e.getMessage());
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
    public boolean modificarCourse(Courses courses) {
        PreparedStatement ps;
        Connection con = getConnection();
        var sql = "UPDATE courses SET namecourse = ?" + "WHERE idcourse = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, courses.getNamecourse());
            ps.execute();
            return true;
        } catch (Exception e){
            System.out.println("Error al modificar course: " + e.getMessage());
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
    public boolean eliminarCourse(Courses courses) {
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "DELETE FROM courses WHERE idcourse  = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, courses.getIdcourse());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al eliminar course: " + e.getMessage());
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

