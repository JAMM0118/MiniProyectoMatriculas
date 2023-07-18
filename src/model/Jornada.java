package model;

import java.util.ArrayList;

public class Jornada{
    private TipoJornada tipoJornada;
    private ArrayList<Materia> materias;
    
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
    
}