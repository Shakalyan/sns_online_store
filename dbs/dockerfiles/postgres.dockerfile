FROM postgres:15.2-alpine
COPY postgres_dump.sql /docker-entrypoint-initdb.d/db_init.sql
