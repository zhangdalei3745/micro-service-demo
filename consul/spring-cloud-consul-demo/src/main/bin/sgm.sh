#!/usr/bin/env bash
if [ $SGM_ENABLE ]; then
  curl -s "http://$SGM_CONSOLE_SERVER/local/probe/java/script?app=$APP_NAME-$APP_GROUP" -o /tmp/sgm_java.sh && source /tmp/sgm_java.sh && java $SGM_OPTS -Dserver.port=80 -Dspring.cloud.loadbalancer.enabled=${ENABLE_REGISTRY} -Dspring.cloud.consul.discovery.enable=${ENABLE_REGISTRY} -jar /app/jmsf-consumer.jar
else
  java  -Dserver.port=80 -Dspring.cloud.loadbalancer.enabled=$ENABLE_REGISTRY -Dspring.cloud.consul.discovery.enable=$ENABLE_REGISTRY -jar /app/jmsf-consumer.jar
fi

