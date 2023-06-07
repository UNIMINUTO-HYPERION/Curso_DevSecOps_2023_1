/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import controlador.Vehiculos;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class ConsultarVehiculos {

    private Vehiculos vehiculos;
    private String mensaje;
    private final String usuario;
    
    public ConsultarVehiculos(String busuario){
        usuario = busuario;
    }

    public void Consultar() throws SQLException {
        mensaje = "";
        vehiculos = new Vehiculos(usuario, "", "", "", "");
        mensaje = vehiculos.consultarVehiculos();
        System.out.println(mensaje);
    }
}