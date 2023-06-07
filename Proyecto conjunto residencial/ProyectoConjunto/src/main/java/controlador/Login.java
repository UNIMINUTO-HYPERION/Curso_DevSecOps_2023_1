/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import contratos.ILogin;
import java.sql.SQLException;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import modelo.AdministradorDaoImp;
import modelo.ResidentesDaoImp;

/**
 *
 * @author usuario
 */
@Named(value = "Login")
@RequestScoped
public class Login implements ILogin {

    private AdministradorDaoImp admindao;
    private ResidentesDaoImp residentesdao;
    private boolean validarAdmin;
    private boolean validarResidente;
    private String page = "";
    private String usuario;
    private String clave;
    private String estado_res;
    private String tipo_res;
    private int contador = 0;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String InicioSesion() throws SQLException {
        contador = 0;
        int res = 0;
        admindao = new AdministradorDaoImp();
        residentesdao = new ResidentesDaoImp();
        validarAdmin = admindao.validarAdmon(usuario, clave);
        validarResidente = residentesdao.Login(usuario, clave);
        estado_res = residentesdao.validarEstadoBloqueo(usuario, "tipo_res");
        tipo_res = residentesdao.consultarIntento(usuario);
        if (tipo_res.equals("3")) {
            page = "UI/ErrorUsuarios";
        } else {
            if (validarAdmin) {
                page = "UI/MenuAdmin";
            } else {
                if (validarResidente) {
                    if (estado_res.equals("Nuevo")) {
                        page = "UI/CambioClave";
                    } else {
                        page = "UI/MenuResidentes";
                        residentesdao.actualizarIntento(usuario, "0");
                    }
                } else {
                    page = "UI/ErrorUsuarios";
                    contador = Integer.parseInt(residentesdao.consultarIntento(usuario));
                    contador = contador + 1;
                    residentesdao.actualizarIntento(usuario, String.valueOf(contador));
                }
            }
        }
        return page;
    }
}