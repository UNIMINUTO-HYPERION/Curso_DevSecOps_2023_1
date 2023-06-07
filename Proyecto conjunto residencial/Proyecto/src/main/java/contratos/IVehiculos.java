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
public interface IVehiculos {

    public String eliminarVehiculos() throws SQLException;

    public String consultarVehiculos() throws SQLException;

    public String actualizarVehiculo() throws SQLException;

    public String agregarVehiculo() throws SQLException;
}
