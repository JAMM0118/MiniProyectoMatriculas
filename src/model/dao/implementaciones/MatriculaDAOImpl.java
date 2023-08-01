package model.dao.implementaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Alumno;
import model.Materia;
import model.Matricula;
import model.dao.AlumnoDAO;
import model.dao.MatriculaDAO;

public class MatriculaDAOImpl implements MatriculaDAO {

    private final String INSERT = "INSERT into matricula (alumnoid, materiaid) VALUES (?,?);";
    private final String GETALL = "SELECT * FROM matricula;";
    private final String GETONE = "SELECT * from matricula WHERE idmatricula = ?;";

    private Connection conn;
    public MatriculaDAOImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insertar(Matricula t) {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1, t.getAlumno().getId());
            stat.setInt(2, t.getMateria().getId());
            stat.executeUpdate();
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }

    @Override
    public void modificar(Matricula t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public void eliminar(Matricula t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public List<Matricula> obtenerTodos() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Matricula> matriculas = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                matriculas.add(convertir(rs));
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return matriculas;
        
    }

    public Matricula convertir(ResultSet rs){
        Matricula matricula = null;
        try {
            int id = rs.getInt("idmatricula");
            int idAlumno = rs.getInt("alumnoid");
            Alumno alumno = new AlumnoDAOImpl(conn).getById(idAlumno);
            int idMateria = rs.getInt("materiaid");
            Materia materia = new MateriaDAOimpl(conn).getById(idMateria);

            matricula = new Matricula(id, alumno, materia);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return matricula;
    }

    @Override
    public Matricula getById(int id) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Matricula matricula = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if(rs.next()){
                matricula = convertir(rs);
            }   
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return matricula;
    }

     public static void main(String[] args) {
        String url = "jdbc:sqlite:database/dbMatricula.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            MatriculaDAO dao = new MatriculaDAOImpl(conn);
            // Alumno alumno = new AlumnoDAOImpl(conn).getById(1);
            // Materia materia = new MateriaDAOimpl(conn).getById(1);
            // Matricula matricula = new Matricula(alumno, materia);
            // dao.insertar(matricula);

            // Matricula matricula = dao.getById(1);
            // System.out.println(matricula.getAlumno().getNombre());
            // System.out.println(matricula.getMateria().getNombre());
            // System.out.println(matricula.getAlumno().getId());
            // System.out.println(matricula.getMateria().getId());
            // System.out.println(matricula.getId());
            // System.out.println(matricula.getMateria().getProfesorDePlanta().getNombre());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
