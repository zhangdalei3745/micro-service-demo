FROM openjdk:8
MAINTAINER zhangdalei<zhangdalei1@jd.com>

WORKDIR /app
COPY target/*.jar /app/app.jar
EXPOSE 80
ENTRYPOINT ["java","-Dserver.port=80","-jar","/app/app.jar"]