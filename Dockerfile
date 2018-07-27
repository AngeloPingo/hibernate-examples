FROM openjdk:8-jdk-alpine

VOLUME /tmp

ADD */npm-semi-open-microservices-1.0.0.jar /npm-semi-open-microservices.jar

ENV JAVA_OPTS="-Dspring.profiles.active=docker"
# ENV JAVA_OPTS_PROXY_ADDRESS="-Dhttps.proxyHost=ptliprx100.emea.nsn-net.net"
# ENV JAVA_OPTS_PROXY_PORT="-Dhttps.proxyPort=8080"

# To reduce Tomcat startup time was added a system property pointing to "/dev/urandom" as a source of entropy.
ENV UNRANDOM="-Djava.security.egd=file:/dev/./urandom"

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS $UNRANDOM -jar /npm-semi-open-microservices.jar" ]