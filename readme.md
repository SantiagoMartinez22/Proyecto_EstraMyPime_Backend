# API para proyecto EstraMyPime con  (Java & Spring Boot)
## Descripcion:
El proyecto es una REST API que tiene como objetivo funcionar de forma integral con el frontend ya creado en angular 18 para el proyecto EstramyPime el cual es un proyecto de la universidad Eafit que busca que empresas pequeñas y medianas obtengan ayuda de expertos de esta universidad, la rest API cuenta con cruds para todas las entidades permitiendo crear guardar modificar e eliminar los datos guardados en una base de datos MySql

#### El sistema permite:
- Iniciar sesion y segun el rol(usuario o administrador) autorizar el acceso a su apartado en el frontend
- Crear Usuarios(empresas y personas naturales), actualizarlos, eliminarlos(por id) y obtenerlos(por  id).
- Crear administradores, actualizarlos, eliminarlos(por id) y obtenerlos(por id).
- Creacion de estudiantes y profesores, actualizarlos, eliminarlos y obtenerlos
- Creacion de test, tambien permitiendo obtenerlos, actualizarlos o eliminarlos 


## Tecnologías Utilizadas:


![Java 17](https://img.shields.io/badge/Java-17-red?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.3-green?style=for-the-badge&logo=spring)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-orange?style=for-the-badge&logo=apache-maven)
![Swagger](https://img.shields.io/badge/Swagger-API%20Documentation-green?style=for-the-badge&logo=swagger)
![MySQL Driver](https://img.shields.io/badge/MySQL%20Driver-JDBC%20Driver-blue?style=for-the-badge&logo=mysql)
![Lombok](https://img.shields.io/badge/Lombok-Java%20Library-green?style=for-the-badge&logo=lombok)


![JPA](https://img.shields.io/badge/JPA-Persistence%20API-blueviolet?style=for-the-badge&logo=jpa)

- **Java 17**: La aplicación está desarrollada en Java 17 como base del proyecto.

- **Spring Boot**: Utilizamos como framework Spring Boot para acelerar el desarrollo y simplificar el desarrollo

- **MySQL**: La base de datos de este proyecto utiliza MySQL para almacenar información.

- **Maven**: Maven se usa como herramienta de construccion y gestor de dependencias

- **Swagger**: para tener acceso a una documentacion descriptiva y facil de usar desde el navegador.

- **JPA (Java Persistence API)**: JPA se utiliza para interactuar con la base de datos de manera eficiente.

- **Postman**: Postman se utiliza para poder testear el API REST

# Instalación y Uso


1. Clonar el repositorio: `git clone https://github.com/SantiagoMartinez22/Proyecto_EstraMyPime_Backend.git`
2. Abra el proyecto de gestión de mensajería con su IDE preferido(Recomendado IntelliJ)
3. Configure el archivo application.properties en la ruta src/main/resources para conectarse a la base de datos Mysql, puede dejar la configuracion por defecto y configurarla a su necesidad(Contraseña, usuario y direccion a su BD)
4. Ejecute el archivo pom.xml para descargar las dependencias del proyecto, cargar las configuraciones y que empiece a compilarlo.
5. Ejecute el archivo BackendApplication para correr el programa.
6. Acceda a testear y usar la aplicacion desde Postman usando los endpoints que se pueden ver en los controllers 
7. Use la aplicacion desde swagger en su local  http://localhost:8080/swagger-ui/index.html#/

# Colecciones postman
https://www.postman.com/gold-escape-545722/estramypimegrupo3/folder/jzukjtx/teachers?action=share&creator=28945019&ctx=documentation
# Diagramas
#### Diagrama de arquitectura
![Diagrama de_arquitectura](https://github.com/SantiagoMartinez22/Proyecto_EstraMyPime_Backend/blob/development/architecture.png)

#### Diagrama de flujo detallado.
![Diagrama_de_flujo](https://github.com/SantiagoMartinez22/Proyecto_EstraMyPime_Backend/blob/development/architecture222.png)

## Contacto

Si tienes preguntas, comentarios o sugerencias sobre este proyecto, no dudes en ponerte en contacto.

