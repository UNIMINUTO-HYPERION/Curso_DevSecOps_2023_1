/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import contratos.IVehiculosDaoImp;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import serviciosproyecto.IServicios;
import serviciosproyecto.ServiciosService;

/**
 *
 * @author usuario
 */
public class VehiculosDaoImp implements IVehiculosDaoImp {

    private int res;
    private String urlWSDL = "http://172.21.0.2:1520/WS/ServiciosProy?wsdl";

    public VehiculosDaoImp() {
        res = 0;
    }

    @Override
    public int eliminarVehiculos(String usuario) throws SQLException {
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(urlWSDL));
            IServicios serv = servicios.getServiciosPort();
            res = serv.eliminarVehiculos(usuario);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public String consultarVehiculos(String usuario) throws SQLException {
        String mensaje = "";
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(urlWSDL));
            IServicios serv = servicios.getServiciosPort();
            mensaje = serv.consultarVehiculos(usuario);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return mensaje;
    }

    @Override
    public int actualizarVehiculo(String usuario, String tipoVehiculo, String placaVehiculo, String marca, String modelo) throws SQLException {
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(urlWSDL));
            IServicios serv = servicios.getServiciosPort();
            res = serv.actualizarVehiculo(usuario, tipoVehiculo, placaVehiculo, marca, modelo);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public int agregarVehiculo(String usuario, String tipoVehiculo, String placaVehiculo, String marca, String modelo) throws SQLException {
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(urlWSDL));
            IServicios serv = servicios.getServiciosPort();
            res = serv.agregarVehiculo(usuario, tipoVehiculo, placaVehiculo, marca, modelo);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return res;
    }

}