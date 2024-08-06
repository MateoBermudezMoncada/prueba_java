package menu;

import riwi_academy.entities.Students;
import riwi_academy.interfaces.IstudentDAO;
import riwi_academy.interfaces.StudentDAO;

import java.util.Scanner;

public class RiwiAcademicAPP {
    public static void main(String[] args) {
        riwiAcademicAPP();
    }
    private static void riwiAcademicAPP(){
        var salir = false;
        var consola = new Scanner(System.in);
        // Creamos un objeto de la clase Studentdap
        IClienteDAO studentDAO = new StudentDAO();
        while(!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(consola, opcion, studentDAO);
            }catch (Exception e){
                System.out.println("Error al ejecutar opciones: " + e.getMessage());
            }
            System.out.println();
        }

    }
    private static int mostrarMenu(Scanner consola){
        System.out.print("""
                *** Zona Fit (GYM)
                1. Listar Students
                2. Buscar Students
                3. Agregar Students
                4. Modificar Students
                5. Eliminar Students
                6. Salir
                Elije una opcion:\s""");
        return Integer.parseInt(consola.nextLine());
    }
    private static boolean ejecutarOpciones(Scanner consola, int opcion,
                                            IstudentDAO studentDAO){
        var salir = false;
        switch (opcion){
            case 1 -> { // 1. Listar students
                System.out.println("--- Listado de Clientes ---");
                var students = studentDAO.listarStudents();
                students.forEach(System.out::println);
            }
            case 2 ->{ // 2. Buscar students por id
                System.out.print("Introduce el id del student a buscar: ");
                var idStudent = Integer.parseInt(consola.nextLine());
                var student = new Students(idStudent);
                var encontrado = studentDAO.buscarStudentporId(student);
                if(encontrado)
                    System.out.println("Student encontrado: " + student);
                else
                    System.out.println("Student NO encontrado: " + student);

            }
            case 3 -> { // 3. Agregar student
                System.out.println("--- Agregar student ---");
                System.out.print("Name: ");
                var name = consola.nextLine();
                System.out.print("Lastname: ");
                var lastname = consola.nextLine();
                System.out.print("course: ");
                var course = Integer.parseInt(consola.nextLine());
                // Creamos el objeto student (sin el id)
                var student = new Students(name, lastname, course);
                var agregado = studentDAO.agregarStudent(student);
                if(agregado)
                    System.out.println("student agregado: " + student);
                else
                    System.out.println("student NO agregado: " + student;
            }
            case 4 -> { //4. Modificar student
                System.out.println("--- Modificar student ---");
                System.out.print("Id student: ");
                var idStudent = Integer.parseInt(consola.nextLine());
                System.out.print("Name: ");
                var name = consola.nextLine();
                System.out.print("Lastname: ");
                var lastname = consola.nextLine();
                System.out.print("course: ");
                var course= Integer.parseInt(consola.nextLine());
                // Creamos el objeto a modificar
                var student = new Students(idStudent, name, lastname, course;
                var modificado = studentDAO.modificarStudent(student);
                if(modificado)
                    System.out.println("student modificado: " + student);
                else
                    System.out.println("student NO modificado: " + student);
            }
            case 5 -> { // 5. Eliminar Student
                System.out.println("--- Eliminar Student ---");
                System.out.print("Id Student: ");
                var idStudent= Integer.parseInt(consola.nextLine());
                var student = new Students(idStudent;
                var eliminado = studentDAO.eliminarStudent(student);
                if(eliminado)
                    System.out.println("student Eliminado: " + student);
                else
                    System.out.println("student NO eliminado: " + student);
            }
            case 6 -> { // 6. Salir
                System.out.println("Hasta pronto!");
                salir = true;
            }
            default -> System.out.println("Opcion no reconocida: " + opcion);
        }
        return salir;
    }
}

