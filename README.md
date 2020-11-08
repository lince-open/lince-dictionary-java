# lince-dictionary-java

Microservice responsavel pelo registro do dicionário de dados. Possui um dicionario de dados com as entidades e persiste em um banco relacional.
Futuramente deve registrar o dicionário em um banco NoSQL.

Solução

* Persistencia Spring Data e JPA
* Autenticação com Spring Security e uso de Header
* Testes Unitários com JUnit/Spock/Groove
* Testes Funcionais com JUnit/Spock/Groove
* Swagger2
* Docker

![](https://github.com/lince-open/lince-dictionary-java/workflows/Java%20CI/badge.svg)
[![Known Vulnerabilities](https://snyk.io/test/github/lince-open/lince-dictionary-java/badge.svg)](https://snyk.io/test/github/pedrozatta/lince-dictionary-java)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=lince-open_lince-dictionary-java&metric=coverage)](https://sonarcloud.io/dashboard?id=lince-open_lince-dictionary-java)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=lince-open_lince-dictionary-java&metric=alert_status)](https://sonarcloud.io/dashboard?id=lince-open_lince-dictionary-java)


## Docker Hub

https://hub.docker.com/repository/docker/linceopen/lince-dictionary

mvn clean package dockerfile:build

docker run --name lince-dictionary \
-e LINCE_KVS_PORT='8080' \
-e LINCE_KVS_DATASOURCE_URL='jdbc:h2:file:~/lince-dictionary' \
-e LINCE_JAVA_OPT='-Xms64m -Xmx128m' \
-p 51001:8080 \
-t lince-open/lince-kvs:latest

docker tag lince-open/lince-dictionary:latest linceopen/lince-dictionary:0.0.10

docker push linceopen/lince-dictionary:0.0.10

docker tag lince-open/lince-dictionary:latest linceopen/lince-dictionary:latest

docker push linceopen/lince-dictionary:latest

## Execução
mvn spring-boot:run



##AttributeType Min Max
Caso o DataType seja TEXT, o min e max serão quantidade maxima de caracteres
INTEGER, DECIMAL, DATA, TIMESTAMP e TIME:  menor e maior valor (inclusive)

#Swagger

http://localhost:8080/swagger-ui.html

