/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import contratos.ILogin;
import java.sql.SQLException;
import modelo.AdministradorDaoImp;
import modelo.ResidentesDaoImp;

/**
 *
 * @author usuario
 */

public class Login implements ILogin {

    private AdministradorDaoImp admindao;
    private ResidentesDaoImp residentesdao;
    private boolean validarAdmin;
    private boolean validarResidente;
    private String page = "";
    private String usuario;
    private String clave;

    public Login(String busuario, String bclave){
        usuario = busuario;
        clave = bclave;
    }

    @Override
    public String InicioSesion() throws SQLException {
        admindao = new AdministradorDaoImp();
        residentesdao = new ResidentesDaoImp();
        validarAdmin = admindao.validarAdmon(usuario, clave);
        validarResidente = residentesdao.Login(usuario,clave);
        if (validarAdmin) {
            page = "MenuAdmin";
        } else {
            if (validarResidente) {
                page = "MenuResidente";
            } else {
                page = "ErrorUsuario";
            }
        }
        return page;
    }
}
