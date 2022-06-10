FROM amazoncorretto:11-alpine-jdk
#
#WORKDIR /workspace/app
#COPY . /workspace/app
#RUN chmod +x ./gradlew
#RUN target=/root/.gradle ./gradlew clean bootJar
#RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*.jar)

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG DEPENDENCY=build/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.assignment.account_service.AccountServiceApplication"]