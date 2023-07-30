package model;

import java.util.ArrayList;

public class Modelo {
    private ArrayList<TipoMateria> materias;
    private ArrayList<Jornada> jornadas;
    private ArrayList<Profesor> profesores;
    private ArrayList<Alumno> alumnos;

    public Modelo() {
        this.materias = new ArrayList<>();
        this.jornadas = new ArrayList<>();
        this.profesores = new ArrayList<>();
        this.alumnos = new ArrayList<>();
    }

    public void cargarDatos() {
        
    }

    public ArrayList<TipoMateria> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<TipoMateria> materias) {
        this.materias = materias;
    }

    public ArrayList<Jornada> getJornadas() {
        return jornadas;
    }

    public void setJornadas(ArrayList<Jornada> jornadas) {
        this.jornadas = jornadas;
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    
}
