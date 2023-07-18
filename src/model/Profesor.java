package model;

import java.util.ArrayList;

public abstract class Profesor {
    private String nombre;
    private String cedula;
    private ArrayList<Materia> materias;

    public Profesor() {
        this.materias = new ArrayList<>();
    }

    public Profesor(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.materias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }

    public void addMateria(Materia materia){
        this.materias.add(materia);
    }

}
