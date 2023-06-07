/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import contratos.IMascotas;
import java.sql.SQLException;
import modelo.MascotasDaoImp;
import modelo.VehiculosDaoImp;

/**
 *
 * @author usuario
 */
public class Mascotas implements IMascotas {

    private int res;
    private MascotasDaoImp mascotas;
    private String tipoMascota;
    private String nombreMascota;
    private String edadMascota;
    private String usuario;
    private String mensaje;

    public Mascotas(String btipoMascota, String bnombreMascota, String bedadMascota, String busuario) {
        tipoMascota = btipoMascota;
        nombreMascota = bnombreMascota;
        edadMascota = bedadMascota;
        usuario = busuario;
    }

    @Override
    public String eliminarMascota() throws SQLException {
        mascotas = new MascotasDaoImp();
        res = mascotas.eliminarMascota(usuario);
        if (res > 0) {
            mensaje = "Mascota eliminada correctamente";
        } else {
            mensaje = "Error al eliminar la mascota";
        }
        return mensaje;
    }

    @Override
    public String consultarMascotas() throws SQLException {
        mascotas = new MascotasDaoImp();
        mensaje = mascotas.consultarMascotas(usuario);
        return mensaje;
    }

    @Override
    public String actualizarMascota() throws SQLException {
        mascotas = new MascotasDaoImp();
        res = mascotas.actualizarMascota(tipoMascota, nombreMascota, edadMascota, usuario);
        if (res > 0) {
            mensaje = "Mascota actualizada correctamente";
        } else {
            mensaje = "Error al actualizar la mascota";
        }
        return mensaje;
    }

    @Override
    public String agregarMascota() throws SQLException {
        mascotas = new MascotasDaoImp();
        res = mascotas.agregarMascota(tipoMascota, nombreMascota, edadMascota, usuario);
        if (res > 0) {
            mensaje = "Mascota agregada correctamente!!!";
        }
        return mensaje;

    }

}