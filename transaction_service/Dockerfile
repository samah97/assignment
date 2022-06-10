#FROM gradle:7.4.1-jdk11-alpine AS build
#COPY --chown=gradle:gradle . /home/gradle/src
#WORKDIR /home/gradle/src
#RUN gradle build --no-daemon
FROM amazoncorretto:11-alpine-jdk
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
ARG DEPENDENCY=build/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.assignment.transaction_service.TransactionServiceApplication"]