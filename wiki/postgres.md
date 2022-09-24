# Postgres setup

1. Download [GUI](https://www.pgadmin.org/)
1. Launch Postgres Docker container

[docker-compose.yml](docker-compose.yml). Postgres environments setup.
Use POSTGRES_USER and POSTGRES_PASSWORD to connect GUI to the database

```yml
  postgres:
    restart: always
    image: postgres:latest
    volumes:
      - /tmp/postgresql:/var/lib/postgresql
    ports:
      - "5432:5432"
    expose:
      - "5432"
    networks:
      - ktor-network
    environment:
      - POSTGRES_DB="ktor"
      - POSTGRES_HOST_AUTH_METHOD=trust
      - DEBUG=false
      - POSTGRES_USER=sample
      - POSTGRES_PASSWORD=sample
      - POSTGRES_DB=s-backend
```

Add server `0.0.0.0:5432` user `$POSTGRES_USER`, password `$POSTGRES_PASSWORD`

0.0.0.0 - host of db
5432 - port of db
postgres - db name

```conf
jdbcURL = "jdbc:postgresql://0.0.0.0:5432/postgres"
```

