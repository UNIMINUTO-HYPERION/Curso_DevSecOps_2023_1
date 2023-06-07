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

    public int eliminarVehiculos(String bloque, String apto) throws SQLException;

    public String consultarVehiculos(String bloque, String apto) throws SQLException;

    public int actualizarVehiculo(String bloque, String apto, String tipoVehiculo, String placaVehiculo, String marca, String modelo, String parqueadero) throws SQLException;

    public int agregarVehiculo(String bloque, String apto, String tipoVehiculo, String placaVehiculo, String marca, String modelo, String parqueadero) throws SQLException;

    public boolean validarParqueadero(String parqueadero) throws SQLException;
    
    public boolean ValidarVehiculo(String bloque, String apto) throws SQLException;
}