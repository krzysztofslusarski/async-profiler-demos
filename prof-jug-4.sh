#!/bin/sh

./profiler.sh start -e wall -f actuator.jfr first-application-0.0.1-SNAPSHOT.jar
ab -n 1000 http://192.168.50.241:8081/actuator/health # check your IP
./profiler.sh stop -f actuator.jfr first-application-0.0.1-SNAPSHOT.jar

