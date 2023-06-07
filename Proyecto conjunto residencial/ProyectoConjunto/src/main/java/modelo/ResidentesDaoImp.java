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
    private String WSDL = "http://172.18.0.2:1520/WS/ServiciosProy?wsdl";

    public ResidentesDaoImp() {
        res = 0;
        estado = "Moroso";
    }

    @Override
    public boolean validarResidente(String usuario) throws SQLException {
        boolean validar = false;
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
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
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
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
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            res = serv.registrarResidente(nombre, apellido, usuario, bloque, apto);
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public String consultarResidente(String bloque, String apto) throws SQLException {
        String mensaje = "";
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            mensaje = serv.consultarResidente(bloque, apto);
        } catch (Exception e) {
            System.out.println(e);
        }
        return mensaje;
    }

    @Override
    public String consultarResidenteMoroso(String bloque, String apto) throws SQLException {
        String mensaje = "";
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            mensaje = serv.consultaResMoroso(bloque, apto);
        } catch (Exception e) {
            System.out.println(e);
        }
        return mensaje;
    }

    @Override
    public String consultarIntento(String usuario) throws SQLException {
        String mensaje = "";
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            mensaje = serv.consultarIntento(usuario);
        } catch (Exception e) {
            System.out.println(e);
        }
        return mensaje;
    }

    @Override
    public String validarEstadoBloqueo(String usuario, String estado) throws SQLException {
        String mensaje = "";
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            mensaje = serv.validarEstadoBloqueo(usuario, estado);
        } catch (Exception e) {
            System.out.println(e);
        }
        return mensaje;
    }

    @Override
    public String pagarAdministracion(String bloque, String apto) throws SQLException {
        String estadoFinal = "";
        String mensaje = "";
        int res = 0;
        String pagoMascota = "";
        String pagoVehiculo = "";
        int pagoTotal = 120000;
        MascotasDaoImp mascotas = new MascotasDaoImp();
        VehiculosDaoImp vehiculos = new VehiculosDaoImp();
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            estadoFinal = serv.consultaResMoroso(bloque, apto);
            if (estadoFinal.equals("Al dia")) {
                mensaje = "Esta al día";
            } else if (estadoFinal.equals("Moroso")) {
                res = serv.actualizarEstado(bloque, apto);
                pagoMascota = mascotas.consultarMascotas(bloque, apto);
                pagoVehiculo = vehiculos.consultarVehiculos(bloque, apto);
                if (res == 0) {
                    mensaje = "Error en base de datos!!!";
                } else {
                    if (!pagoMascota.equals("No tiene mascotas!!!!")) {
                        pagoTotal = pagoTotal + 20000;
                    }
                    if (!pagoVehiculo.equals("No tiene vehiculos!!!!")) {
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
    public boolean validarResidenteApto(String bloque, String apto) throws SQLException {
        boolean validar = false;
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            validar = serv.validarResidenteApto(bloque, apto);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }

        return validar;
    }

    @Override
    public int eliminarResidente(String bloque, String apto) throws SQLException {
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            res = serv.eliminarResidente(bloque, apto);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public int actualizarResidente(String bloqueAnt, String aptoAnt, String bloqueNu, String aptoNu) throws SQLException {
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            res = serv.actualizarResidente(bloqueAnt, aptoAnt, bloqueNu, aptoNu);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return res;
    }
    
    @Override
    public int actualizarIntento(String usuario, String intento) throws SQLException {
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            res = serv.actualizarIntento(usuario, intento);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public int cambiarClave(String usuario, String clave) throws SQLException {
        try {
            serviciosproyecto.ServiciosService servicios = new ServiciosService(new URL(WSDL));
            IServicios serv = servicios.getServiciosPort();
            res = serv.cambiarClave(usuario, clave);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        return res;
    }
}
