#!/bin/sh

# warmup
# ab -n 100 -c 4 http://localhost:8081/examples/wall/first
# ab -n 100 -c 4 http://localhost:8081/examples/wall/second

./profiler.sh start -i 1ms -e wall -f first-wall.jfr first-application-0.0.1-SNAPSHOT.jar
ab -n 100 -c 4 http://localhost:8081/examples/wall/first
./profiler.sh stop -f first-wall.jfr first-application-0.0.1-SNAPSHOT.jar

./profiler.sh start -i 1ms -e wall -f second-wall.jfr first-application-0.0.1-SNAPSHOT.jar
ab -n 100 -c 4 http://localhost:8081/examples/wall/second
./profiler.sh stop -f second-wall.jfr first-application-0.0.1-SNAPSHOT.jar
