#!/usr/bin/bash
if [ $SGM_ENABLE = "true" ]; then
  echo "123"
  curl -s "http://$SGM_CONSOLE_SERVER/local/probe/java/script?app=$APP_NAME-$APP_GROUP" -o /tmp/sgm_java.sh && source /tmp/sgm_java.sh && java $SGM_OPTS -Dserver.port=80 -Dspring.cloud.loadbalancer.enabled=${ENABLE_REGISTRY} -Dspring.cloud.consul.discovery.enable=${ENABLE_REGISTRY} -jar /app/app.jar
else
  echo "345"
  java  -Dserver.port=80 -Dspring.cloud.loadbalancer.enabled=$ENABLE_REGISTRY -Dspring.cloud.consul.discovery.enable=$ENABLE_REGISTRY -jar /app/app.jar
fi

