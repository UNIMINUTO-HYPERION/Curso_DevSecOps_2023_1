/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import contratos.IMascotas;
import java.sql.SQLException;
import modelo.MascotasDaoImp;
import modelo.ResidentesDaoImp;

/**
 *
 * @author usuario
 */
@Named(value = "Mascotas")
@RequestScoped
public class Mascotas implements IMascotas {

    private int res;
    private MascotasDaoImp mascotas;
    private ResidentesDaoImp residentes;
    private String tipoMascota;
    private String nombreMascota;
    private String edadMascota;
    private String usuario;
    private String mensaje;
    private String bloque;
    private String apto;
    private boolean validarMascota;
    private boolean validarResidente;

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getApto() {
        return apto;
    }

    public void setApto(String apto) {
        this.apto = apto;
    }

    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getEdadMascota() {
        return edadMascota;
    }

    public void setEdadMascota(String edadMascota) {
        this.edadMascota = edadMascota;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String eliminarMascota() throws SQLException {
        mascotas = new MascotasDaoImp();
        res = mascotas.eliminarMascota(bloque, apto);
        if (res < 0) {
            mensaje = "Mascota eliminada correctamente";
        } else {
            mensaje = "Error al eliminar mascota";
        }
        return mensaje;

    }

    @Override
    public String consultarMascotas() throws SQLException {
        mascotas = new MascotasDaoImp();
        mensaje = mascotas.consultarMascotas(bloque, apto);
        return mensaje;
    }

    @Override
    public String actualizarMascota() throws SQLException {
        mascotas = new MascotasDaoImp();
        res = mascotas.actualizarMascota(tipoMascota, nombreMascota, edadMascota, bloque, apto);
        if (res > 0) {
            mensaje = "Mascota actualizada correctamente";
        } else {
            mensaje = "Error al actualizar mascota";
        }
        return mensaje;
    }

    @Override
    public String agregarMascota() throws SQLException {
        mascotas = new MascotasDaoImp();
        residentes = new ResidentesDaoImp();
        validarMascota = mascotas.ValidarMascota(bloque, apto);
        validarResidente = residentes.validarResidenteApto(bloque, apto);
        if (validarMascota == false && validarResidente == true) {
            res = mascotas.agregarMascota(tipoMascota, nombreMascota, edadMascota, bloque, apto);
            if (res > 0) {
                mensaje = "MascotaAgregada";
            }
        } else {
            mensaje = "ErrorMascotas";
        }
        return mensaje;
    }
}
