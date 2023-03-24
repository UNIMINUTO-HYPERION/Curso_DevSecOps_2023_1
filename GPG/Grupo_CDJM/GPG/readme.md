# CDJM Group

Grupo de trabajo conformado por:

- Michelle Parra 😎
- Diego Conde 😁
- Javier Varón 😉
- Camila Loaiza 😊


## Encriptación Asimétrica con gpg generación de llaves pública y privada.

<p align="center"><img src="https://raw.githubusercontent.com/UNIMINUTO-HYPERION/Curso_DevSecOps_2023_1/main/GPG/Grupo_CDJM/GPG/im%C3%A1genes/001.png" alt="branch" width="600"/></p>

Es una herramienta de cifrado y firmas digitales desarrollado por Werner Koch, que viene a ser un reemplazo del PGP pero con la principal diferencia que es software libre licenciado bajo la GPL. GPG cumple el estándar RFC 4880 del IETF denominado OpenPGP.

### Sistemas operativos compatibles

- Ubuntu/Debian
- Windows
- CentOS
- MacOS
- Windows

### Instalación de GPG

La instalación de GPG puede variar dependiendo del sistema operativo o distribución que se esté utilizando. A continuación se listan algunas instrucciones generales para los sistemas operativos más comunes:

- **Ubuntu/Debian:** Para instalar GPG en Ubuntu o Debian, se debe abrir una terminal y ejecutar el siguiente comando:

```bash
sudo apt-get install gnupg
```

- **Fedora/RHEL:** En Fedora o Red Hat Enterprise Linux (RHEL), se puede instalar GPG con el siguiente comando:

```bash
gpg --full-gen-key
```

Para generar una llave, se necesita el siguiente comando:

```bash
gpg --full-gen-key
```

Este comando preguntara con que tipo de encriptación se quiere  encriptar la llave:

<p align="center"><img src="https://raw.githubusercontent.com/UNIMINUTO-HYPERION/Curso_DevSecOps_2023_1/main/GPG/Grupo_CDJM/GPG/im%C3%A1genes/002.png" alt="branch" width="600"/></p>

Realizará la pregunta de cuántos bits de largo se quiere que sea la encriptación.

<p align="center"><img src="https://raw.githubusercontent.com/UNIMINUTO-HYPERION/Curso_DevSecOps_2023_1/main/GPG/Grupo_CDJM/GPG/im%C3%A1genes/003.png" alt="branch" width="600"/></p>

Nos preguntará en cuanto tiempo se desea que expire la llave para ya no ser validada.

<p align="center"><img src="https://raw.githubusercontent.com/UNIMINUTO-HYPERION/Curso_DevSecOps_2023_1/main/GPG/Grupo_CDJM/GPG/im%C3%A1genes/004.png" alt="branch" width="600"/></p>

Luego de haber confirmado la expiración, se  pedirá que construya un id a la llave con las características de: nombre, correo y comentario.

<p align="center"><img src="https://raw.githubusercontent.com/UNIMINUTO-HYPERION/Curso_DevSecOps_2023_1/main/GPG/Grupo_CDJM/GPG/im%C3%A1genes/005.png" alt="branch" width="600"/></p>

Pedirá que se asigne una contraseña para proteger la clave.

<p align="center"><img src="https://raw.githubusercontent.com/UNIMINUTO-HYPERION/Curso_DevSecOps_2023_1/main/GPG/Grupo_CDJM/GPG/im%C3%A1genes/006.png" alt="branch" width="600"/></p>

Este comando arrojara las llaves que se han creado con su debido identificador, como se muestra en la siguiente imagen:

```bash
gpg  - - list keys
```
<p align="center"><img src="https://raw.githubusercontent.com/UNIMINUTO-HYPERION/Curso_DevSecOps_2023_1/main/GPG/Grupo_CDJM/GPG/im%C3%A1genes/007.png" alt="branch" width="600"/></p>

Se ingresará el siguiente comando para guardar en la base de datos la clave.

```bash
Gpg  - - keyserver hkp://pgp.mit.edu - - s
```

<p align="center"><img src="https://raw.githubusercontent.com/UNIMINUTO-HYPERION/Curso_DevSecOps_2023_1/main/GPG/Grupo_CDJM/GPG/im%C3%A1genes/008.png" alt="branch" width="600"/></p>

Ingrese al siguiente link para realizar la verificación de si la clave se guardó.

[Pgp.mit.edu](Pgp.mit.edu)

En la parte de search string escriba el correo con el que lo registro.

<p align="center"><img src="https://raw.githubusercontent.com/UNIMINUTO-HYPERION/Curso_DevSecOps_2023_1/main/GPG/Grupo_CDJM/GPG/im%C3%A1genes/009.png" alt="branch" width="600"/></p>

Aparecerá el resultado de esta manera.

<p align="center"><img src="https://raw.githubusercontent.com/UNIMINUTO-HYPERION/Curso_DevSecOps_2023_1/main/GPG/Grupo_CDJM/GPG/im%C3%A1genes/010.png" alt="branch" width="600"/></p>

Utilizaremos el comando  para realizar.

```bash
Gpg  - - keyserver hkp://pgp.mit.edu - - send-keys “id de la llave”

Gpg – keyserver pgp.mit.edu –recv “inserte el Keyid”
```

<p align="center"><img src="https://raw.githubusercontent.com/UNIMINUTO-HYPERION/Curso_DevSecOps_2023_1/main/GPG/Grupo_CDJM/GPG/im%C3%A1genes/011.png" alt="branch" width="600"/></p>