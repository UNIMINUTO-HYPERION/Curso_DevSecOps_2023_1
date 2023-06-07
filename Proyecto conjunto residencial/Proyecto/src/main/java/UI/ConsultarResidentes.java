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
public class ConsultarResidentes {

    private Residente residente;
    private String mensaje;

    public void Consultar() throws SQLException {
        Scanner leer = new Scanner(System.in);
        mensaje = "";
        System.out.println("Ingrese el usuario");
        String usuario = leer.nextLine();
        residente = new Residente("","",usuario,"","");
        mensaje = residente.ConsultarResidentes();
        System.out.println(mensaje);
    }
}