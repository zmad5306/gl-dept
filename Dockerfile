FROM openjdk:10-jre-slim
ARG version
EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/gl-dept-${version}.jar /app/gl-dept.jar
ENTRYPOINT ["java", "-jar", "/app/gl-dept.jar"]