/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import contratos.IVehiculos;
import java.sql.SQLException;
import modelo.ResidentesDaoImp;
import modelo.VehiculosDaoImp;

/**
 *
 * @author usuario
 */
public class Vehiculos implements IVehiculos {

    private int res;
    private VehiculosDaoImp vehiculos;
    private String usuarioResidente;
    private String tipoVehiculo;
    private String placaVehiculo;
    private String marca;
    private String modelo;
    private String mensaje;

    public Vehiculos(String busuarioResidente, String btipoVehiculo, String bPlacaVehiculo, String bmarca, String bmodelo) {
        res = 0;
        usuarioResidente = busuarioResidente;
        tipoVehiculo = btipoVehiculo;
        placaVehiculo = bPlacaVehiculo;
        marca = bmarca;
        modelo = bmodelo;
        mensaje = "";
    }

    @Override
    public String eliminarVehiculos() throws SQLException {
        vehiculos = new VehiculosDaoImp();
        res = vehiculos.eliminarVehiculos(usuarioResidente);
        if (res > 0) {
            mensaje = "Vehiculo eliminado correctamente";
        } else {
            mensaje = "Error al eliminar el Vehiculo";
        }
        return mensaje;
    }

    @Override
    public String consultarVehiculos() throws SQLException {
        vehiculos = new VehiculosDaoImp();
        mensaje = vehiculos.consultarVehiculos(usuarioResidente);
        return mensaje;
    }

    @Override
    public String actualizarVehiculo() throws SQLException {
        vehiculos = new VehiculosDaoImp();
        res = vehiculos.actualizarVehiculo(usuarioResidente, tipoVehiculo, placaVehiculo, marca, modelo);
        if (res > 0) {
            mensaje = "Vehiculo actualizado correctamente";
        } else {
            mensaje = "Error al actualizar el Vehiculo";
        }
        return mensaje;
    }

    @Override
    public String agregarVehiculo() throws SQLException {
        vehiculos = new VehiculosDaoImp();
        res = vehiculos.agregarVehiculo(usuarioResidente, tipoVehiculo, placaVehiculo, marca, modelo);
        if (res > 0) {
            mensaje = "Vehiculo agregado correctamente!!!";
        }
        return mensaje;
    }
}
