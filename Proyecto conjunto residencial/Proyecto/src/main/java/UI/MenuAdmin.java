/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class MenuAdmin {

    int opc = 0;
    private AgregarUsuarios agregar;
    private ConsultarResidentes consultar;
    private ConsultarResMorosos consultarresMoroso;
    private ModificarResidentes modificarresidentes;
    private EliminarResidentes eliminarresidentes;
    private EliminarMascota eliminarmascota;
    private EliminarVehiculo eliminarvehiculo;
    private ConsultarMascotasAdmin consultarmascotasadmin;
    private ConsultarVehiculosAdmin consultarvehiculosadmin;

    public void Menu() throws SQLException {
        Scanner leer = new Scanner(System.in);
        agregar = new AgregarUsuarios();
        consultar = new ConsultarResidentes();
        consultarresMoroso = new ConsultarResMorosos();
        modificarresidentes = new ModificarResidentes();
        eliminarresidentes = new EliminarResidentes();
        eliminarmascota = new EliminarMascota();
        eliminarvehiculo = new EliminarVehiculo();
        consultarmascotasadmin = new ConsultarMascotasAdmin();
        consultarvehiculosadmin = new ConsultarVehiculosAdmin();
        while (opc != 10) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Agregar residentes");
            System.out.println("2. Modificar residentes");
            System.out.println("3. Eliminar residentes");
            System.out.println("4. Eliminar mascota");
            System.out.println("5. Eliminar vehiculo");
            System.out.println("6. Consultar residentes");
            System.out.println("7. Consultar residente moroso");
            System.out.println("8. Consultar mascotas por residente");
            System.out.println("9. Consultar vehiculos por residente");
            System.out.println("10. Salir");
            opc = leer.nextInt();
            leer.nextLine();
            switch (opc) {
                case 1:
                    agregar.Agregar();
                    break;
                case 2:
                    modificarresidentes.Modificar();
                    break;
                case 3:
                    eliminarresidentes.Eliminar();
                    break;
                case 4:
                    eliminarmascota.Eliminar();
                    break;
                case 5:
                    eliminarvehiculo.Eliminar();
                    break;
                case 6:
                    consultar.Consultar();
                    break;
                case 7:
                    consultarresMoroso.Consultar();
                    break;
                case 8:
                    consultarmascotasadmin.Consultar();
                    break;
                case 9:
                    consultarvehiculosadmin.Consultar();
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Usted es una bestia, ingrese una opción correcta!!!");
            }
        }
    }
}