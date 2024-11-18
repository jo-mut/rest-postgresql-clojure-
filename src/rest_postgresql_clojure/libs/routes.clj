(ns rest-postgresql-clojure.libs.routes
  (:require
   [rest-postgresql-clojure.libs.api :as api]))

(defn echo-route
  "Echo back the request"
  [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (-> (str "GET '/' " req))})

(defn get-friends 
  "Echo back a name"
  [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (-> (api/get-friends))})

(defn add-friends
  "Endpoint for adding a friend"
  [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (-> (api/add-friends (req :params)))})