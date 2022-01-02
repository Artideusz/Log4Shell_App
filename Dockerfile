FROM openjdk:8u121-alpine


COPY ./src/ /opt/java_app/src/
COPY ./pom.xml /opt/java_app/pom.xml

RUN apk update
RUN apk add maven

WORKDIR /opt/java_app/
RUN mvn clean package compile assembly:single

COPY ./flag.txt /root/flag.txt

EXPOSE 8888

ENTRYPOINT [ "java", "-cp", "./target/vulnerable_app-0.0.1-jar-with-dependencies.jar", "com.vuln.App"]