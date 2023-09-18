#!/bin/sh

/home/pasq/JDK/amazon-corretto-17.0.1.12.1-linux-x64/bin/java \
-Xms1G -Xmx1G -XX:+AlwaysPreTouch \
-jar /home/pasq/Plusat/IdeaProjects/Robocze/AsyncProfilerDemos/third-application/target/third-application-0.0.1-SNAPSHOT.jar
