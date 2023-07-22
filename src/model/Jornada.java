package model;

import java.util.ArrayList;

public class Jornada{
    private int id;
    private TipoJornada tipoJornada;
    private ArrayList<Materia> materias;

    public Jornada(int id, TipoJornada tipoJornada, ArrayList<Materia> materias) {
        this.id = id;
        this.tipoJornada = tipoJornada;
        this.materias = materias;
    }
    public TipoJornada getTipoJornada() {
        return tipoJornada;
    }
    public void setTipoJornada(TipoJornada tipoJornada) {
        this.tipoJornada = tipoJornada;
    }
    public ArrayList<Materia> getMaterias() {
        return materias;
    }
    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}