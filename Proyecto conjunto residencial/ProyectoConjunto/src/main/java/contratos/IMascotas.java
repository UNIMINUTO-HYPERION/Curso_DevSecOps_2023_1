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
public interface IMascotas {

    public String eliminarMascota() throws SQLException;

    public String consultarMascotas() throws SQLException;

    public String actualizarMascota() throws SQLException;

    public String agregarMascota() throws SQLException;
}