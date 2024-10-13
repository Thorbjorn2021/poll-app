FROM gradle:latest AS builder

COPY . .

RUN gradle bootJar

RUN mv build/libs/pollapp-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]