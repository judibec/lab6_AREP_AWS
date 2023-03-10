#!/bin/bash

java -Dfork=true -cp ./classes:./dependency/* co.edu.escuelaing.arep.SparkWebServer &
java -Dfork=true -cp ./classes:./dependency/* co.edu.escuelaing.arep.SparkLogsServer