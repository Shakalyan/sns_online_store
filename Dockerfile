FROM openjdk:17

COPY ./target/online_store-0.0.1-SNAPSHOT.jar /

ENTRYPOINT ["java", "-jar", "./online_store-0.0.1-SNAPSHOT.jar"]