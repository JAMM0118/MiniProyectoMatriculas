package model;

public class ProfesorHoras extends Profesor {
    private int id;
    private String titulo;
    private int horas;
    
    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ProfesorHoras(int id, String nombre, String cedula, String titulo, int horas){
        super(nombre, cedula);
        this.titulo = titulo;
        this.horas = horas;
        this.id = id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getId(){
        return id;
    }
}
