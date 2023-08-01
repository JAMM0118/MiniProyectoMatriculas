package model;

public class Materia {
    private int id;
    private String nombre;
    private ProfesorDePlanta profesorDePlanta;
    private int profesorPlantaID;
    private ProfesorHoras profesorCatedra;
    private int profesorCatedraID;
    private Jornada jornada;
    private int jornadaID;

    public Materia(int id, String nombre, ProfesorDePlanta profesorDePlanta, Jornada jornada) {
        this.id = id;
        this.nombre = nombre;
        this.profesorDePlanta = profesorDePlanta;
        this.profesorCatedra = null;
        this.jornada = jornada;
    }

    public Materia(int id, String nombre, ProfesorHoras profesorCatedra, Jornada jornada) {
        this.id = id;
        this.nombre = nombre;
        this.profesorDePlanta = null;
        this.profesorCatedra = profesorCatedra;
        this.jornada = jornada;
    }

    public Materia(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // retorna un booleano dependiendo si el profesor es de hora catedra o de planta
    public boolean profesorTipo(){
        if(profesorDePlanta != null){
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ProfesorDePlanta getProfesorDePlanta() {
        return profesorDePlanta;
    }

    public void setProfesorDePlanta(ProfesorDePlanta profesorDePlanta) {
        this.profesorDePlanta = profesorDePlanta;
    }

    public ProfesorHoras getProfesorCatedra() {
        return profesorCatedra;
    }

    public void setProfesorCatedra(ProfesorHoras profesorCatedra) {
        this.profesorCatedra = profesorCatedra;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public int getProfesorPlantaID() {
        return profesorPlantaID;
    }

    public void setProfesorPlantaID(int profesorPlantaID) {
        this.profesorPlantaID = profesorPlantaID;
    }

    public int getProfesorCatedraID() {
        return profesorCatedraID;
    }

    public void setProfesorCatedraID(int profesorCatedraID) {
        this.profesorCatedraID = profesorCatedraID;
    }

    public int getJornadaID() {
        return jornadaID;
    }

    public void setJornadaID(int jornadaID) {
        this.jornadaID = jornadaID;
    }

    
    
}
