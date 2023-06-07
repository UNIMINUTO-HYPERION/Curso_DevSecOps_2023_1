/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contratos;

import java.sql.SQLException;
import java.util.List;
import modelo.ResidentesDaoImp;

/**
 *
 * @author usuario
 */
public interface ResidentesDao {

    public boolean validarResidente(String usuario) throws SQLException;

    public boolean validarResidenteApto(String bloque, String apto) throws SQLException;

    public boolean Login(String usuario, String clave) throws SQLException;

    public int registrarResidente(String nombre, String apellido, String usuario, String bloque, String apto) throws SQLException;

    public String consultarResidente(String bloque, String apto) throws SQLException;

    public String consultarResidenteMoroso(String bloque, String apto) throws SQLException;

    public String pagarAdministracion(String bloque, String apto) throws SQLException;

    public int eliminarResidente(String bloque, String apto) throws SQLException;

    public int actualizarResidente(String bloqueAnt, String aptoAnt, String bloqueNu, String aptoNu) throws SQLException;

    public String validarEstadoBloqueo(String usuario, String estado) throws SQLException;

    public int cambiarClave(String usuario, String clave) throws SQLException;
    
    public String consultarIntento(String usuario) throws SQLException;
    
    public int actualizarIntento(String usuario, String intento) throws SQLException;
    
}
