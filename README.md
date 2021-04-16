# Cities_API
<h2> API Rest de consulta de cidades do Brasil </h2>

* Java 8
* Docker

## DataBase

### Postgres

* [Postgres Docker Hub](https://hub.docker.com/_/postgres)

```shell script
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
```

### Populate

* [data](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)

docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash

psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

### Access

```shell script
docker exec -it cities-db /bin/bash

psql -U postgres_user_city cities
```

### Spring Boot

* [https://start.spring.io/](https://start.spring.io/)
+ Java 8
+ Gradle Project
+ Jar
+ Spring Web
+ Spring Data JPA
+ PostgreSQL Driver
+ Lombok
+ Spring Boot DevTools 
+ Validation I/O