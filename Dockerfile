FROM openjdk:8-jre

COPY ./build/libs/HalfBot-1.0-all.jar /bin/runner/run.jar
WORKDIR /bin/runner

CMD ["java", "-jar", "run.jar"]