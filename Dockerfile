FROM openjdk:8
VOLUME /tmp
EXPOSE 8008
ADD ./target/springboot-servicio-creditCard-0.0.1-SNAPSHOT.jar service-creditCard.jar
ENTRYPOINT ["java","-jar","/service-creditCard.jar"]
