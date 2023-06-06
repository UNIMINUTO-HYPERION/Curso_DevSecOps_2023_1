# Sistema de carteras con estructura blockchain

Api Block Chain

¡Bienvenido a la introducción de una API desarrollada en Python para realizar transacciones teniendo en cuenta los bloques de un blockchain!

En esta introducción, se mostrara los conceptos básicos de un blockchain y como se puede utilizar una API en Python para realizar transacciones seguras y confiables.

¿Qué es un blockchain?

Un blockchain es una estructura de datos descentralizada y distribuida que registra transacciones de manera segura y transparente. Consiste en una cadena de bloques enlazados, donde cada bloque contiene un conjunto de transacciones verificadas y un hash único que lo identifica. Los bloques se agregan secuencialmente a la cadena, formando un registro inmutable y resistente a la modificación.

La API de transacciones blockchain en Python

La API de transacciones blockchain en Python que se desarrollo proporcionará una interfaz para crear y transmitir transacciones. Aquí hay una descripción general de las funcionalidades principales que abordaremos:

Creación de transacciones: Permitirá a los usuarios crear una nueva transacción proporcionando información como la dirección del remitente, la dirección del destinatario y el monto de la transacción.

Validación de transacciones: La API verificará la validez de una transacción utilizando reglas específicas, como verificar que el remitente tenga fondos suficientes para cubrir el monto de la transacción y que la firma digital sea válida.

Construcción de bloques: Una vez que una transacción ha sido validada, se agregará a un bloque junto con otras transacciones pendientes. El bloque se construira de acuerdo a una serie de reglas del blockchain, donde por cada 3 transacciones se genera un nuevo bloque y el anterior se cierra generando su firma.

Consulta de la cadena de bloques: La API proporcionará métodos para acceder a información sobre la cadena de bloques, como obtener el historial de transacciones que ha realizado un identificando que saldo fue a favor y que no.

# Documentación proyecto
La documentación del proyecto en general la puedes encontrar en: [documentación](https://github.com/mninoquitian/Proyecto-Diplomado/tree/master/Documentacion)

# Requisitos previos

Para poder compilar localmente este proyecto debe tener previamente instalado python.

Primero clone el proyecto: `https://github.com/miguelangel6969/Diplomado-Backend.git`

Se recomienda crear un ambiente virtual de python:

`python -m venv nombre_del_ambiente`

Luego de tener el ambiente se deberan instalar las librerias las cuales se encuentran en el archivo de requerimientos el cual se encuentra en la ruta: `app/requirements.` Para ejecutar este se debera de poner el siguiente código:

`pip install -r requirements.txt`

Esto instalara todas las librerias las cuales necesita la aplicación. Si no se quiere crear un entorno virtual se deberan instalar las librerias de igual forma.

# Estructura del proyecto

`/app:` Contiene el código fuente y demás carpetas del proyecto
 - `app.py:` Archivo principal proyecto. en el cual se hace la configuración del mismo y se ejecuta.
 - `security.py:` Contiene metodos para validar usuarios y así generar token JWT

`/app/src:` contiene distribución de carpetas para la distibución de código.
  - `../models:` Se crean archivos .py con clases para realizar operaciones de búsqueda, guardado y eliminación en modelos SQLAlchemy
  - `../routes:` Se crean archivos .py con la logica de los servicios a utilizar con sus respectivas rutas
  - `../routes:` Se crean archivos .py con clases que se utilizan para definir un esquema de serialización y deserialización para los modelos
  - `../settings:`  se definen varios atributos de la clase que representan diferentes variables de entorno obtenidas del archivo .env. Estas variables de entorno incluyen configuraciones relacionadas con tokens JWT, configuraciones de base de datos, configuraciones de SQLAlchemy, modo de depuración, clave secreta JWT y otros
  - `db.py:` Se utiliza posteriormente para interactuar con la base de datos, realizar consultas y manipular objetos de modelo.

# Despliegue mediante Docker

- Ubiquese en la ruta `/app`
- Verifique su conexión a internet
- Verifique tener instalado docker en Su maquina. En caso de no tenerlo instalado, se debera instalar; se recomienda seguir la guía de isntalación de: [documentación](https://docs.docker.com/desktop/install/windows-install/)
- corra el siguiente comando `docker compose up` esto se encargara de bajar las imagenes requeridas y de crear una red para estas. Una vez haya creado los debidos contenedores de las imagenes pondra a correr estos mismos y podra interactuar con la app.
