/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import contratos.AdministradorDao;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import serviciosproyecto.IServicios;
import serviciosproyecto.ServiciosService;

/**
 *
 * @author usuario
 */
public class AdministradorDaoImp implements AdministradorDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private String urlWSDL = "http://172.21.0.2:1520/WS/ServiciosProy?wsdl";

    @Override
    public boolean validarAdmon(String usuario, String clave) throws SQLException {
        boolean validar = false;
        serviciosproyecto.ServiciosService tx;
        try {
            tx = new ServiciosService(new URL(urlWSDL));
            IServicios serv = tx.getServiciosPort();
            validar = serv.validarAdmon(usuario, clave);
        } catch (Exception e) {
            System.out.println(e);
        }
        return validar;
    }
}
