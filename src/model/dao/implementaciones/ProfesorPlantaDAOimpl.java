package model.dao.implementaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;
import model.ProfesorDePlanta;
import model.dao.ProfesorPlantaDao;

public class ProfesorPlantaDAOimpl implements ProfesorPlantaDao {

    private final String GETALL = "SELECT * from profesoresnombrados;";
    private final String GETONE = "SELECT * FROM profesoresnombrados WHERE idprofesornombrado = ?;";
    private Connection conn;

    public ProfesorPlantaDAOimpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(ProfesorDePlanta t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public void modificar(ProfesorDePlanta t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public void eliminar(ProfesorDePlanta t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public List<ProfesorDePlanta> obtenerTodos() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<ProfesorDePlanta> profesoresPlanta = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                profesoresPlanta.add(convertir(rs));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return profesoresPlanta;
    }

    private ProfesorDePlanta convertir(ResultSet rs) {
        try {
            int id = rs.getInt(1);
            String nombre = rs.getString(2);
            String cedula = rs.getString(3);
            Categoria categoria = Categoria.valueOf(rs.getString(4));
            ProfesorDePlanta profesorDePlanta = new ProfesorDePlanta(id, nombre, cedula, categoria);
            return profesorDePlanta;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ProfesorDePlanta getById(int id) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        ProfesorDePlanta p = null;
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

    public static void main(String[] args) {
        String url = "jdbc:sqlite:database/dbMatricula.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            ProfesorPlantaDao dao = new ProfesorPlantaDAOimpl(conn);
            ProfesorDePlanta profesor = dao.getById(1);
            System.out.println(profesor.getNombre());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
