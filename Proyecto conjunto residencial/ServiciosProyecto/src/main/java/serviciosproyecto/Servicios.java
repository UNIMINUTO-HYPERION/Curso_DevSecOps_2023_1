/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosproyecto;

import conexion.ConectarBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.jws.WebService;

/**
 *
 * @author usuario
 */
@WebService(endpointInterface = "serviciosproyecto.IServicios")
public class Servicios implements IServicios {

    private PreparedStatement ps;
    private ResultSet rs;
    private int res;
    private final String estado;

    public Servicios() {
        res = 0;
        estado = "Moroso";
    }

    @Override
    public boolean validarAdmon(String usuario, String clave) {
        boolean validar = false;
        ConectarBD con = new ConectarBD();
        Connection reg = con.getConnection();
        try {
            ps = reg.prepareStatement("SELECT * FROM administradores WHERE usuario='" + usuario + "' AND clave ='" + clave + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                validar = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return validar;
    }

    @Override
    public boolean validarResidente(String usuario) {
        boolean validar = false;
        ConectarBD con = new ConectarBD();
        Connection reg = con.getConnection();
        try {
            ps = reg.prepareStatement("SELECT * FROM residentes WHERE usuario='" + usuario + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                validar = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return validar;
    }

    @Override
    public String validarEstadoBloqueo(String usuario, String estado) {
        String mensaje = "";
        ConectarBD con = new ConectarBD();
        Connection reg = con.getConnection();
        try {
            ps = reg.prepareStatement("SELECT * FROM residentes WHERE usuario='" + usuario + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                mensaje = rs.getString(estado);
            } else {
                mensaje = "Error!!!!";
            }
            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return mensaje;
    }

    @Override
    public boolean validarResidenteApto(String bloque, String apto) {
        boolean validar = false;
        ConectarBD con = new ConectarBD();
        Connection reg = con.getConnection();
        try {
            ps = reg.prepareStatement("SELECT * FROM residentes WHERE bloque='" + bloque + "' AND apto='" + apto + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                validar = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return validar;
    }

    @Override
    public boolean validarVehiculo(String bloque, String apto) {
        boolean validar = false;
        ConectarBD con = new ConectarBD();
        Connection reg = con.getConnection();
        try {
            ps = reg.prepareStatement("SELECT * FROM vehiculos WHERE bloque='" + bloque + "' AND apto='" + apto + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                validar = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return validar;
    }

    @Override
    public boolean validarMascotas(String bloque, String apto) {
        boolean validar = false;
        ConectarBD con = new ConectarBD();
        Connection reg = con.getConnection();
        try {
            ps = reg.prepareStatement("SELECT * FROM mascotas WHERE bloque='" + bloque + "' AND apto='" + apto + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                validar = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return validar;
    }

    @Override
    public boolean validarParqueadero(String parqueadero) {
        boolean validar = false;
        ConectarBD con = new ConectarBD();
        Connection reg = con.getConnection();
        try {
            ps = reg.prepareStatement("SELECT * FROM vehiculos WHERE Noparqueadero='" + parqueadero + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                validar = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return validar;
    }

    @Override
    public boolean Login(String usuario, String clave) {
        boolean validar = false;
        ConectarBD con = new ConectarBD();
        Connection reg = con.getConnection();
        try {
            ps = reg.prepareStatement("SELECT * FROM residentes WHERE usuario='" + usuario + "' AND clave= '" + clave + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                validar = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return validar;
    }

    @Override
    public int registrarResidente(String nombre, String apellido, String usuario, String bloque, String apto) {
        ConectarBD con = new ConectarBD();
        Connection reg = con.getConnection();
        try {
            ps = reg.prepareStatement("INSERT INTO residentes (nombre,apellido,usuario,clave,bloque,apto,estado,estado_res,tipo_res,intentos) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, usuario);
            ps.setString(4, usuario);
            ps.setString(5, bloque);
            ps.setString(6, apto);
            ps.setString(7, estado);
            ps.setString(8, "Activo");
            ps.setString(9, "Nuevo");
            ps.setString(10, "0");
            res = ps.executeUpdate();
            con.desconectar();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public String consultarResidente(String bloque, String apto) {
        String mensaje = "";
        ConectarBD con = new ConectarBD();
        Connection reg = con.getConnection();
        try {
            ps = reg.prepareStatement("SELECT * FROM residentes WHERE bloque='" + bloque + "' AND apto='" + apto + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                mensaje = "Nombre: " + rs.getString("nombre") + " Apellido: " + rs.getString("Apellido") + " Bloque: " + rs.getString("bloque") + " Apto: " + rs.getString("apto");
            } else {
                mensaje = "No existe ese usuario!!!!";
            }
            con.desconectar();
        } catch (Exception e) {
            System.out.println(e);
        }
        return mensaje;
    }

    @Override
    public String consultaResMoroso(String bloque, String apto) {
        String mensaje = "";
        ConectarBD con = new ConectarBD();
        Connection reg = con.getConnection();
        try {
            ps = reg.prepareStatement("SELECT estado FROM residentes WHERE bloque='" + bloque + "' AND apto='" + apto + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                mensaje = rs.getString("estado");
            } else {
                mensaje = "No existe ese usuario!!!!";
            }
            con.desconectar();
        } catch (Exception e) {
            System.out.println(e);
        }
        return mensaje;

    }

    @Override
    public int actualizarEstado(String bloque, String apto) {
        try {
            ConectarBD con = new ConectarBD();
            Connection reg = con.getConnection();
            ps = reg.prepareStatement("UPDATE residentes SET estado = 'Al dia' WHERE bloque = '" + bloque + "' AND apto='" + apto + "'");
            res = ps.executeUpdate();
            con.desconectar();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public int agregarMascota(String tipoMascota, String nombreMascota, String edadMascota, String bloque, String apto) {
        ConectarBD con = new ConectarBD();
        Connection reg = con.getConnection();
        try {
            ps = reg.prepareStatement("INSERT INTO mascotas (tipoMascota,nombreMascota,edadMascota,bloque,apto) VALUES(?,?,?,?,?)");
            ps.setString(1, tipoMascota);
            ps.setString(2, nombreMascota);
            ps.setString(3, edadMascota);
            ps.setString(4, bloque);
            ps.setString(5, apto);
            res = ps.executeUpdate();
            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public int actualizarResidente(String bloqueAnt, String aptoAnt, String bloqueNu, String aptoNu) {
        try {
            ConectarBD con = new ConectarBD();
            Connection reg = con.getConnection();
            ps = reg.prepareStatement("SELECT * FROM mascotas WHERE bloque='" + bloqueAnt + "' AND apto='" + aptoAnt + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                String tipoMascota = rs.getString("tipoMascota");
                String nombreMascota = rs.getString("nombreMascota");
                String edadMascota = rs.getString("edadMascota");
                eliminarMascota(bloqueAnt, aptoAnt);
                agregarMascota(tipoMascota, nombreMascota, edadMascota, bloqueNu, aptoNu);
            } else {
                System.out.println("No existe ese usuario!!!!");
            }
            ps = reg.prepareStatement("SELECT * FROM vehiculos WHERE bloque='" + bloqueAnt + "' AND apto='" + aptoAnt + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                String tipoVehiculo = rs.getString("tipoVehiculo");
                String placaVehiculo = rs.getString("placaVehiculo");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String parqueadero = rs.getString("Noparqueadero");
                eliminarVehiculos(bloqueAnt, aptoAnt);
                agregarVehiculo(bloqueNu, aptoNu, tipoVehiculo, placaVehiculo, marca, modelo, parqueadero);
            } else {
                System.out.println("No existe ese usuario!!!!");
            }
            ps = reg.prepareStatement("UPDATE residentes SET bloque='" + bloqueNu + "', apto='" + aptoNu + "' WHERE bloque = '" + bloqueAnt + "' AND apto='" + aptoAnt + "'");
            res = ps.executeUpdate();
            con.desconectar();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;

    }

    @Override
    public int actualizarMascota(String tipoMascota, String nombreMascota, String edadMascota, String bloque, String apto) {
        try {
            ConectarBD con = new ConectarBD();
            Connection reg = con.getConnection();
            ps = reg.prepareStatement("UPDATE mascotas SET tipoMascota='" + tipoMascota + "', nombreMascota='" + nombreMascota + "', edadMascota='" + edadMascota + "' WHERE bloque = '" + bloque + "' AND apto='" + apto + "'");
            res = ps.executeUpdate();
            con.desconectar();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public int agregarVehiculo(String bloque, String apto, String tipoVehiculo, String placaVehiculo, String marca, String modelo, String parqueadero) {
        ConectarBD con = new ConectarBD();
        Connection reg = con.getConnection();
        try {
            ps = reg.prepareStatement("INSERT INTO vehiculos (bloque, apto,tipoVehiculo,placaVehiculo,marca,modelo,Noparqueadero) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, bloque);
            ps.setString(2, apto);
            ps.setString(3, tipoVehiculo);
            ps.setString(4, placaVehiculo);
            ps.setString(5, marca);
            ps.setString(6, modelo);
            ps.setString(7, parqueadero);
            res = ps.executeUpdate();
            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public int actualizarVehiculo(String bloque, String apto, String tipoVehiculo, String placaVehiculo, String marca, String modelo, String parqueadero) {
        try {
            ConectarBD con = new ConectarBD();
            Connection reg = con.getConnection();
            ps = reg.prepareStatement("UPDATE vehiculos SET tipoVehiculo='" + tipoVehiculo + "', placaVehiculo='" + placaVehiculo + "', marca='" + marca + "', modelo='" + modelo + "', Noparqueadero='" + parqueadero + "' WHERE bloque = '" + bloque + "' AND apto='" + apto + "'");
            res = ps.executeUpdate();
            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return res;
    }
    
     @Override
    public int actualizarIntento(String usuario, String intentos) {
        try {
            ConectarBD con = new ConectarBD();
            Connection reg = con.getConnection();
            ps = reg.prepareStatement("UPDATE residentes SET intentos='" + intentos + "' WHERE usuario = '" + usuario + "'");
            res = ps.executeUpdate();
            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public int cambiarClave(String usuario, String clave) {
        try {
            ConectarBD con = new ConectarBD();
            Connection reg = con.getConnection();
            ps = reg.prepareStatement("UPDATE residentes SET clave='" + clave + "', tipo_res='Antiguo' WHERE usuario = '" + usuario + "'");
            res = ps.executeUpdate();
            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public String consultarVehiculos(String bloque, String apto) {
        String mensaje = "";
        ConectarBD con = new ConectarBD();
        Connection reg = con.getConnection();
        try {
            ps = reg.prepareStatement("SELECT * FROM vehiculos WHERE bloque='" + bloque + "' AND apto='" + apto + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                mensaje = "Tipo Vehiculo: " + rs.getString("tipoVehiculo") + " Placa Vehiculo: " + rs.getString("placaVehiculo") + " Marca: " + rs.getString("marca") + " Modelo: " + rs.getString("modelo");
            } else {
                mensaje = "No tiene vehiculos!!!!";
            }
            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return mensaje;
    }
    
    @Override
    public String consultarIntento(String usuario) {
        String mensaje = "";
        ConectarBD con = new ConectarBD();
        Connection reg = con.getConnection();
        try {
            ps = reg.prepareStatement("SELECT * FROM residentes WHERE usuario='" + usuario + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                mensaje = rs.getString("intentos");
            } else {
                mensaje = "Error!!!!";
            }
            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return mensaje;
    }

    @Override
    public String consultarMascotas(String bloque, String apto) {
        String mensaje = "";
        ConectarBD con = new ConectarBD();
        Connection reg = con.getConnection();
        try {
            ps = reg.prepareStatement("SELECT * FROM mascotas WHERE bloque='" + bloque + "' AND apto='" + apto + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                mensaje = "Tipo mascota: " + rs.getString("tipoMascota") + " Nombre Mascota: " + rs.getString("nombreMascota") + " Edad Mascota: " + rs.getString("edadMascota");
            } else {
                mensaje = "No tiene mascotas!!!!";
            }
            con.desconectar();
        } catch (Exception e) {
            System.out.println(e);
        }
        return mensaje;
    }

    @Override
    public int eliminarMascota(String bloque, String apto) {
        try {
            ConectarBD con = new ConectarBD();
            Connection reg = con.getConnection();
            ps = reg.prepareStatement("DELETE FROM mascotas WHERE bloque='" + bloque + "' AND apto='" + apto + "'");
            res = ps.executeUpdate();
            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public int eliminarVehiculos(String bloque, String apto) {
        try {
            ConectarBD con = new ConectarBD();
            Connection reg = con.getConnection();
            ps = reg.prepareStatement("DELETE FROM vehiculos WHERE bloque='" + bloque + "' AND apto='" + apto + "'");
            res = ps.executeUpdate();
            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public int eliminarResidente(String bloque, String apto) {
        try {
            ConectarBD con = new ConectarBD();
            Connection reg = con.getConnection();
            ps = reg.prepareStatement("DELETE FROM residentes WHERE bloque='" + bloque + "' AND apto='" + apto + "'");
            res = ps.executeUpdate();
            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        eliminarVehiculos(bloque, apto);
        eliminarMascota(bloque, apto);
        return res;
    }
}
