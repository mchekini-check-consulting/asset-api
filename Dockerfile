FROM ubuntu
RUN apt-get update && apt-get install openjdk-17-jdk vim curl -y
WORKDIR /opt
ADD target/asset-api-*.jar asset-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "asset-api.jar"]