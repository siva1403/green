FROM openjdk:11.0.11-jre-slim
WORKDIR /app
COPY /target/NotherSecurity-1.0.0.jar /app/NotherSecurity-1.0.0.jar
EXPOSE 8084
CMD ["java", "-jar", "/app/NotherSecurity-1.0.0.jar"]
#ENTRYPOINT ["java", "-jar", "/app/NotherSecurity-1.0.0.jar"]
