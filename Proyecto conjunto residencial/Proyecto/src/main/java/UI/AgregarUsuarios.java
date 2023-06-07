/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import controlador.Mascotas;
import controlador.Residente;
import controlador.Vehiculos;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class AgregarUsuarios {

    private Residente residente;
    private String mensaje;
    private Vehiculos vehiculos;
    private Mascotas mascotas;

    public void Agregar() throws SQLException {
        Scanner leer = new Scanner(System.in);
        mensaje = "";
        System.out.println("Ingrese el nombre");
        String nombreResidente = leer.nextLine();
        System.out.println("Ingrese el apellido");
        String apellidoResidente = leer.nextLine();
        System.out.println("Ingrese el usuario");
        String usuarioResidente = leer.nextLine();
        System.out.println("Ingrese el bloque");
        String bloqueResidente = leer.nextLine();
        System.out.println("Ingrese el apartamento");
        String aptoResidente = leer.nextLine();
        System.out.println("¿Tiene mascota?");
        String mascota = leer.nextLine();
        if (mascota.equals("Si")) {
            System.out.println("Tipo de mascota: ");
            String tipoMascota = leer.nextLine();
            System.out.println("Nombre: ");
            String nombreMascota = leer.nextLine();
            System.out.println("Edad de la mascota: ");
            String edadMascota = leer.nextLine();
            mascotas = new Mascotas(tipoMascota,nombreMascota,edadMascota,usuarioResidente);
            mascotas.agregarMascota();
        }
        System.out.println("¿Tiene vehiculo?");
        String vehiculo = leer.nextLine();
        if (vehiculo.equals("Si")) {
            System.out.println("Tipo de vehiculo: ");
            String tipoVehiculo = leer.nextLine();
            System.out.println("Placa del vehiculo: ");
            String placaVehiculo = leer.nextLine();
            System.out.println("Marca del vehiculo: ");
            String marcaVehiculo = leer.nextLine();
            System.out.println("Modelo del vehiculo: ");
            String modeloVehiculo = leer.nextLine();
            vehiculos = new Vehiculos(usuarioResidente, tipoVehiculo, placaVehiculo, marcaVehiculo, modeloVehiculo);
            vehiculos.agregarVehiculo();
        }
        residente = new Residente(nombreResidente, apellidoResidente, usuarioResidente, bloqueResidente, aptoResidente);
        mensaje = residente.AgregarResidente();
        System.out.println(mensaje);
    }
}
