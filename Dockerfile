FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY target/linqia-oa-0.0.1-SNAPSHOT.jar app.jar
COPY Keywords.mv.db .
ENTRYPOINT ["java","-jar","/app.jar"]