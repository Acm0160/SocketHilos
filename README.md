Práctica PSP – Servidor de Chat Concurrente en Java
Descripción

Este proyecto implementa un servidor de chat cliente-servidor en Java utilizando Sockets, Streams y Threads.
El desarrollo se ha realizado de forma incremental en cuatro fases, partiendo de una comunicación básica hasta llegar a un servidor multicliente concurrente.

Tecnologías utilizadas

Java

Sockets (ServerSocket, Socket)

Streams (DataInputStream, DataOutputStream)

Threads (Runnable, Thread)

IO y manejo de excepciones

Fases del desarrollo
Fase 1 – Comunicación básica (One-Shot)

En esta fase se implementa una comunicación simple entre cliente y servidor.

El cliente se conecta al servidor.

Envía un único mensaje.

El servidor recibe el mensaje y responde.

La conexión se cierra inmediatamente.

Esta fase sirve para entender el funcionamiento básico de los sockets y los flujos de datos, pero el servidor es bloqueante y solo atiende a un cliente a la vez.

Fase 2 – Comunicación continua

En esta fase se mejora la comunicación para que sea persistente.

Cliente y servidor intercambian múltiples mensajes.

Se utiliza un bucle en ambos lados.

La conversación solo termina cuando el cliente envía la palabra FIN.

Aquí se introduce el concepto de protocolo de finalización y una comunicación más realista.

Fase 3 – Servidor multihilo

En esta fase se resuelve el problema de bloqueo del servidor.

Se crea la clase GestorCliente, que implementa Runnable.

Cada cliente es atendido en un hilo independiente.

El servidor principal solo acepta conexiones y lanza hilos.

Esto permite que el servidor atienda varios clientes al mismo tiempo sin bloquearse.

Fase 4 – Mejoras y robustez

En la última fase se añaden mejoras profesionales:

Identificación de clientes mediante su dirección IP.

Manejo de desconexiones inesperadas (EOFException, IOException).

Mensajes de log más claros en el servidor.

Mayor robustez del sistema.

El servidor ya es un chat concurrente funcional y estable.

Ejecución del proyecto

Ejecutar primero la clase:

server


Ejecutar una o varias instancias de:

cliente


Escribir mensajes desde el cliente.

Para cerrar la conexión, escribir:

FIN

📂 Estructura del proyecto
📁 src
 ├── cliente.java
 ├── server.java
 └── GestorCliente.java
