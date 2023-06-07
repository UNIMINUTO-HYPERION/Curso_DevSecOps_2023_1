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
public interface IVehiculosDaoImp {

    public int eliminarVehiculos(String usuario) throws SQLException;

    public String consultarVehiculos(String usuario) throws SQLException;

    public int actualizarVehiculo(String usuario, String tipoVehiculo, String placaVehiculo, String marca, String modelo) throws SQLException;

    public int agregarVehiculo(String usuario, String tipoVehiculo, String placaVehiculo, String marca, String modelo) throws SQLException;
}
