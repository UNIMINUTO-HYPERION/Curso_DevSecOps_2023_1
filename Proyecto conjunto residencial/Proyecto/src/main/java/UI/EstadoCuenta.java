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
public class EstadoCuenta {

    private Residente residente;
    private String mensaje;
    private final String usuario;
    
    public EstadoCuenta(String busuario){
        usuario = busuario;
    }

    public void Consultar() throws SQLException {
        mensaje = "";
        residente = new Residente("", "", usuario, "", "");
        mensaje = residente.ConsultarResidenteMoroso();
        System.out.println(mensaje);
    }
}
