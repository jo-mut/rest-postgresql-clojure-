#!/usr/bin/env bash
psql clojure_rest_example -f sql/reset.sql 
psql clojure_rest_example -f sql/friends_table.sql 