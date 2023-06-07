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
public interface IMascotasDaoImp {

    public int eliminarMascota(String bloque, String apto) throws SQLException;

    public String consultarMascotas(String bloque, String apto) throws SQLException;

    public int actualizarMascota(String tipoMascota, String nombreMascota, String edadMascota, String bloque, String apto) throws SQLException;

    public int agregarMascota(String tipoMascota, String nombreMascota, String edadMascota, String bloque, String apto) throws SQLException;
    
    public boolean ValidarMascota(String bloque, String apto) throws SQLException;
}