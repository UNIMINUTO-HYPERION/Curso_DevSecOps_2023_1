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
public interface IResidente {

    public String AgregarResidente() throws SQLException;

    public String ConsultarResidentes() throws SQLException;

    public String ConsultarResidenteMoroso() throws SQLException;

    public String pagarAdministracion() throws SQLException;

    public String eliminarResidente() throws SQLException;

    public String actualizarResidente() throws SQLException;
}
