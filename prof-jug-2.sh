#!/bin/sh

# execute it once
curl -v http://localhost:8081/examples/cpu/prepare

# little warmup
ab -n 2 -c 1 http://localhost:8081/examples/cpu/inverse

# profiling time:
./profiler.sh start -e cpu -f cpu.jfr first-application-0.0.1-SNAPSHOT.jar
ab -n 5 -c 1 http://localhost:8081/examples/cpu/inverse
./profiler.sh stop -f cpu.jfr first-application-0.0.1-SNAPSHOT.jar

