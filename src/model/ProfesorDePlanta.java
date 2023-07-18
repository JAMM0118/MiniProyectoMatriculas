package model;

public class ProfesorDePlanta extends Profesor {
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ProfesorDePlanta(String nombre, String cedula, Categoria categoria) {
        super(nombre, cedula);
        this.categoria = categoria;
    }

    
    
}
