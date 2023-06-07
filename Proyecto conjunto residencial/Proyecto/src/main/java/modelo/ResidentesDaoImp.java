/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import contratos.ResidentesDao;
import controlador.Login;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import serviciosproyecto.IServicios;
import serviciosproyecto.ServiciosService;

/**
 *
 * @author usuario
 */
public class ResidentesDaoImp implements ResidentesDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private int res;
    private final String estado;
    private String urlWSDL = "http://172.21.0.2:1520/WS/ServiciosProy?wsdl";

    public ResidentesDaoImp() {
        res = 0;
        estado = "Moroso";
    }

    @Override
    public boolean validarResidente(String usuario) throws SQLException {
        boolean validar = false;
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(urlWSDL));
            IServicios serv = servicios.getServiciosPort();
            validar = serv.validarResidente(usuario);
        } catch (Exception e) {
            System.out.println(e);
        }

        return validar;
    }

    @Override
    public boolean Login(String usuario, String clave) throws SQLException {
        boolean validar = false;
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(urlWSDL));
            IServicios serv = servicios.getServiciosPort();
            validar = serv.login(usuario, clave);
        } catch (Exception e) {
            System.out.println(e);
        }
        return validar;
    }

    @Override
    public int registrarResidente(String nombre, String apellido, String usuario, String bloque, String apto) throws SQLException {
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(urlWSDL));
            IServicios serv = servicios.getServiciosPort();
            res = serv.registrarResidente(nombre, apellido, usuario, bloque, apto);
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public String consultarResidente(String usuario) throws SQLException {
        String mensaje = "";
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(urlWSDL));
            IServicios serv = servicios.getServiciosPort();
            mensaje = serv.consultarResidente(usuario);
        } catch (Exception e) {
            System.out.println(e);
        }
        return mensaje;
    }

    @Override
    public String consultarResidenteMoroso(String usuario) throws SQLException {
        String mensaje = "";
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(urlWSDL));
            IServicios serv = servicios.getServiciosPort();
            mensaje = serv.consultaResMoroso(usuario);
        } catch (Exception e) {
            System.out.println(e);
        }
        return mensaje;
    }

    public String pagarAdministracion(String usuario) throws SQLException {
        String estadoFinal = "";
        String mensaje = "";
        int res = 0;
        String pagoMascota="";
        String pagoVehiculo="";
        int pagoTotal = 120000;
        MascotasDaoImp mascotas = new MascotasDaoImp();
        VehiculosDaoImp vehiculos = new VehiculosDaoImp();
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(urlWSDL));
            IServicios serv = servicios.getServiciosPort();
            estadoFinal = serv.consultaResMoroso(usuario);
            if (estadoFinal.equals("Al dia")) {
                mensaje = "Esta al día";
            } else if (estadoFinal.equals("Moroso")) {
                res = serv.actualizarEstado(usuario);
                pagoMascota = mascotas.consultarMascotas(usuario);
                pagoVehiculo = vehiculos.consultarVehiculos(usuario);
                if (res == 0) {
                    mensaje = "Error en base de datos!!!";
                } else {
                    if(!pagoMascota.equals("")){
                        pagoTotal = pagoTotal + 20000;
                    }
                    if(!pagoVehiculo.equals("")){
                        pagoTotal = pagoTotal + 20000;
                    }
                    mensaje = "Gracias por su pago, el valor pagado fue $ " + pagoTotal;
                }
            } else if (estadoFinal.equals("No existe ese usuario!!!!")) {
                mensaje = "No existe ese usuario!!!!";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return mensaje;
    }

    @Override
    public int eliminarResidente(String usuario) throws SQLException {
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(urlWSDL));
            IServicios serv = servicios.getServiciosPort();
            res = serv.eliminarResidente(usuario);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public int actualizarResidente(String usuario, String bloque, String apto) throws SQLException {
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(urlWSDL));
            IServicios serv = servicios.getServiciosPort();
            res = serv.actualizarResidente(usuario, bloque, apto);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return res;
    }
}
