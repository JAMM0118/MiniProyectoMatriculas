package model;

public class Matricula {
    private int id;
    private Alumno alumno;
    private Materia materia;

    public Matricula(int id, Alumno alumno, Materia materia) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
    }

    public Matricula(Alumno alumno, Materia materia){
        this.materia = materia;
        this.alumno = alumno;
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

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    

    
}
