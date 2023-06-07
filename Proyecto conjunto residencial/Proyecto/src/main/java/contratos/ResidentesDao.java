/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contratos;

import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public interface ResidentesDao {

    public boolean validarResidente(String usuario) throws SQLException;

    public boolean Login(String usuario, String clave) throws SQLException;

    public int registrarResidente(String nombre, String apellido, String usuario, String bloque, String apto) throws SQLException;

    public String consultarResidente(String usuario) throws SQLException;

    public String consultarResidenteMoroso(String usuario) throws SQLException;

    public int eliminarResidente(String usuario) throws SQLException;

    public int actualizarResidente(String usuario, String bloque, String apto) throws SQLException;
}
