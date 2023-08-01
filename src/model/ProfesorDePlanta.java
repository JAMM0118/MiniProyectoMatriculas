package model;

public class ProfesorDePlanta extends Profesor {
    private int id;
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ProfesorDePlanta(int id, String nombre, String cedula, Categoria categoria) {
        super(nombre, cedula);
        this.categoria = categoria;
        this.id = id;
    }

    public ProfesorDePlanta(String nombre, String cedula, Categoria categoria) {
        super(nombre, cedula);
        this.categoria = categoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    
}
