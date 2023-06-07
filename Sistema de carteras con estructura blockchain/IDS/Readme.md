
# <a name="Pruebas de las reglas de Snort"></a><a name="_bookmark6"></a>Pruebas de las reglas de Snort

## <a name="1. Detección de escaneo de puertos TCP SYN:"></a><a name="_bookmark9"></a>1. Detección de escaneo de puertos TCP SYN:

Método de escaneo: Envía paquetes SYN al objetivo y espera respuestas SYN/ACK.
Propósito: Determinar puertos abiertos en un objetivo.
Indicadores de detección: Múltiples intentos de escaneo de puertos TCP SYN.

## 2. Detección de escaneo de puertos TCP ACK:

Método de escaneo: Envía paquetes ACK al puerto objetivo y analiza las respuestas.
Propósito: Determinar si un puerto está filtrado por un firewall.
Indicadores de detección: Múltiples escaneos de puertos TCP ACK.

## 3. Detección de escaneo de puertos TCP FIN:

Método de escaneo: Envía paquetes FIN al puerto objetivo y analiza las respuestas.
Propósito: Identificar puertos abiertos o cerrados en un objetivo.
Indicadores de detección: Múltiples intentos de escaneo de puertos TCP FIN.

## 4. Detección de escaneo de puertos TCP Xmas:

Método de escaneo: Envía paquetes TCP con las banderas FIN, PSH y URG activadas al puerto objetivo.
Propósito: Identificar puertos abiertos o cerrados en un objetivo.
Indicadores de detección: Múltiples intentos de escaneo de puertos TCP Xmas.

## Panel Principal

![image](https://github.com/UNIMINUTO-HYPERION/Curso_DevSecOps_2023_1/assets/86531789/b2e6096e-2b71-43a5-b827-d2349ca33679)

## Eventos del sensor

![image](https://github.com/UNIMINUTO-HYPERION/Curso_DevSecOps_2023_1/assets/86531789/f63df06e-059a-49b2-beb6-1748685ca193)

## Listado de ataques realizados por Nmap

![image](https://github.com/UNIMINUTO-HYPERION/Curso_DevSecOps_2023_1/assets/86531789/efee181d-8522-452e-99e4-217851c7414c)

## Logs en la consola de windows

![image](https://github.com/UNIMINUTO-HYPERION/Curso_DevSecOps_2023_1/assets/86531789/b889c662-496c-429d-86f7-e9a096da7701)

## Logs Consola del docker
![image](https://github.com/UNIMINUTO-HYPERION/Curso_DevSecOps_2023_1/assets/86531789/54e61512-c457-4440-a9e9-383f87a759cd)


