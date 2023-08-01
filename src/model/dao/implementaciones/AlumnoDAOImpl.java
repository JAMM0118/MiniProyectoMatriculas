package model.dao.implementaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Alumno;
import model.Jornada;
import model.Materia;
import model.dao.AlumnoDAO;

public class AlumnoDAOImpl implements AlumnoDAO {

    private final String INSERT = "INSERT into alumno (nombrealumno, cedulaalumno, edad, jornada_id) VALUES (?,?,?,?);";
    private final String GETALL = "SELECT * FROM alumno;";
    private final String GETONE = "SELECT * FROM alumno WHERE idalumno = ?;";
    private Connection conn = null;
    
    public AlumnoDAOImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insertar(Alumno t) {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, t.getNombre());
            stat.setString(2, t.getCedula());
            stat.setInt(3, t.getEdad());
            stat.setInt(4, t.getJornadaAsignada().getId());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modificar(Alumno t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public void eliminar(Alumno t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public List<Alumno> obtenerTodos() {
       PreparedStatement stat = null;
       ResultSet rs = null;
       List<Alumno> alumnos = new ArrayList<>();
       try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                alumnos.add(convertir(rs));
            }
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }

       return alumnos;
    }

    private Alumno convertir(ResultSet rs) {
        try {
            int id = rs.getInt(1);
            String nombre = rs.getString(2);
            String cedula = rs.getString(3);
            int edad = rs.getInt(4);
            int jornadaID = rs.getInt(5);
            Jornada jornada = new JornadaDAOImpl(conn).getById(rs.getInt(5));
            Alumno alumno = new Alumno(id, nombre, cedula, edad, jornada);
            return alumno;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public Alumno getById(int id) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Alumno alumno = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                alumno = convertir(rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return alumno;
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlite:database/dbMatricula.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            AlumnoDAO dao = new AlumnoDAOImpl(conn);

            // // creo la jornada
            // Jornada jornada = new JornadaDAOImpl(conn).getById(1);
            // // creo el alumno 
            // Alumno alumno = new Alumno("Juan Martinez", "12345678", 20, jornada);
            // dao.insertar(alumno);


            Alumno alumno = dao.getById(1);
            System.out.println(alumno.getNombre());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
