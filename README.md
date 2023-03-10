# AREP_dockeraws

Creacion de un proyecto donde se hace uso de contenedores en Docker y se realiza el despliegue respectivo en AWS, el objetivo de esta es crear un balanceador de carga que se conecta a 3 servidores

## Iniciando

### Prerequisitos

* Git: controlador de versiones y administrador de repositorio
* Java: Ambiente de desarrollo
* Maven: Administrador del ciclo de vida del proyecto
* Docker: Gestionador de contenedores
* AWS: Servicio de nube

### Funcionalidad

![image](https://user-images.githubusercontent.com/90010884/224425008-4339538e-06c7-4407-bf6a-9023d96fdec0.png)
![image](https://user-images.githubusercontent.com/90010884/224425010-96c7ef30-7f84-42de-8bfd-31d03f919802.png)
![image](https://user-images.githubusercontent.com/90010884/224425017-3efd8639-64e4-470e-858d-16d38e3f8bf3.png)
![image](https://user-images.githubusercontent.com/90010884/224425030-39f7c158-7258-4413-bb1f-1ecf9b0fbcc2.png)
![image](https://user-images.githubusercontent.com/90010884/224425061-44e6eba4-53f4-426f-877c-3c951235bf76.png)
![image](https://user-images.githubusercontent.com/90010884/224425077-bf155af6-000b-491e-b7de-c6dacfcd359d.png)
![image](https://user-images.githubusercontent.com/90010884/224425107-1b150159-6b45-43aa-84ea-0e78c6551fc4.png)
![image](https://user-images.githubusercontent.com/90010884/224425118-574e255e-9133-41ba-9914-3b95f8d59d87.png)


Entramos a este link http://ec2-52-91-101-195.compute-1.amazonaws.com:45000 alli nos aparecera un cuadro de texto 

![image](https://user-images.githubusercontent.com/90010884/224193745-06b0ce50-3bee-4da3-906b-60d5c4002642.png)

podemos ingresar la cadena que queramos y le damos a submit, despues de esto la base de datos entregara la respuesta de las ultimas 10 entradas en forma de JSON 

![image](https://user-images.githubusercontent.com/90010884/224197260-95fd4b34-92e0-4cc5-8aeb-b77484eee9c0.png)

De esta manera se crearon las imagenes en AWS, especificando el puerto por el cual van a funcionar

```
docker run -d -p puerto:6000 --name <nombre_imagen_aws> <usuario_repo>/<nombre_repo>
```

![image](https://user-images.githubusercontent.com/90010884/224197406-416e885b-a95f-4fa4-90b3-7c2b4b9a78f8.png)

En este caso el balanceador esta en el puerto 45000, y los servidores estan en el 42000,42001,42002

Para cada servidor y para el balanceador se creo su respectivo contenedor los cuales podemos ver en el docker desktop 

![image](https://user-images.githubusercontent.com/90010884/224197742-3ee9ae5d-729f-484f-ad60-0f443ef0fc7f.png)

Y asi se ven en AWS

![image](https://user-images.githubusercontent.com/90010884/224198024-6ada1955-e5d1-4244-a2af-30ce06baf837.png)


## Construido Con

* [Maven](https://maven.apache.org/) - Administrador de dependencias
* [Docker](https://www.docker.com) - Administrador de contenedores

## Version

Version 1.0

## Autores

* **Juan Diego Becerra Peña**: [judibec](https://github.com/judibec)

## Descripcion Arquitectura

Se contruyo un servidor que se conectara a una base de datos de mongo, dicho servidor recibe un string y la DB almacena la entrada y la fecha en la que se hizo (como una especie de log) luego debe ser mostrada en pantalla esta respuesta, se generaron 3 instancias del servidor para asi crear un balanceador de carga de modo Round Robin asi puede realizar multiples peticiones sin que colapse el servicio. Todo esto se almaceno en contenedores y fueron desplegados en AWS
