FROM openjdk:17-jdk

WORKDIR /
COPY ./build/libs/nangmanski_backend_spring-0.0.1-SNAPSHOT.jar app.jar
CMD java -jar /app.jar