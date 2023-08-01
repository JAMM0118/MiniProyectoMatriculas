import java.util.ArrayList;

import model.Alumno;
import model.Categoria;
import model.Jornada;
import model.Materia;
import model.Modelo;
import model.ProfesorDePlanta;
import model.dao.implementaciones.JornadaDAOImpl;

public class App {
    public static void main(String[] args) throws Exception {
        
        // VentanaPrincipal principal = new VentanaPrincipal();
        // principal.setVisible(true);

        Modelo modelo = new Modelo();
        // ArrayList<Materia> materias = modelo.obtenerMaterias();
        // for (Materia materia : materias) {
        //     System.out.println(materia.getNombre());
        // }

        // Alumno alumno = modelo.obtenerAlumno(1);
        // for (Materia materia : alumno.getMateriasMatriculadas()) {
        //     System.out.println(materia.getNombre());
        // }

        // Jornada jornada = modelo.obtenerJornadaPorID(1);
        // Alumno alumno = new Alumno("Jose Manuel", "11212313132", 17, jornada);
        // modelo.insertarAlumno(alumno);

        ArrayList<Alumno> alumnos = modelo.obtenerListaAlumnos();
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.getNombre());
            for (Materia materia : alumno.getMateriasMatriculadas()) {
                System.out.println(materia.getNombre());
            }
        }
    }
}
