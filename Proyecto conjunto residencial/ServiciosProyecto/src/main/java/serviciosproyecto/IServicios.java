/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosproyecto;

import java.sql.SQLException;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author usuario
 */
@WebService
public interface IServicios {

    @WebMethod
    public boolean validarAdmon(String usuario, String clave);

    @WebMethod
    public boolean validarResidente(String usuario);

    @WebMethod
    public boolean validarResidenteApto(String bloque, String apto);

    @WebMethod
    public boolean validarParqueadero(String parqueadero);

    @WebMethod
    public boolean Login(String usuario, String clave);

    @WebMethod
    public int registrarResidente(String nombre, String apellido, String usuario, String bloque, String apto);

    @WebMethod
    public String consultarResidente(String bloque, String apto);

    @WebMethod
    public String consultaResMoroso(String bloque, String apto);

    @WebMethod
    public int actualizarEstado(String bloque, String apto);

    @WebMethod
    public int agregarMascota(String tipoMascota, String nombreMascota, String edadMascota, String bloque, String apto);

    @WebMethod
    public int actualizarResidente(String bloqueAnt, String aptoAnt, String bloqueNu, String aptoNu);

    @WebMethod
    public int actualizarMascota(String tipoMascota, String nombreMascota, String edadMascota, String bloque, String apto);

    @WebMethod
    public int agregarVehiculo(String bloque, String apto, String tipoVehiculo, String placaVehiculo, String marca, String modelo, String parqueadero);

    @WebMethod
    public int actualizarVehiculo(String bloque, String apto, String tipoVehiculo, String placaVehiculo, String marca, String modelo, String parqueadero);

    @WebMethod
    public String consultarVehiculos(String bloque, String apto);

    @WebMethod
    public String consultarMascotas(String bloque, String apto);

    @WebMethod
    public int eliminarMascota(String bloque, String apto);

    @WebMethod
    public int eliminarVehiculos(String bloque, String apto);

    @WebMethod
    public int eliminarResidente(String bloque, String apto);

    @WebMethod
    public boolean validarVehiculo(String bloque, String apto);

    @WebMethod
    public boolean validarMascotas(String bloque, String apto);

    @WebMethod
    public String validarEstadoBloqueo(String usuario, String estado);

    @WebMethod
    public int cambiarClave(String usuario, String clave);
    
    @WebMethod
    public String consultarIntento(String usuario);
    
    @WebMethod
    public int actualizarIntento(String usuario, String intentos);
}
