
# Supermercado Antojitos

  

La siguiente es una aplicación para realizar el seguimiento de los productos del **Supermercado Antojitos**, con el fin de controlar los productos que ingresar y restarlos al momento de realizar una venta.

  
  

# Tecnologías Utilizadas

Para la aplicación se propone utilizar una arquitectura orientada a micro servicios, con el fin de independizar el Cliente (FrontEnd) y el Servidor (BackEnd). Lo anterior en busca de cumplir con drivers de arquitectura como la matenibilidad y escalabilidad de la aplicación a largo plazo, y que este modelo sea replicado para otras iniciativas.

  

- Angular 9

- Bootstrap 4

- Spring Boot (JPA+Hibernate+WebMVC)

- Base de datos en Memoria H2

  

## ¿Como correr la aplicación?

  Descargar el repositorio GitHUB, el cual contiene dos carpetas y el script de base de datos incial. Utilizar el siguiente comando para clonar el repositorio de GitHUB.

  ```
  git clone https://github.com/julianosorio17/tienda-app.git
  ```

### Carpeta tienda-bk
Corresponde a la carpeta que contiene el backend de la aplicacion. Para ejecutar el backend desde la consola, ingresar a la carpeta y ejecutar el siguiente comando.
```
  mvn clean
  mvn package
  mvn spring-boot:run
  ```

### Ejecutar Script de Base de datos
La aplicacion utiliza una base d e datos en memorua H2. Una vez el backen se este ejecutando, se debe ingresar a la URL [http://localhost:8080/h2-console](http://localhost:8080/h2-console) y dar clic en el boton Connect, ya que la consola de H2 esta configurada sin contraseña. 

Copiar y pegar el contenido del script sql adjunto y ejecutarlo en la consola de H2.

### Carpeta tienda-client
Corresponde al cliente o FrontEnd de la aplicacion, desarrollado en Angular 9. Ingresar a la carpeta y desde una consola o linea de comando ejecutar los siguientes comandos:
```
npm i
ng serve -o
```
Automaticamente la aplicacion se abrira en el navegador por defecto. Caso que no pase lo anterior, ingresar a la URL [http://localhost:4200/](http://localhost:4200/)
