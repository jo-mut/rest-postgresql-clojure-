#!/usr/bin/env bash
psql postgres -c "CREATE USER postgres WITH LOGIN SUPERUSER INHERIT CREATEDB CREATEROLE NOREPLICATION PASSWORD 'postgres'"
psql postgres -c "CREATE DATABASE clojure_rest_example WITH OWNER = postgres ENCODING = 'UTF8' CONNECTION LIMIT = -1;"
psql postgres -f sql/friends_table.sql 