package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.AlumnoDAO;

import model.dao.JornadaDAO;
import model.dao.MateriaDAO;
import model.dao.MatriculaDAO;
import model.dao.ProfesorCatedraDAO;
import model.dao.ProfesorPlantaDao;
import model.dao.implementaciones.AlumnoDAOImpl;
import model.dao.implementaciones.JornadaDAOImpl;
import model.dao.implementaciones.MateriaDAOimpl;
import model.dao.implementaciones.MatriculaDAOImpl;
import model.dao.implementaciones.ProfesorCatedraDAOImpl;
import model.dao.implementaciones.ProfesorPlantaDAOimpl;

public class Modelo {
    private final String URL = "jdbc:sqlite:database/dbMatricula.db";
    private Connection conn;
    private AlumnoDAO alumnoDAO;
    private JornadaDAO jornadaDAO;
    private MateriaDAO materiaDAO;
    private MatriculaDAO matriculaDAO;
    private ProfesorCatedraDAO profesorCatedraDAO;
    private ProfesorPlantaDao profesorPlantaDAO;

    public Modelo() {
        configurarConexion(URL);
        this.alumnoDAO = new AlumnoDAOImpl(conn);
        this.jornadaDAO = new JornadaDAOImpl(conn);
        this.materiaDAO = new MateriaDAOimpl(conn);
        this.matriculaDAO = new MatriculaDAOImpl(conn);
        this.profesorCatedraDAO = new ProfesorCatedraDAOImpl(conn);
        this.profesorPlantaDAO = new ProfesorPlantaDAOimpl(conn);
    }

    public void configurarConexion(String url) {
        try {
            Connection conn = DriverManager.getConnection(url);
            this.conn = conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Materia> obtenerMaterias() {
        return (ArrayList<Materia>) materiaDAO.obtenerTodos();
    }

    public void matricularMateria(Alumno alumno, Materia materia) {
        matriculaDAO.insertar(new Matricula(alumno, materia));
    }

    // Obtengo el alumno y asigno las materias matriculadas
    public Alumno obtenerAlumno(int id) {
        Alumno alumno = alumnoDAO.getById(id);
        ArrayList<Matricula> matriculas = (ArrayList<Matricula>) matriculaDAO.obtenerTodos();

        for (Matricula matricula : matriculas) {
            if (matricula.getAlumno().getId() == alumno.getId()) {
                alumno.addMateriaMatricula(matricula.getMateria());
            }
        }
        return alumno;
    }

    public ArrayList<Alumno> obtenerListaAlumnos() {
        int cantidadAlumnos = alumnoDAO.obtenerTodos().size();
        ArrayList<Alumno> listaAlumno = new ArrayList<Alumno>();
        for (int i = 1; i < cantidadAlumnos + 1; i++) {
            listaAlumno.add(obtenerAlumno(i));
        }
        return listaAlumno;
    }

    public void insertarAlumno(Alumno alumno) {
        alumnoDAO.insertar(alumno);
    }

    public Jornada obtenerJornadaPorID(int id) {
        return jornadaDAO.getById(id);
    }

    public ArrayList<Jornada> obtenerListaJornadas() {
        return (ArrayList<Jornada>) jornadaDAO.obtenerTodos();
    }

    public ArrayList<ProfesorDePlanta> obtenerListaProfesoresPlanta(){
        return (ArrayList<ProfesorDePlanta>) profesorPlantaDAO.obtenerTodos();
    }

    public ArrayList<ProfesorHoras> obtenerListaProfesoresHora(){
        return (ArrayList<ProfesorHoras>) profesorCatedraDAO.obtenerTodos();
    }

}
