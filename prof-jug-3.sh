#!/bin/sh

# little warmup
# ab -n 2 -c 1 http://localhost:8081/examples/alloc/ > /dev/null

# measuring the heap allocations of a request
# jcmd first-application-0.0.1-SNAPSHOT.jar GC.run
# jcmd first-application-0.0.1-SNAPSHOT.jar GC.heap_info
# ab -n 10 -c 1 http://localhost:8081/examples/alloc/ > /dev/null
# jcmd first-application-0.0.1-SNAPSHOT.jar GC.heap_info

# profiling time
./profiler.sh start -e alloc -f alloc.jfr first-application-0.0.1-SNAPSHOT.jar
ab -n 1000 -c 1 http://localhost:8081/examples/alloc/
./profiler.sh stop -f alloc.jfr first-application-0.0.1-SNAPSHOT.jar

