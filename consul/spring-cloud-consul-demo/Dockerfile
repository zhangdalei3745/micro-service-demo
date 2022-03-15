FROM openjdk:8
MAINTAINER zhangdalei<zhangdalei@jd.com>
USER root

ENV PROFILE=consul
ENV APP_NAME=demo
WORKDIR /app
COPY target/*.jar /app/app.jar
COPY src/main/bin/sgm.sh /app/sgm.sh
EXPOSE 80
ENTRYPOINT ["/app/sgm.sh"]