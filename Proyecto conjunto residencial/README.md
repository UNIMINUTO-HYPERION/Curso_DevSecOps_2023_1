<h1 align="center"> PLATAFORMA WEB CONJUNTO RESIDENCIAL SAUSALITO </h1>

<h1 align="center"> RESUMEN </h1>

La mayoría de los conjuntos residenciales cuentan con zonas de juegos, gimnasios, áreas verdes, sistemas de seguridad con token para el acceso, estacionamiento especial para visitantes, entre otros servicios. Sin embargo, en términos de administración, el conjunto se enfrenta a diversos problemas que afectan tanto al conjunto como a los inquilinos. Existen dificultades en la comunicación entre los administradores y los residentes, así como una gestión deficiente de la cartera y una falta de control en la administración de los estacionamientos, así como en la base de datos de inquilinos que tienen mascotas. Para abordar estos problemas, se propuso la implementación de una aplicación web que facilite la comunicación entre la administración y los residentes, y permita el control, seguimiento y recuperación de la cartera. 

El presente documento tiene como objetivo presentar cómo se llevó a cabo este proyecto, describiendo el objetivo, el alcance, las limitaciones y la metodología de desarrollo implementada, así como el desarrollo de cada una de las etapas. 

<h1 align="center"> INTRODUCCIÓN   </h1>

En el conjunto residencial sausalito, se presentan varios problemas de administración. La falta de organización de la información de los residentes, como el estado de cuenta del pago de la administración e informes sobre el uso de estos dineros, llevaba al no pago de estas obligaciones y a un aumento en la cartera por deudores morosos. Por otro lado podemos ver que los residentes tenían dificultades para acceder a cierta información como, por ejemplo, la programación y realización de actividades y reuniones, notificaciones sobre los eventos que se llevaban a cabo dentro del conjunto, notificaciones de pagos, inscripción de parqueaderos y mascotas residentes entre otros. Como solución a esta problemática se desarrolló una aplicación web con el fin de mejorar la gestión de la cartera y facilitar la comunicación entre la administración y los residentes.

La aplicación que se implementó funciona como servicios y le permite al administrador publicar de manera más fácil información relevante y de interés a los residentes, como la publicación de estados de cartera desde el modulo financiero, así tendra acceso a una base de datos con la información de los inquilinos, los parqueaderos con respectivos vehiculos y la tenencia de mascotas. Ellos a su vez, pueden interactuar con dicha información para tener una retroalimentación sobre la gestión que se realiza en el conjunto. La aplicación también, da la posibilidad a los administradores de conocer la cartera de los deudores, permitiendo enviar notificaciones indicando la fecha límite de pago, el saldo de la deuda, los intereses generados o cualquier otra información que sea de interés para un residente moroso.

## OBJETIVOS

<span style="color:blue">Objetivo general:</span>

Desarrollar una página web en lenguaje Java para el control de los pagos de una unidad residencial, con microservicios disponibles tanto para administradores como para residentes, que garantice la seguridad de la información y mejore significativamente la experiencia de los usuarios.

## Objetivos específicos:

Facilitar la comunicación: El objetivo principal de la plataforma es mejorar la comunicación entre los residentes, permitiéndoles interactuar, compartir información y mantenerse informados sobre eventos, noticias y anuncios relevantes.

Mejorar la experiencia del residente: La plataforma busca brindar una experiencia más conveniente y satisfactoria para los residentes, al ofrecerles servicios en línea, como reservas de áreas comunes, pagos de servicios, solicitudes de mantenimiento, entre otros.

Optimizar la gestión interna: La plataforma tiene como objetivo simplificar y optimizar los procesos de gestión interna del conjunto residencial, permitiendo una administración más eficiente de los recursos, como el control de acceso, la asignación de áreas comunes y la gestión de quejas y solicitudes.

Incrementar la transparencia: La plataforma busca promover la transparencia al proporcionar acceso a documentos importantes del conjunto residencial, como reglamentos, actas de asamblea y reportes financieros, de manera que los residentes puedan consultarlos fácilmente.
Fortalecer la comunidad: La plataforma tiene como objetivo fomentar la interacción y la creación de una comunidad sólida entre los residentes, facilitando la comunicación, la organización de eventos sociales y la colaboración en actividades comunitarias.

Mejorar la seguridad: La plataforma puede integrar sistemas de seguridad y seguimiento de incidencias para que los residentes puedan reportar situaciones de emergencia o incidencias de seguridad de manera rápida y efectiva, permitiendo una respuesta adecuada por parte de los encargados de seguridad.

Mejora en seguridad en datos: Implementar diferentes niveles de acceso a la plataforma para garantizar la seguridad de la información, permitiendo a los residentes acceder únicamente a su información de pago y a los administradores acceso a una base de datos con SQL.

Agilizar los procesos de reserva y pagos: La plataforma busca simplificar y agilizar los procesos de reserva de áreas comunes, servicios adicionales y pagos de servicios, eliminando la necesidad de trámites presenciales y facilitando la realización de estas actividades en línea.

Brindar acceso web: La plataforma puede estar diseñada para ser accesible desde dispositivos web, permitiendo que los residentes accedan y utilicen sus funciones desde cualquier lugar y en cualquier momento, mejorando la conveniencia y la accesibilidad.

Adaptarse a las necesidades del conjunto residencial: La plataforma busca ser flexible y adaptable, de manera que pueda satisfacer las necesidades específicas del conjunto residencial y permitir la incorporación de nuevas funcionalidades según sea necesario.

Optimizar el uso de recursos: La plataforma busca maximizar la eficiencia y el uso de los recursos disponibles en el conjunto residencial, ya sea mediante la implementación de estrategias de balanceo de carga, la optimización del consumo de recursos o la gestión centralizada de los contenedores.

Desarrollar diferentes microservicios, incluyendo el acceso a información sobre los pagos realizados, la generación de reportes, la configuración de las cuotas, y la caracterización de los residentes.


<h1 align="center"> METODOLOGIA </h1>

En este proyecto de programación en lenguaje Java, se busca desarrollar una página web orientada a un servicio de control de pagos de una unidad residencial. El objetivo principal es que los residentes puedan realizar el pago de sus cuotas de forma sencilla y eficiente, mientras que el administrador pueda llevar un registro de las mismas y llevar a cabo acciones de gestión.

Para ello, se implementarán diferentes microservicios que estarán disponibles tanto para el administrador como para los residentes. Entre ellos, se incluyen el acceso a información sobre los pagos realizados, la generación de reportes, la configuración de las cuotas, y la caracterización de cada residente (posee o no vehículo, cuenta o no con mascota) .

Para garantizar la seguridad de la información, se implementarán diferentes niveles de acceso a la plataforma. Los residentes tendrán acceso únicamente a su información de pago y a un sistema de pago en línea, mientras que el administrador tendrá acceso a una base de datos con SQL que le permitirá llevar un control más detallado.

En general, este proyecto de programación en lenguaje Java busca ofrecer una solución eficiente y segura para el control de pagos en una unidad residencial. Tanto residentes como administradores tendrán acceso a una plataforma intuitiva y fácil de usar, lo que mejorará significativamente la experiencia de los usuarios y facilitará la gestión de estas cuentas.

<h1 align="center"> PROCESO DE BACKEND </h1>

Gestor dividido en paquetes mediante el uso de una arquitectura orientada a servicios
1. Contratos: se establecen condiciones de uso mediante el uso del método aplicado a la clase
2. Controlador: mediante la implementación de método se hace el llamado e invocado de las caractreiticas especificadas en el modelo que proyecta el negocio
3. Modelo: implementación y caracterización de acciones o servicios (ejemplo: validación de usuario, vista para el rol administrador/residente, activación funcional segun roles).

<h1 align="center"> DIAGRAMA DE CASOS DE USO </h1>
<div align="center"><img src="https://github.com/jeison25/ProyectoDiplomado/blob/51867b50766b5982af0864779f5458e7e432b10c/Documentaci%C3%B3n/Diagrama_Casos%20de%20Uso_2.png"></div>

En el documento <A HREF="https://github.com/jeison25/ProyectoDiplomado/blob/d8f4fa570c785a02d018845d124f3baed5d814ad/Documentaci%C3%B3n/RF_RNF.docx"> RF_RNF.docx </A> encontrará la información de <strong>Requerimientos funcionales y no funcionales</strong>.

<h1 align="center"> DIAGRAMA DE COMPONENTES</h1>
<div align="center"><img src="https://github.com/jeison25/ProyectoDiplomado/blob/d9b84e2fef5bcbd9c5ae425b4e64cd89a4219753/Documentaci%C3%B3n/Diagrama%20de%20componentes.png"></div>

## CASOS DE USO

**Actores:**

1.	Residente: Usuario registrado en la plataforma web, que vive en el conjunto residencial.

2.	Administrador: Usuario con privilegios especiales encargado de gestionar la plataforma y la administración del conjunto residencial.

**Flujo del caso de uso:**

El residente accede a la plataforma web a través de su cuenta personal.

1.	Realizar pago de cuota:

1.1.	El residente accede a la plataforma, busca la opción de pago, ingresa los datos de su tarjeta de crédito o débito, y confirma la transacción. La plataforma debe validar la información de la tarjeta y realizar el cobro correspondiente.

2.	Ver información de pagos realizados:
2.2.	El residente accede a la plataforma, busca la sección correspondiente a la información de pagos realizados y selecciona el periodo que desea visualizar. La plataforma muestra los detalles de los pagos realizados, la fecha, el concepto y el importe abonado.
3.	Generar reportes:

3.1.	El administrador accede a la plataforma, selecciona la opción de generar reportes y elige el periodo que desea reportar. La plataforma genera un informe detallado de los pagos realizados en el periodo seleccionado, incluyendo información de cada residente y el estado de sus pagos.

3.2.	El residente puede solicitar servicios o reportar problemas relacionados con el conjunto, como mantenimiento de áreas comunes, reparaciones en su vivienda, solicitud de reservas de espacios, etc.

3.3.	El residente puede realizar seguimiento del estado de sus solicitudes a través de la plataforma, recibir notificaciones sobre su progreso y recibir actualizaciones una vez que hayan sido resueltas.

3.4.	La solicitud del residente se envía al administrador para su revisión y procesamiento.

3.5.	Los residentes pueden acceder a documentos y formularios importantes relacionados con el conjunto residencial, como reglamentos internos, contratos de arrendamiento o formularios de solicitud.

4.	Configuración de las cuotas:

4.1.	El administrador accede a la plataforma, selecciona la opción de configuración de cuotas y ajusta los parámetros requeridos. La plataforma actualiza el valor de las cuotas y realiza los cálculos correspondientes para los pagos futuros.

5.	Caracterización de los residentes:

5.1.	El administrador accede a la plataforma, busca la opción de caracterización de los residentes y agrega la información correspondiente, como la posesión de vehículo o mascota. La plataforma actualiza la información en la base de datos y la hace visible en la sección correspondiente.

5.2.	El administrador revisa y asigna la solicitud a los equipos correspondientes (mantenimiento, limpieza, vehículo o mascota etc.) para su ejecución.

5.3.	El administrador puede enviar comunicaciones masivas a los residentes, como recordatorios de pagos, anuncios importantes o convocatorias de asambleas.

5.4.	El residente puede solicitar servicios o reportar problemas relacionados con el conjunto, como mantenimiento de áreas comunes, reparaciones en su vivienda, solicitud de reservas de espacios, etc.

5.5.	Los residentes pueden utilizar la plataforma para comunicarse entre sí, a través de foros, grupos de discusión o mensajes privados, para discutir temas relacionados con el conjunto residencial.

6.	Acceso a base de datos SQL:

6.1.	El administrador accede a la plataforma, busca la opción de acceso a la base de datos SQL y realiza consultas para obtener información específica sobre los pagos realizados por cada residente. La plataforma muestra los datos solicitados de forma clara y organizada.

6.2.	El administrador puede generar informes y estadísticas sobre el uso de la plataforma, las solicitudes de servicio y otras métricas relevantes para la gestión del conjunto residencial.

Este caso de uso proporciona una visión general de cómo una plataforma web puede ser utilizada para facilitar la gestión de servicios y mejorar la comunicación en un conjunto residencial. Sin embargo, los detalles específicos y características adicionales dependerán de los requisitos y necesidades del conjunto residencial en particular.

<h1 align="center"> Diagrama Secuencia </h1>

<div align="center"><img src="https://github.com/jeison25/ProyectoDiplomado/blob/25bc449e797e27dd83ba7722f70df5bb81cd2f87/Documentaci%C3%B3n/diagrama.drawio%20(1).png"></div>


<div align="center"><img src="https://github.com/jeison25/ProyectoDiplomado/blob/daa45fa1850eb1d5036ee5732de9e1f9622c53f9/Documentaci%C3%B3n/diagrama.drawio.png"></div>


<div align="center"><img src="https://github.com/jeison25/ProyectoDiplomado/blob/b405ae3a5c529b0da4598472e16bfd32bd54accd/Documentaci%C3%B3n/diagrama%201.drawio.png"></div>


<h1 align="center"> DIAGRAMA DE DESPLIEGUE </h1>
<div align="center"><img src="https://github.com/jeison25/ProyectoDiplomado/blob/0e155c1709e8615e5edb02a5ffe785a8a5f57dd1/Documentaci%C3%B3n/Diagrama%20Despliegue-P%C3%A1gina-3.jpg"></div>

<h1 align="center"> DIAGRAMA DE CLASES </h1>

<div align="center"><img src="https://github.com/jeison25/ProyectoDiplomado/blob/0e155c1709e8615e5edb02a5ffe785a8a5f57dd1/Documentaci%C3%B3n/Diagrama%20de%20clases.jpg"></div>

# MANUAL DE DESPLIEGUE

1. Instalar Git en la maquina local.
2. Clonar este repositorio remoto en su máquina local:
   
   git clone https://github.com/jeison25/ProyectoDiplomado.git

2. Instalar docker desktop si no se tiene instalado. 
3. Crear una carpeta en Documentos llamada Cliente, en esta carpeta incluir el .jar todo el contenido que se encuentra en el repositorio local > ProyectoDiplomado > Servicios Proyecto > target
4. Ingresar a docker y descargar la imagen de openjdk:
   
   docker pull openjdk:8

5. Posteriormente descargar la imagen llamada jeisonmelvin/glassfish:
   
   docker pull jeisonmelvin/glassfish

6. Correr un contenedor con la imagen de jeisonmelvin/glassfish: 
   
   docker run -ti -p 4848:4848 -p 8080:8080 --name glassfish jeisonmelvin/glassfish

7. Una vez ejecutado el contenedor de glassfish, ejecutar los siguientes comandos: 
   
   export PATH=glassfish4/bin:$PATH
   asadmin start-domain
   
8. En un nuevo CMD correr un contenedor con la imagen de openjdk:
   
   docker run -dit --name servicios -v RUTA_LOCAL\Documents\Cliente:/home/proyecto openjdk:8 /bin/bash

9. Una vez ejecutado el contenedor de servicios instalar e iniciar mariadb: 
   apt-get install mariadb-server mariadb-client
   service mariadb start

10. Abrir un nuevo CMD y crear una red y adicionar estos contenedores a dicha red: 
    
    docker network create dist
    docker network connect dist servicios
    docker network connect dist glassfish

11. De nuevo en el contenedor de servicios ingresar a mysql (por defecto no tiene clave, se deja este espacio en blanco): 
    mysql -u root -p 
    
12. Crear la base de datos y las tablas: 
    
    CREATE DATABASE conjunto;
    USE conjunto;
    CREATE TABLE residentes (id_residente INT NOT NULL AUTO_INCREMENT, nombre varchar(500), apellido varchar(500), usuario varchar(500), clave varchar(500), bloque varchar(500), apto varchar(500), estado varchar(500), estado_res varchar(500), tipo_res varchar(500), intentos varchar(500), PRIMARY KEY(id_residente));
CREATE TABLE administradores(id_admon INT NOT NULL AUTO_INCREMENT, nombre varchar(500), apellido varchar(500),usuario varchar(500), clave varchar(500), PRIMARY KEY(id_admon));
CREATE TABLE vehiculos (id_vehiculo INT NOT NULL AUTO_INCREMENT,tipoVehiculo VARCHAR(500),placaVehiculo VARCHAR(500),marca VARCHAR(500), modelo VARCHAR(500), Noparqueadero varchar(500), bloque varchar(500), apto varchar(500), PRIMARY KEY(id_vehiculo));
CREATE TABLE mascotas (id_mascota INT NOT NULL AUTO_INCREMENT, tipoMascota varchar(500), nombreMascota varchar(500),edadMascota varchar(500), bloque varchar(500), apto varchar(500), PRIMARY KEY(id_mascota));
exit    

13. En el contenedor de servicios, ejecutar el .jar para ello introducir los comandos: 
    
    cd /home/proyecto
    java -jar ServiciosProyecto-1.0-SNAPSHOT.jar

14. Ingresar a localhost:4848 ingresar con usuario admin y clave admin, posteriormente subir el .war a glassfish en Applications > Upload a war (El .war se encuentra en la ruta repositorio local/ProyectoDiplomado/ProyectoConjunto/target)

15. Una vez cargado el war al servidor de aplicaciones, ingresar a la url localhost:8080/ProyectoConjunto-1.0-SNAPSHOT
16. El usuario inicial como administrador es jeison y la clave es 1234. 
<h1 align="center"> Conclusiones: </h1>

1.	Eficiencia en el despliegue: La utilización de contenedores permite un despliegue rápido y eficiente de la plataforma web en el entorno del conjunto residencial. 

2.	Escalabilidad: Los contenedores ofrecen la capacidad de escalar la plataforma web de manera horizontal, permitiendo manejar el crecimiento y la demanda del conjunto residencial sin problemas. 

3.	Aislamiento de componentes: Los contenedores proporcionan un entorno aislado para cada componente de la plataforma web, lo que aumenta la seguridad y evita interferencias entre diferentes partes del sistema. 

4.	Mantenimiento sencillo: Los contenedores facilitan la actualización y el mantenimiento de la plataforma web, ya que permiten la implementación de cambios de manera modular y sin interrupciones en otros componentes. 

5.	Portabilidad: Los contenedores ofrecen una alta portabilidad, lo que significa que la plataforma web puede ejecutarse de manera consistente en diferentes entornos, independientemente del sistema operativo o la infraestructura subyacente. 

6.	Modularidad y flexibilidad: Al utilizar contenedores, es posible descomponer la plataforma web en módulos independientes, lo que facilita la adición o eliminación de funcionalidades según las necesidades del conjunto residencial. 

7.	Balanceo de carga: Los contenedores permiten implementar estrategias de balanceo de carga, distribuyendo las solicitudes de los usuarios entre varios contenedores para mejorar el rendimiento y la disponibilidad de la plataforma web. 

8.	Facilidad de replicación: La replicación de contenedores es sencilla, lo que garantiza la disponibilidad continua de la plataforma web incluso en caso de fallos o mantenimiento en algún contenedor específico. 

9.	Gestión centralizada: Mediante el uso de herramientas de orquestación de contenedores, es posible gestionar y controlar todos los contenedores de la plataforma web desde una ubicación central, simplificando la administración del conjunto residencial. 

10.	Optimización de recursos: Los contenedores permiten una mejor utilización de los recursos de hardware disponibles, ya que se pueden compartir entre varios contenedores, maximizando así el rendimiento y la eficiencia de la plataforma web. 
Estas conclusiones destacan las ventajas clave de utilizar contenedores para desarrollar una plataforma web en un conjunto residencial, brindando eficiencia, escalabilidad, flexibilidad y una gestión simplificada.


# URL DOCKER HUB https://hub.docker.com/r/jeisonmelvin/glassfish

