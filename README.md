# EoloPlanner

Este proyecto es una aplicación distribuida formada por diferentes servicios que se comunican entre sí usando API REST, gRPC y RabbitMQ. La aplicación ofrece un interfaz web que se comunica con el servidor con API REST y WebSockets. 

Algunos servicios están implementados con Node.js/Express y otros con Java/Spring. Estas tecnologías deben estar instaladas en el host para poder construir y ejecutar los servicios. También se requiere Docker para ejecutar los servicios auxiliares (MySQL, MongoDB y RabbitMQ).

Para la construcción de los servicios y su ejecución, así como la ejecución de los servicios auxiliares requeridos se usan scripts implementados en Node.js. Posiblemente no sea el lenguaje de scripting más utilizado para este caso de uso, pero en este caso concreto facilita la interoperabilidad en varios SOs y es sencillo.

Esta solución está basada en el trabajo entregado por el alumno Miguel García Sanguino.

## Iniciar servicios auxiliares: MongoDB, MySQL y RabbitMQ

Los servicios auxiliares se ejecutan con la tecnología de contenedores Docker usando el siguiente comando.
Las variables de entorno están definidas en el fichero .env de la carpeta /dev

```
$ docker-compose -f dev/docker-compose.yml up -d
```

## Construir y publicar imágenes

Es necesario cambiar la variable DOCKERHUBNAME dentro del script para apuntar al repositorio de DockerHub del usuario.

Si sólo se desea construir las imágenes

```
$ ./build.sh
```

Construir y publicar las imágenes que se generan

```
$ ./build.sh push
```

## Desplegar servicios auxiliares + aplicaciones

Las variables de entorno están definidas en el fichero .env de la carpeta /prod

```
$ docker-compose -f prod/docker-compose.yml up -d
```