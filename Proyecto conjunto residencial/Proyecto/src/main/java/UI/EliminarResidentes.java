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
public class EliminarResidentes {

    private Residente residente;
    private String mensaje;

    public void Eliminar() throws SQLException {
        Scanner leer = new Scanner(System.in);
        mensaje = "";
        System.out.println("Ingrese el usuario a eliminar");
        String usuario = leer.nextLine();
        residente = new Residente("", "", usuario, "", "");
        mensaje = residente.eliminarResidente();
        System.out.println(mensaje);
    }
}