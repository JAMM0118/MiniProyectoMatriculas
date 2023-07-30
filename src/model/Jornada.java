package model;


public class Jornada{
    private int id; 
    private TipoJornada tipoJornada;

    public Jornada(int id, TipoJornada tipoJornada) {
        this.id = id;
        this.tipoJornada = tipoJornada;
    }
    public TipoJornada getTipoJornada() {
        return tipoJornada;
    }
    public void setTipoJornada(TipoJornada tipoJornada) {
        this.tipoJornada = tipoJornada;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}