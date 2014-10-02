(ns clojart.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [clj-jade.core :as jade]))

(jade/configure {:template-dir "resources/views/"
                 :pretty-print true
                 :cache? true})


(defroutes app-routes
  (GET "/" [] (jade/render "index.jade" {"pageName" "clojart.io"
                           "submissions" [{"author" "MandarinFL" "title" "io.clojart.foo"}
                                          {"author" "j0ni" "title" "io.clojart.bar"}]}))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
