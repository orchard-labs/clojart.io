(ns clojart.core
  (:gen-class)
  (:require [org.httpkit.server :as http-kit]
            [clojart.handler :as app]
            [compojure.handler :as h]))

(defn -main
  [& args]
  (http-kit/run-server (h/site #'app/app) {:port 8080}))
