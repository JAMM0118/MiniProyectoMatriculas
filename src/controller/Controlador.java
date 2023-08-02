package controller;

import view.Intefaz.VentanaMatriculados;
import view.Intefaz.VentanaMatricular;
import view.Intefaz.VentanaPrincipal;
import view.Intefaz.VentanaProfesorHoras;
import view.Intefaz.VentanaProfesorPlanta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import model.Alumno;
import model.Jornada;
import model.Modelo;
import model.ProfesorDePlanta;
import model.ProfesorHoras;
import model.TipoJornada;

public class Controlador implements ActionListener {
    VentanaPrincipal principal;
    VentanaProfesorPlanta menuProfesorPlanta;
    VentanaMatricular menuMatricular;
    VentanaProfesorHoras menuProfesorHoras;
    Modelo modelo;
    VentanaMatriculados menuMatriculados;

    public Controlador(VentanaPrincipal principal, VentanaProfesorPlanta profesorPlanta, VentanaMatricular matricular,
            VentanaProfesorHoras profesorHoras, VentanaMatriculados matriculados, Modelo modelo) {
        this.principal = principal;
        this.menuProfesorHoras = profesorHoras;
        this.menuProfesorPlanta = profesorPlanta;
        this.menuMatricular = matricular;
        this.menuMatriculados = matriculados;
        this.modelo = modelo;
    }

    public void init() {
        principal.setVisible(true);
        principal.btnProfesorPlanta.addActionListener(this);
        principal.btnProfesorHoras.addActionListener(this);
        principal.btnMatricularMaterias.addActionListener(this);
        principal.btnMatriculados.addActionListener(this);
        menuProfesorPlanta.btnVolverPrincipal.addActionListener(this);
        menuProfesorHoras.btnVolverPrincipal.addActionListener(this);
        menuMatricular.btnVolver.addActionListener(this);
        menuMatriculados.btnVolver.addActionListener(this);
        menuMatricular.btnGuardarDatos.addActionListener(this);
    }

    public void cerrarVentanas(JFrame ventana) {
        ventana.dispose();
        principal.setVisible(true);
    }

    public void matricularMaterias(){
        String nombre, cedula;
        int edad,id;
        Jornada jornada;
        nombre = menuMatricular.textFieldName.getText() +" "+ menuMatricular.textFieldApellido.getText();
        cedula = menuMatricular.textFieldCedula.getText();
        edad = Integer.parseInt(menuMatricular.textFieldEdad.getText());
        if(menuMatricular.comboBoxJornada.getSelectedIndex() == 1){
            jornada = modelo.obtenerJornadaPorID(2);
        }
        else{
            jornada = modelo.obtenerJornadaPorID(1);
        }

        Alumno alumno = new Alumno(nombre, cedula, edad, jornada);
        modelo.insertarAlumno(alumno);

        int idInsertado = modelo.obtenerListaAlumnos().size();
        alumno = modelo.obtenerAlumno(idInsertado);

        // matricular materias a los alumnos
        if(alumno.getJornadaAsignada().getTipoJornada() == TipoJornada.MANANA){
            if(menuMatricular.jCheckBoxFisica.isSelected()){
                modelo.matricularMateria(alumno, modelo.obtenerMateriaPorID(3));
            }
            if(menuMatricular.jCheckBoxEspanol.isSelected()){
                modelo.matricularMateria(alumno, modelo.obtenerMateriaPorID(1));
            }
            if(menuMatricular.jCheckBoxMatematicas.isSelected()){
                modelo.matricularMateria(alumno, modelo.obtenerMateriaPorID(5));
            }
            if (menuMatricular.jCheckBoxSociales.isSelected()) {
                modelo.matricularMateria(alumno, modelo.obtenerMateriaPorID(4));
            }
        }else{
             if(menuMatricular.jCheckBoxFisica.isSelected()){
                modelo.matricularMateria(alumno, modelo.obtenerMateriaPorID(3));
            }
            if(menuMatricular.jCheckBoxEspanol.isSelected()){
                modelo.matricularMateria(alumno, modelo.obtenerMateriaPorID(6));
            }
            if(menuMatricular.jCheckBoxMatematicas.isSelected()){
                modelo.matricularMateria(alumno, modelo.obtenerMateriaPorID(2));
            }
            if (menuMatricular.jCheckBoxSociales.isSelected()) {
                modelo.matricularMateria(alumno, modelo.obtenerMateriaPorID(4));
            }
        }
       
    }

    public void mostrarMatriculados() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("NOMBRE");
        tableModel.addColumn("CEDULA");
        tableModel.addColumn("EDAD");
        tableModel.addColumn("JORNADA");

        ArrayList<Alumno> alumnos = modelo.obtenerListaAlumnos();
        for (Alumno alumno : alumnos) {
            Object[] fila = { alumno.getId(), alumno.getNombre(), alumno.getCedula(), alumno.getEdad(),
                    alumno.getJornadaAsignada().getTipoJornada() };
            tableModel.addRow(fila);
        }
        menuMatriculados.tableMatriculados.setModel(tableModel);

    }

    public void mostrarProfesorPlanta() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("NOMBRE");
        tableModel.addColumn("CEDULA");
        tableModel.addColumn("CATEGORIA");

        ArrayList<ProfesorDePlanta> profesorPlanta = modelo.obtenerListaProfesoresPlanta();
        for (ProfesorDePlanta profesor : profesorPlanta) {
            Object[] fila = { profesor.getId(), profesor.getNombre(), profesor.getCedula(), profesor.getCategoria() };
            tableModel.addRow(fila);
        }
        menuProfesorPlanta.tableProfesorPlanta.setModel(tableModel);
    }

    public void mostrarProfesorHoras() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("NOMBRE");
        tableModel.addColumn("CEDULA");
        tableModel.addColumn("HORAS");
        tableModel.addColumn("TITULO");

        ArrayList<ProfesorHoras> profesorHoras = modelo.obtenerListaProfesoresHora();
        for (ProfesorHoras profesor : profesorHoras) {
            Object[] fila = { profesor.getId(), profesor.getNombre(), profesor.getCedula(), profesor.getHoras(),
                    profesor.getTitulo() };
            tableModel.addRow(fila);
        }
        menuProfesorHoras.tableProfesorHoras.setModel(tableModel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.btnProfesorPlanta) {
            principal.dispose();
            mostrarProfesorPlanta();
            menuProfesorPlanta.setVisible(true);
        }
        if (e.getSource() == principal.btnMatricularMaterias) {
            principal.dispose();
            menuMatricular.setVisible(true);
        }
        if (e.getSource() == principal.btnProfesorHoras) {
            principal.dispose();
            mostrarProfesorHoras();
            menuProfesorHoras.setVisible(true);
        }
        if (e.getSource() == menuProfesorHoras.btnVolverPrincipal) {
            cerrarVentanas(menuProfesorHoras);
        }
        if (e.getSource() == menuProfesorPlanta.btnVolverPrincipal) {
            cerrarVentanas(menuProfesorPlanta);
        }
        if (e.getSource() == menuMatricular.btnVolver) {
            cerrarVentanas(menuMatricular);
        }
        if (e.getSource() == menuMatriculados.btnVolver) {
            cerrarVentanas(menuMatriculados);
        }
        if (e.getSource() == principal.btnMatriculados) {
            principal.dispose();
            mostrarMatriculados();
            menuMatriculados.setVisible(true);

        }
        if (e.getSource() == menuMatricular.btnGuardarDatos) {
            matricularMaterias();
            JOptionPane.showMessageDialog(menuMatriculados, "Estudiante matriculado con exito");
            menuMatricular.textFieldName.setText("");
            menuMatricular.textFieldCedula.setText("");
            menuMatricular.textFieldApellido.setText("");
            menuMatricular.textFieldEdad.setText("");
            menuMatricular.jCheckBoxFisica.setSelected(false);
            menuMatricular.jCheckBoxMatematicas.setSelected(false);
            menuMatricular.jCheckBoxEspanol.setSelected(false);
            menuMatricular.jCheckBoxSociales.setSelected(false);
        }

    }

}
