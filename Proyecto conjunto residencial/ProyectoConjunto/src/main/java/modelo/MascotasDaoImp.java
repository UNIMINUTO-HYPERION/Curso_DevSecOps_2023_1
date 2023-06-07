/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import contratos.IMascotasDaoImp;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import serviciosproyecto.IServicios;
import serviciosproyecto.ServiciosService;

/**
 *
 * @author usuario
 */
public class MascotasDaoImp implements IMascotasDaoImp {

    private int res;
    private String WSDL = "http://172.18.0.2:1520/WS/ServiciosProy?wsdl";

    public MascotasDaoImp() {
        res = 0;
    }

    @Override
    public int eliminarMascota(String bloque, String apto) throws SQLException {
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            res = serv.eliminarMascota(bloque, apto);
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public String consultarMascotas(String bloque, String apto) throws SQLException {
        String mensaje = "";
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            mensaje = serv.consultarMascotas(bloque, apto);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return mensaje;
    }

    @Override
    public int actualizarMascota(String tipoMascota, String nombreMascota, String edadMascota, String bloque, String apto) throws SQLException {
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            res = serv.actualizarMascota(tipoMascota, nombreMascota, edadMascota, bloque, apto);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public int agregarMascota(String tipoMascota, String nombreMascota, String edadMascota, String bloque, String apto) throws SQLException {
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            res = serv.agregarMascota(tipoMascota, nombreMascota, edadMascota, bloque, apto);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public boolean ValidarMascota(String bloque, String apto) throws SQLException {
        boolean validar = false;
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            validar = serv.validarMascotas(bloque, apto);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return validar;
    }
}
