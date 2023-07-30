package model;

public class Matricula {
    private int id;
    private Alumno alumno;
    private TipoMateria materia;

    public Matricula(int id, Alumno alumno, TipoMateria materia) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public TipoMateria getMateria() {
        return materia;
    }

    public void setMateria(TipoMateria materia) {
        this.materia = materia;
    }

    

    
}
