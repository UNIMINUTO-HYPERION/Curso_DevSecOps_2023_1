/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import controlador.Login;
import java.sql.SQLException;
import java.util.Scanner;
import controlador.Login;

/**
 *
 * @author usuario
 */
public class Main {

    public static Login login;
    public static String mensaje;
    public static MenuAdmin menuadmin;
    public static MenuResidentes menures;

    public static void main(String[] args) throws SQLException {
        Scanner leer = new Scanner(System.in);
        mensaje = "";
        menuadmin = new MenuAdmin();
        System.out.println("Ingrese su usuario: ");
        String usuario = leer.nextLine();
        System.out.println("Ingrese su clave: ");
        String clave = leer.nextLine();
        login = new Login(usuario, clave);
        mensaje = login.InicioSesion();
        if (mensaje.equals("MenuAdmin")) {
            menuadmin.Menu();
        }
        if (mensaje.equals("MenuResidente")) {
            menures = new MenuResidentes(usuario);
            menures.Menu();
        }
        if (mensaje.equals("ErrorUsuario")) {
            System.out.println("El usuario ingresado es incorrecto!!!!");
        }
    }
}
