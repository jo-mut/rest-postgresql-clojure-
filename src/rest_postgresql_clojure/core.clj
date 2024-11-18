(ns rest-postgresql-clojure.core
  (:require
   [dotenv :refer [env]]
   [compojure.route :as route]
   [compojure.core :refer [defroutes GET POST]]
   [org.httpkit.server :as server]
   [ring.middleware.json :as js]
   [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
   [ring.middleware.reload :refer [wrap-reload]]
   [rest-postgresql-clojure.libs.routes :as routes])
  (:gen-class))


(defroutes app-routes 
  (GET "/" [] routes/echo-route)
  (GET "/friends" [] routes/get-friends)
  (POST "/friends" [] routes/add-friends)
  (route/not-found "Page not found"))


(defn -main
  "Production"
  [& args]
  (let [port  (Integer/parseInt (or (env :PORT) "3000"))]
    (server/run-server
     (js/wrap-json-params
      (js/wrap-json-response
       (wrap-defaults app-routes api-defaults)))
     {:port port})
    (println (str "Running webserver at http:/127.0.0.1:" port "/"))))


(defn -dev-main
  "Dev/Test (auto reload watch enabled)"
  [& args]
  (let [port (Integer/parseInt (env :PORT))]
    (server/run-server
     (wrap-reload
      (js/wrap-json-params
       (js/wrap-json-response
        (wrap-defaults #'app-routes api-defaults))))
     {:port port})
    (println (str "Running webserver at http:/127.0.0.1:" port "/"))))
