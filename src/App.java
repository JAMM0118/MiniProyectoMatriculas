import controller.Controlador;
import model.Modelo;
import view.Intefaz.VentanaMatriculados;
import view.Intefaz.VentanaMatricular;
import view.Intefaz.VentanaPrincipal;
import view.Intefaz.VentanaProfesorHoras;
import view.Intefaz.VentanaProfesorPlanta;

public class App {
    public static void main(String[] args) throws Exception {
        VentanaPrincipal principal = new VentanaPrincipal();
        VentanaProfesorPlanta profesorPlanta = new VentanaProfesorPlanta();
        VentanaMatricular matricular = new VentanaMatricular();
        VentanaProfesorHoras profesorHoras= new VentanaProfesorHoras();
        VentanaMatriculados matriculados = new VentanaMatriculados();
        Modelo modelo= new Modelo(); 

        Controlador controller = new Controlador(principal,profesorPlanta,matricular,profesorHoras,matriculados,modelo);
        controller.init();
    }
}
