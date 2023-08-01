package model.dao.implementaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Jornada;
import model.Materia;
import model.ProfesorDePlanta;
import model.ProfesorHoras;
import model.dao.MateriaDAO;

public class MateriaDAOimpl implements MateriaDAO {

    private final String GETALL = "SELECT * FROM materia;";
    private final String GETONE = "SELECT * FROM materia WHERE idmateria = ?;";
    private Connection conn;
    
    public MateriaDAOimpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Materia t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public void modificar(Materia t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public void eliminar(Materia t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public List<Materia> obtenerTodos() {
       PreparedStatement stat = null;
       ResultSet rs = null;
       List<Materia> materias = new ArrayList<>();
       try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                materias.add(convertir(rs));
            }
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }

       return materias;
    }

    private Materia convertir(ResultSet rs) {
        try {
            int id = rs.getInt(1);
            String nombre = rs.getString(2);
            int profesorPlanID = rs.getInt(3);
            int profesorCatID = rs.getInt(4);
            int jornadaID = rs.getInt(5);

            //Obtengo la jornada haciendo uso de un objeto de tipo JornadaDAO
            Jornada jornada = new JornadaDAOImpl(conn).getById(jornadaID); 

            //compruebo si el profesor es de planta o hora catedra
            if(profesorPlanID != 0){
                ProfesorDePlanta profesorDePlanta = new ProfesorPlantaDAOimpl(conn).getById(profesorPlanID);
                Materia materiaProfPlan = new Materia(id, nombre, profesorDePlanta, jornada);
                return materiaProfPlan;
            }else{
                ProfesorHoras profesorHoras = new ProfesorCatedraDAOImpl(conn).getById(profesorCatID);
                Materia materiaProfCat = new Materia(id, nombre, profesorHoras, jornada);
                return materiaProfCat;
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Materia getById(int id) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Materia materia = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                materia = convertir(rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return materia;
    }

    // public static void main(String[] args) {
    //     String url = "jdbc:sqlite:database/dbMatricula.db";
    //     Connection conn = null;
    //     try {
    //         conn = DriverManager.getConnection(url);
    //         MateriaDAO dao = new MateriaDAOimpl(conn);
    //         Materia materia = dao.getById(2);
    //         System.out.println(materia.getNombre());
    //         if(materia.profesorTipo()){
    //             System.out.println("Es de planta");
    //             System.out.println(materia.getProfesorDePlanta().getNombre());
    //         }else{
    //             System.out.println("Es de hora catedra");
    //             System.out.println(materia.getProfesorCatedra().getNombre());
    //         }
    //         System.out.println("Hola");
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //     }
    // }

}
