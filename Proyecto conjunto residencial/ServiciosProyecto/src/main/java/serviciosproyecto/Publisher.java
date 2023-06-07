/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosproyecto;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.xml.ws.Endpoint;

/**
 *
 * @author usuario
 */
public class Publisher {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        Servicios serv = new Servicios();
        Endpoint.publish("http://172.18.0.2:1520/WS/ServiciosProy?wsdl", serv);
    }
}