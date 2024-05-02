FROM eclipse-temurin:21

RUN mkdir /opt/app
COPY /target/otus-hw.jar /opt/app/

ENTRYPOINT ["java", "-jar", "/opt/app/otus-hw.jar"]
