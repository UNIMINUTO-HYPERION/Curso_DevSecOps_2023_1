/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import controlador.Mascotas;
import controlador.Residente;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class ConsultarMascotas {

    private Mascotas mascotas;
    private String mensaje;
    private final String usuario;
    
    public ConsultarMascotas(String busuario){
        usuario = busuario;
    }

    public void Consultar() throws SQLException {
        mensaje = "";
        mascotas = new Mascotas("", "", "", usuario);
        mensaje = mascotas.consultarMascotas();
        System.out.println(mensaje);
    }
}
