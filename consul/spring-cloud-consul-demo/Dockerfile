FROM openjdk:8
MAINTAINER zhangdalei<zhangdalei1@jd.com>
USER root

ENV ENABLE_REGISTRY=false SGM_ENABLE=false \
    JMESH_REGISTRY_HOST=consul.tpaas.local \
    JMESH_REGISTRY_PORT=80 \
    JMESH_CONFIG_TOKEN=f1280eb8-39c6-e070-668a-31f03c4e4e1e \
    SGM_CONSOLE_SERVER=sgm-console-server.honor.tpaas.local \
    APP_NAME=demo APP_GROUP=v1 PRIVIDER_NAME="-"

WORKDIR /app
COPY target/*.jar /app/app.jar
COPY src/main/bin/sgm.sh /app/sgm.sh
RUN chmod +x /app/sgm.sh
EXPOSE 80
ENTRYPOINT ["/app/sgm.sh"]