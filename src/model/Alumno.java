package model;

import java.util.ArrayList;

public class Alumno{
    private int id;
    private String nombre;
    private String cedula;
    private int edad;
    private ArrayList<TipoMateria> materiasMatriculadas;
    private Jornada jornadaAsignada;

    public Alumno(int id, String nombre, String cedula, int edad,Jornada jornadaAsignada){
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.materiasMatriculadas = new ArrayList<TipoMateria>();
        this.jornadaAsignada = jornadaAsignada;
    }

    public Alumno(String nombre, String cedula, int edad, Jornada jornadaAsignada){
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.materiasMatriculadas = new ArrayList<TipoMateria>();
        this.jornadaAsignada = jornadaAsignada;
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
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public ArrayList<TipoMateria> getMateriasMatriculadas() {
        return materiasMatriculadas;
    }
    public void setMateriasMatriculadas(ArrayList<TipoMateria> materiasMatriculadas) {
        this.materiasMatriculadas = materiasMatriculadas;
    }

    public void addMateriaMatricula(TipoMateria materia){
        this.materiasMatriculadas.add(materia);
    }

    public Jornada getJornadaAsignada() {
        return jornadaAsignada;
    }
    public void setJornadaAsignada(Jornada jornadaAsignada) {
        this.jornadaAsignada = jornadaAsignada;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    
}