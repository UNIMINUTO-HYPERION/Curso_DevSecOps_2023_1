## Chat interno empresarial

Implementación de un sistema de comunicación vía texto tipo chat que permita a los integrantes de una compañía comunicarse entre sí haciendo uso de las redes internas de la misma por medio de una interfaz gráfica amigable, esto para mitigar fugas de información vía internet. 

<p align="center"><img src="https://github.com/adrianaLoaiza/internalChat/blob/main/user_service/user/static/img/arquitectura.png" alt="arquitectura" width="600"/></p>

## Funcionalidades
 
-	Comunicar a los empleados de la compañía entre sí, por medio de mensajes de texto vía chat, una vez hayan iniciado sesión en el sistema.
-	Los empleados pueden registrarse en el chat de la empresa en caso de no tener cuenta en el sistema.
-	Manejo de roles.
- **Administrador:** Encargado de administrar las bases de datos mediante la interfaz de administrador de Django; puede agregar o eliminar tanto usuarios como grupos de chat en el sistema.
- **Empleado:** Es quien interactúa en la aplicación con otros empleados vía texto.
- Proveer una interfaz gráfica para ver los mensajes enviados.
- Visualizar cuando un usuario se encuentra en línea o ausente.
- Los servicios de chat y manejo de usuarios se realizan por medio de microservicios que utilicen la misma base de datos.
- Crear grupos de usuarios donde podrán manejar temas exclusivos por equipos.
