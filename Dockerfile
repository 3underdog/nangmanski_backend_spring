# FROM openjdk:17-jdk

# WORKDIR /
# COPY ./build/libs/nangmanski_backend_spring-0.0.1-SNAPSHOT.jar app.jar
# CMD java -jar /app.jar


# 빌드 스테이지
FROM gradle:8.3.0-jdk17 AS builder	
WORKDIR /
COPY . .	
# RUN microdnf install findutils
RUN chmod +x ./gradlew && ./gradlew clean build

# 실행 스테이지
FROM openjdk:17-jdk	
COPY --from=builder /build/libs/*.jar app.jar	
ENTRYPOINT ["java", "-jar", "/app.jar"]