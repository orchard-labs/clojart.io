(ns clojart.core
  (:gen-class)
  (:require [org.httpkit.server :as http-kit]
            [clojart.handler :as app]
            [compojure.handler :as h]
            [clojure.tools.nrepl.server :as nrepl]))

;;
;; REPL management and convenience stuff
;;

(defonce repl (atom nil))

(defn start-repl [port]
  (nrepl/start-server :port port))

(defn stop-repl [repl]
  (nrepl/stop-server repl))

(defn -main
  [& args]
  (reset! repl (start-repl 4005))
  (http-kit/run-server (h/site #'app/app) {:port 8080}))
