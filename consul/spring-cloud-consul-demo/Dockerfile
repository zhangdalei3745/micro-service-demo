FROM openjdk:8
MAINTAINER zhangdalei<zhangdalei@jd.com>
USER root

ENV PROFILE=consul
ENV APP_NAME=demo
WORKDIR /app
COPY target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=${PROFILE}","-Dspring.application.name=${APP_NAME}","-Dserver.port=8080","-jar","/app/app.jar"]