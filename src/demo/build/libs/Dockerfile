FROM openjdk:8-jre-alpine
COPY demo-0.0.1-SNAPSHOT.jar /root/demo.jar
WORKDIR /root
CMD ["java", "-server", "-Xms4g", "-Xmx4g", "-XX:+UseG1GC", "-XX:MaxGCPauseMillis=100", "-XX:+UseStringDeduplication", "-jar", "demo.jar"]
