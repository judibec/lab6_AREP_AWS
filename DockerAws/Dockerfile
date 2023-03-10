FROM openjdk:8

WORKDIR /usrapp/bin

ENV PORT 6000
#ENV PORT1 7000

COPY /target/classes /usrapp/bin/classes
COPY /target/dependency /usrapp/bin/dependency
#COPY start.sh /usrapp/bin/start.sh

#CMD ["bash", "/usrapp/bin/start.sh"]

CMD ["java","-cp","./classes:./dependency/*","co.edu.escuelaing.arep.SparkWebServer"]
#CMD ["java","-cp","./classes:./dependency/*","co.edu.escuelaing.arep.SparkLogsServer"]