(ns rest-postgresql-clojure.libs.db
  [:require 
   [clojure.string :as str]
   [clojure.java.jdbc :as jdbc]])

(def -db {:classname "org.postgresql.Driver"
          :dbtype "postgresql"
          :dbname "clojure_rest_example"
          :host "localhost"
          :user "postgres"
          :password "postgres"})

(defn concat-fields
  "Concat field names for SQL"
  [fields]
  (str/join ", " (map name fields)))

(defn insert 
  "Insert a record to database"
  [table record]
  (first (jdbc/insert! -db table record)))

(defn select
  "Select a record from the database"
  [table fields]
  (jdbc/query -db [(str "select " (concat-fields fields) " from " (name table))]))