package model.dao.implementaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ProfesorDePlanta;
import model.ProfesorHoras;
import model.dao.ProfesorCatedraDAO;

public class ProfesorCatedraDAOImpl implements ProfesorCatedraDAO {

    private final String GETALL = "SELECT * from profesorhoracatedra;";
    private final String GETONE = "SELECT * FROM profesorhoracatedra WHERE idprofesorhoracatedra = ?;;";
    private Connection conn;

    public ProfesorCatedraDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(ProfesorHoras t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public void modificar(ProfesorHoras t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public void eliminar(ProfesorHoras t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public List<ProfesorHoras> obtenerTodos() {
       PreparedStatement stat = null;
       ResultSet rs = null;
       List<ProfesorHoras> profesores = new ArrayList<>();
       try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                profesores.add(convertir(rs));
            }
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }

       return profesores;
    }

    private ProfesorHoras convertir(ResultSet rs) {
        try {
            int id = rs.getInt(1);
            String nombre = rs.getString(2);
            String cedula = rs.getString(3);
            int horas = rs.getInt(4);
            String titulo = rs.getString(5);
            ProfesorHoras profesorHoraCatedra = new ProfesorHoras(id, nombre, cedula, titulo, horas);
            return profesorHoraCatedra;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ProfesorHoras getById(int id) {
       PreparedStatement stat = null;
        ResultSet rs = null;
        ProfesorHoras p = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                p = convertir(rs);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return p;
    }





}
