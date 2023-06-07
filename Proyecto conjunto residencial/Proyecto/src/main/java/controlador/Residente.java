/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import contratos.IResidente;
import java.sql.SQLException;
import modelo.ResidentesDaoImp;

/**
 *
 * @author usuario
 */
public class Residente implements IResidente {

    private boolean busuarios;
    private ResidentesDaoImp residentesdao;
    private String page;
    private String mensaje;
    private int res;
    private String nombreResidente;
    private String apellidoResidente;
    private String usuarioResidente;
    private String bloqueResidente;
    private String aptoResidente;

    public Residente(String bnombreResidente, String bapellidoResidente, String busuarioResidente, String bbloqueResidente, String baptoResidente) {
        nombreResidente = bnombreResidente;
        apellidoResidente = bapellidoResidente;
        usuarioResidente = busuarioResidente;
        bloqueResidente = bbloqueResidente;
        aptoResidente = baptoResidente;
    }

    @Override
    public String AgregarResidente() throws SQLException {
        residentesdao = new ResidentesDaoImp();
        busuarios = residentesdao.validarResidente(usuarioResidente);
        if (busuarios == false) {
            res = residentesdao.registrarResidente(nombreResidente, apellidoResidente, usuarioResidente, bloqueResidente, aptoResidente);
            if (res > 0) {
                page = "Usuario agregado correctamente!!!";
            }
        } else {
            page = "El usuario ingresado ya existe!!!!";
        }
        return page;
    }

    @Override
    public String ConsultarResidentes() throws SQLException {
        residentesdao = new ResidentesDaoImp();
        mensaje = residentesdao.consultarResidente(usuarioResidente);
        return mensaje;
    }

    @Override
    public String ConsultarResidenteMoroso() throws SQLException {
        residentesdao = new ResidentesDaoImp();
        mensaje = residentesdao.consultarResidenteMoroso(usuarioResidente);
        return mensaje;
    }

    @Override
    public String pagarAdministracion() throws SQLException {
        residentesdao = new ResidentesDaoImp();
        mensaje = residentesdao.pagarAdministracion(usuarioResidente);
        return mensaje;
    }

    @Override
    public String eliminarResidente() throws SQLException {
        residentesdao = new ResidentesDaoImp();
        res = residentesdao.eliminarResidente(usuarioResidente);
        if (res > 0) {
            mensaje = "Residente eliminado correctamente";
        } else {
            mensaje = "Error al eliminar el residente";
        }
        return mensaje;
    }

    @Override
    public String actualizarResidente() throws SQLException {
        residentesdao = new ResidentesDaoImp();
        res = residentesdao.actualizarResidente(usuarioResidente, bloqueResidente, aptoResidente);
        if (res > 0) {
            mensaje = "Residente actualizado correctamente";
        } else {
            mensaje = "Error al actualizar el residente";
        }
        return mensaje;
    }
}
