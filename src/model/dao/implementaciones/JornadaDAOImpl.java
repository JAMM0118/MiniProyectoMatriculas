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
import model.TipoJornada;
import model.dao.JornadaDAO;
import model.dao.MateriaDAO;

public class JornadaDAOImpl implements JornadaDAO {

    private final String GETALL = "SELECT * FROM jornada;";
    private final String GETONE = "SELECT * FROM jornada where idjornada = ?;";
    private Connection conn;

    public JornadaDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Jornada t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public void modificar(Jornada t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public void eliminar(Jornada t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public List<Jornada> obtenerTodos() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Jornada> jornadas = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                jornadas.add(convertir(rs));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return jornadas;
    }

    private Jornada convertir(ResultSet rs) {
        try {
            int id = rs.getInt(1);
            TipoJornada tipoJornada = TipoJornada.getTipoJornada(rs.getString(2));
            Jornada jornada = new Jornada(id, tipoJornada);
            return jornada;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Jornada getById(int id) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Jornada jornada = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                jornada = convertir(rs);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return jornada;
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlite:database/dbMatricula.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            JornadaDAO dao = new JornadaDAOImpl(conn);
            Jornada jornada = dao.getById(2);
            System.out.println(jornada.getTipoJornada());;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
