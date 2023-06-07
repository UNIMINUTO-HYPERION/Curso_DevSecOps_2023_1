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
public class ModificarResidentes {

    private Residente residente;
    private String mensaje = "";
    private Vehiculos vehiculos;
    private Mascotas mascotas;

    public void Modificar() throws SQLException {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el usuario a modificar");
        String usuario = leer.nextLine();
        System.out.println("Ingrese el nuevo bloque");
        String bloque = leer.nextLine();
        System.out.println("Ingrese el nuevo apartamento");
        String apto = leer.nextLine();
        System.out.println("¿Desea modificar los datos de vehiculo?");
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
            vehiculos = new Vehiculos(usuario, tipoVehiculo, placaVehiculo, marcaVehiculo, modeloVehiculo);
            vehiculos.actualizarVehiculo();
        }
        System.out.println("¿Desea modificar los datos de mascota?");
        String mascota = leer.nextLine();

        if (mascota.equals("Si")) {
            System.out.println("Tipo de mascota: ");
            String tipoMascota = leer.nextLine();
            System.out.println("Nombre: ");
            String nombreMascota = leer.nextLine();
            System.out.println("Edad de la mascota: ");
            String edadMascota = leer.nextLine();
            mascotas = new Mascotas(tipoMascota, nombreMascota, edadMascota, usuario);
            mascotas.actualizarMascota();
        }

        residente = new Residente("", "", usuario, bloque, apto);
        mensaje = residente.actualizarResidente();
        System.out.println(mensaje);

    }
}
