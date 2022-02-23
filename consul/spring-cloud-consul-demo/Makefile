hub=hub.jdcloud.com
project=mesh
version=2.3-$(shell git rev-parse --short HEAD)
image=$(hub)/$(project)/spring-cloud-consul-demo/$(version)
all: build image push
install:
	mvn clean install -DskipTests
build:
	docker build -t $(image) .
push:
	docker push $(image)
