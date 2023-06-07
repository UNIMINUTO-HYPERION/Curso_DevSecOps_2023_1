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
public interface AdministradorDao {
    
    public boolean validarAdmon(String usuario, String clave) throws SQLException;
    
}
