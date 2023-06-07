/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import controlador.Residente;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class MenuResidentes {

    int opc = 0;
    private final String usuario;
    private Residente residente;
    private EstadoCuenta estadocuenta;
    private ConsultarMascotas consultarmascotas;
    private ConsultarVehiculos consultarvehiculos;

    public MenuResidentes(String busuario) {
        usuario = busuario;
    }

    public void Menu() throws SQLException {
        Scanner leer = new Scanner(System.in);
        residente = new Residente("", "", usuario, "", "");
        estadocuenta = new EstadoCuenta(usuario);
        consultarmascotas = new ConsultarMascotas(usuario);
        consultarvehiculos = new ConsultarVehiculos(usuario);

        while (opc != 5) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Pagar administración");
            System.out.println("2. Estado de cuenta");
            System.out.println("3. Consultar mascotas");
            System.out.println("4. Consultar vehiculo");
            System.out.println("5. Salir");
            opc = leer.nextInt();
            leer.nextLine();
            switch (opc) {
                case 1:
                    String mensaje = residente.pagarAdministracion();
                    System.out.println(mensaje);
                    break;
                case 2:
                    estadocuenta.Consultar();
                    break;
                case 3:
                    consultarmascotas.Consultar();
                    break;
                case 4:
                    consultarvehiculos.Consultar();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Usted es una bestia, ingrese una opción correcta!!!");
            }
        }
    }
}
