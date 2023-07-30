package model;

import java.util.ArrayList;

public abstract class Profesor {
    private String nombre;
    private String cedula;
    private ArrayList<TipoMateria> materias;

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

    public ArrayList<TipoMateria> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<TipoMateria> materias) {
        this.materias = materias;
    }

    public void addMateria(TipoMateria materia){
        this.materias.add(materia);
    }

}
