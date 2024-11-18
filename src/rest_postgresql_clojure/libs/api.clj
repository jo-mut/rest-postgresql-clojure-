(ns rest-postgresql-clojure.libs.api
  [:require 
   [rest-postgresql-clojure.libs.db :as db]])


(defn get-friends 
  "Retrieve a list of all friends"
  []
  (db/select :friends [:id :name :nickname :occupation]))

(defn add-friends
  "Add a records to friends"
  [{name :name nickname :nickname occupation :occupation :as record}]
  (db/insert :friends record))