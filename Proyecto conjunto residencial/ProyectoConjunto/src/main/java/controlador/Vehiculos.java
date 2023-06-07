/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import contratos.IVehiculos;
import java.sql.SQLException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import modelo.ResidentesDaoImp;
import modelo.VehiculosDaoImp;

/**
 *
 * @author usuario
 */
@Named(value = "Vehiculos")
@RequestScoped
public class Vehiculos implements IVehiculos {

    private int res;
    private VehiculosDaoImp vehiculos;
    private ResidentesDaoImp residentes;
    private String usuarioResidente;
    private String tipoVehiculo;
    private String placaVehiculo;
    private String marca;
    private String modelo;
    private String mensaje;
    private String apto;
    private String bloque;
    private String parqueadero;
    private boolean validar;
    private boolean validarVehiculo;
    private boolean validarResidente;

    public String getUsuarioResidente() {
        return usuarioResidente;
    }

    public void setUsuarioResidente(String usuarioResidente) {
        this.usuarioResidente = usuarioResidente;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getApto() {
        return apto;
    }

    public void setApto(String apto) {
        this.apto = apto;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(String parqueadero) {
        this.parqueadero = parqueadero;
    }

    @Override
    public String eliminarVehiculos() throws SQLException {
        vehiculos = new VehiculosDaoImp();
        res = vehiculos.eliminarVehiculos(bloque, apto);
        if (res < 0) {
            mensaje = "Vehiculo eliminado correctamente!!!";
        } else {
            mensaje = "Error al eliminar vehiculo";
        }
        return mensaje;
    }

    @Override
    public String consultarVehiculos() throws SQLException {
        vehiculos = new VehiculosDaoImp();
        mensaje = vehiculos.consultarVehiculos(bloque, apto);
        return mensaje;
    }

    @Override
    public String actualizarVehiculo() throws SQLException {
        vehiculos = new VehiculosDaoImp();
        res = vehiculos.actualizarVehiculo(bloque, apto, tipoVehiculo, placaVehiculo, marca, modelo, parqueadero);
        if (res > 0) {
            mensaje = "Vehiculo actualizado correctamente!!!";
        } else {
            mensaje = "Error al actualizar vehiculo";
        }
        return mensaje;
    }

    @Override
    public String agregarVehiculo() throws SQLException {
        vehiculos = new VehiculosDaoImp();
        residentes = new ResidentesDaoImp();
        validar = vehiculos.validarParqueadero(parqueadero);
        validarVehiculo = vehiculos.ValidarVehiculo(bloque, apto);
        validarResidente = residentes.validarResidenteApto(bloque, apto);
        if (validar == false && validarVehiculo == false && validarResidente == true) {
            res = vehiculos.agregarVehiculo(bloque, apto, tipoVehiculo, placaVehiculo, marca, modelo, parqueadero);
            if (res > 0) {
                mensaje = "VehiculoAgregado";
            }
        } else {
            mensaje = "ErrorVehiculos";
        }
        return mensaje;
    }

}
