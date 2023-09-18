#!/bin/sh

/home/pasq/JDK/amazon-corretto-17.0.1.12.1-linux-x64/bin/java \
-Xms4G -Xmx4G -XX:+AlwaysPreTouch \
-XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints \
-Duser.language=en-US \
-jar /home/pasq/Plusat/IdeaProjects/Robocze/AsyncProfilerDemos/first-application/target/first-application-0.0.1-SNAPSHOT.jar 
