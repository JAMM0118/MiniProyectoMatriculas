package model;

import java.util.ArrayList;

public class Alumno{
    private String nombre;
    private String cedula;
    private int edad;
    private ArrayList<Materia> materiasMatriculadas;
    private Jornada jornadaAsignada;


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
    public ArrayList<Materia> getMateriasMatriculadas() {
        return materiasMatriculadas;
    }
    public void setMateriasMatriculadas(ArrayList<Materia> materiasMatriculadas) {
        this.materiasMatriculadas = materiasMatriculadas;
    }
    public Jornada getJornadaAsignada() {
        return jornadaAsignada;
    }
    public void setJornadaAsignada(Jornada jornadaAsignada) {
        this.jornadaAsignada = jornadaAsignada;
    }
    
    
}