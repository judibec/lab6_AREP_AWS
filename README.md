# AREP_dockeraws

Creacion de un proyecto donde se hace uso de EC2 de AWS para ejecutar 3 servidores, una base de datos de mongo y un balanceador de carga cada uno por independiente

## Iniciando

### Prerequisitos

* Git: controlador de versiones y administrador de repositorio
* Java: Ambiente de desarrollo
* Maven: Administrador del ciclo de vida del proyecto
* AWS: Servicio de nube

### Funcionalidad

Aqui podemos ver cada EC2 corriendo por independiente

![image](https://user-images.githubusercontent.com/90010884/224425008-4339538e-06c7-4407-bf6a-9023d96fdec0.png)
![image](https://user-images.githubusercontent.com/90010884/224425010-96c7ef30-7f84-42de-8bfd-31d03f919802.png)
![image](https://user-images.githubusercontent.com/90010884/224425017-3efd8639-64e4-470e-858d-16d38e3f8bf3.png)
![image](https://user-images.githubusercontent.com/90010884/224425030-39f7c158-7258-4413-bb1f-1ecf9b0fbcc2.png)
![image](https://user-images.githubusercontent.com/90010884/224425061-44e6eba4-53f4-426f-877c-3c951235bf76.png)
![image](https://user-images.githubusercontent.com/90010884/224425077-bf155af6-000b-491e-b7de-c6dacfcd359d.png)

Aqui la implementacion de las instancias

![image](https://user-images.githubusercontent.com/90010884/224425107-1b150159-6b45-43aa-84ea-0e78c6551fc4.png)

y aqui el funcionamiento basico de la pagina
![image](https://user-images.githubusercontent.com/90010884/224425118-574e255e-9133-41ba-9914-3b95f8d59d87.png)

Todos los servidores estaban corriendo por el puerto 4567, el cual representa el de Spark

Se debe generar un target para cada EC2, el cual es el que se sube a AWS, y con el siguiente comando corremos cada servidor
```
java -cp ./classes:./dependency/* (y la ruta de donde esta el main)
```
## Construido Con

* [Maven](https://maven.apache.org/) - Administrador de dependencias

## Version

Version 1.0

## Autores

* **Juan Diego Becerra Peña**: [judibec](https://github.com/judibec)

## Descripcion Arquitectura

Se contruyo un servidor que se conectara a una base de datos de mongo, dicho servidor recibe un string y la DB almacena la entrada y la fecha en la que se hizo (como una especie de log) luego debe ser mostrada en pantalla esta respuesta, se generaron 3 instancias del servidor para asi crear un balanceador de carga de modo Round Robin asi puede realizar multiples peticiones sin que colapse el servicio. Cada servicio fue creado en un EC2 independiente de AWS
