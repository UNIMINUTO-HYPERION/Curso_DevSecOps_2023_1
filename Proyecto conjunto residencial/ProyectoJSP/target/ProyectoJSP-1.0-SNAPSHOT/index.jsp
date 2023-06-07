<%-- 
    Document   : index
    Created on : 12/02/2022, 01:29:25 PM
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"></link>
        <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'></link>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous"></link>
        <title>Iniciar Sesión</title>
    </head>
    <body>
        <header>
            <section id="menu">
                <img class ="imagen_menu" value="images/Logo.png"/>
            </section>
        </header>
        <h1>INICIAR SESION</h1>
        <form action="ServletRegistro" method="POST">
            <table border="1">
                <tbody>
                    <tr><td>USUARIO</td> <td><input type="text" name="nombre" value=""/></td></tr>
                    <tr><td>CLAVE</td> <td><input type="text" name="apellido" value=""/></td></tr>
                    <tr><td colspan="2" align="center"><input type="submit" value="INICIAR SESION"/></td></tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
