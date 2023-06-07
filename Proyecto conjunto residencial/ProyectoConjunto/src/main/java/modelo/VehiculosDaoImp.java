/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import serviciosproyecto.IServicios;
import serviciosproyecto.ServiciosService;
import contratos.IVehiculosDaoImp;
import java.sql.Connection;

/**
 *
 * @author usuario
 */
public class VehiculosDaoImp implements IVehiculosDaoImp {

    private int res;
    private String WSDL = "http://172.18.0.2:1520/WS/ServiciosProy?wsdl";

    public VehiculosDaoImp() {
        res = 0;
    }

    @Override
    public int eliminarVehiculos(String bloque, String apto) throws SQLException {
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            res = serv.eliminarVehiculos(bloque, apto);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public String consultarVehiculos(String bloque, String apto) throws SQLException {
        String mensaje = "";
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            mensaje = serv.consultarVehiculos(bloque, apto);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return mensaje;
    }

    @Override
    public int actualizarVehiculo(String bloque, String apto, String tipoVehiculo, String placaVehiculo, String marca, String modelo, String parqueadero) throws SQLException {
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            res = serv.actualizarVehiculo(bloque, apto, tipoVehiculo, placaVehiculo, marca, modelo, parqueadero);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public int agregarVehiculo(String bloque, String apto, String tipoVehiculo, String placaVehiculo, String marca, String modelo, String parqueadero) throws SQLException {
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            res = serv.agregarVehiculo(bloque, apto, tipoVehiculo, placaVehiculo, marca, modelo, parqueadero);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public boolean validarParqueadero(String parqueadero) throws SQLException {
        boolean validar = false;
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            validar = serv.validarParqueadero(parqueadero);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }

        return validar;
    }
    
    @Override
    public boolean ValidarVehiculo(String bloque, String apto) throws SQLException {
        boolean validar = false;
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            validar = serv.validarVehiculo(bloque, apto);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return validar;
    }
}
