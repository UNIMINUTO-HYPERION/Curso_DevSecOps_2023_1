/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import contratos.IResidente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import modelo.ResidentesDaoImp;

/**
 *
 * @author usuario
 */
@Named(value = "Residente")
@RequestScoped
public class Residente implements IResidente {

    private boolean busuarios;
    private ResidentesDaoImp residentesdao;
    private String usuario;
    private String nombre;
    private String apellido;
    private String bloque;
    private String apto;
    private String page;
    private String mensaje;
    private String bloqueNu;
    private String aptoNu;
    private String clave;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getBloqueNu() {
        return bloqueNu;
    }

    public void setBloqueNu(String bloqueNu) {
        this.bloqueNu = bloqueNu;
    }

    public String getAptoNu() {
        return aptoNu;
    }

    public void setAptoNu(String aptoNu) {
        this.aptoNu = aptoNu;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

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
    private int res;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String AgregarResidente() throws SQLException {
        residentesdao = new ResidentesDaoImp();
        busuarios = residentesdao.validarResidenteApto(bloque, apto);
        if (busuarios == false) {
            res = residentesdao.registrarResidente(nombre, apellido, usuario, bloque, apto);
            if (res > 0) {
                page = "UsuariosAgregados";
            }
        } else {
            page = "UsuariosExisten";
        }
        return page;
    }

    public String ConsultarResidentes() throws SQLException {
        residentesdao = new ResidentesDaoImp();
        mensaje = residentesdao.consultarResidente(bloque, apto);
        return mensaje;
    }

    public String ConsultarResidenteMoroso() throws SQLException {
        residentesdao = new ResidentesDaoImp();
        mensaje = residentesdao.consultarResidenteMoroso(bloque, apto);
        return mensaje;
    }

    @Override
    public String pagarAdministracion() throws SQLException {
        residentesdao = new ResidentesDaoImp();
        mensaje = residentesdao.pagarAdministracion(bloque, apto);
        return mensaje;
    }

    @Override
    public String eliminarResidente() throws SQLException {
        residentesdao = new ResidentesDaoImp();
        res = residentesdao.eliminarResidente(bloque, apto);
        if (res > 0) {
            mensaje = "Error al eliminar el residente";
        } else {
            mensaje = "Residente eliminado correctamente";
        }
        return mensaje;
    }

    @Override
    public String actualizarResidente() throws SQLException {
        residentesdao = new ResidentesDaoImp();
        res = residentesdao.actualizarResidente(bloque, apto, bloqueNu, aptoNu);
        if (res > 0) {
            mensaje = "Residente actualizado correctamente";
        } else {
            mensaje = "Error al actualizar el residente";
        }
        return mensaje;
    }

    @Override
    public String desbloquearUsuario() throws SQLException {
        residentesdao = new ResidentesDaoImp();
        res = residentesdao.actualizarIntento(usuario, "0");
        if (res > 0) {
            mensaje = "Residente desbloqueado correctamente";
        } else {
            mensaje = "Error al desbloquear el residente";
        }
        return mensaje;
    }

    @Override
    public String cambioClave() throws SQLException {
        residentesdao = new ResidentesDaoImp();
        String clave2 = clave.substring(0, 1).toUpperCase();
        String clave3 = clave.substring(0, 1);
        if (clave.length() >= 8 && clave3.equals(clave2)) {
            if (clave.contains("$") || clave.contains("@") || clave.contains("!")) {
                res = residentesdao.cambiarClave(usuario, clave);
                if (res > 0) {
                    mensaje = "Clave cambiada correctamente";
                } else {
                    mensaje = "Error al cambiar la clave";
                }
            } else {
                mensaje = "La contraseña debe contener caracteres como $ @ ! y debe tener una longitud de 8 caracteres";
            }
        } else {
            mensaje = "La contraseña debe iniciar la primera en mayuscula y debe tener una longitud minima de 8 caracteres";
        }
        return mensaje;
    }
}
