# Microservicios CRUD Cuentas bancarias

Servicio REST hecho con SpringBoot/java con las operaciones basicas (CRUD) consulta/actualizacion/borrado de cuentas bancaria, securizadas con el modulo Spring security

## Comenzando 🚀

La base de datos utilizada es Mysql. 

En el paquete sql se encuentra el script para crear la tabla y un par de cuentas de prueba.

para crear un usuario se puede lanzar el test unitario  ApplicationTest.java

Mira **instalacion** para conocer como desplegar mysql y PHPMyadmin con docker.


### Pre-requisitos 📋

Es necesario tener docker instalado

```
sudo apt update
sudo apt install docker-ce


```

### Instalación 🔧

1 levanta mySQL y phpoMyAdmin con docker ve a la carpeta del proyecto y ejecuta

```
docker-compose up
```

2 Descarga las librerias con botón derecho en pom.xml/Maven/Update Project

3 levanta el tomcat o lo que uses con la aplicacion


* [Java](https://www.oracle.com/es/java/technologies/javase/javase-jdk8-downloads.html) - El lenguaje de programación
* [SpringBoot](https://spring.io/) - El framework web usado
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Docker](https://www.docker.com/) - Gestor de contenedores
* [PCOLINA](https://pcolina.github.io/) - Usado para generar RSS
