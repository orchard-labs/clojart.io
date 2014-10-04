(ns clojart.handler
  (:use hiccup.page)
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]))

(def index-page
  (html5 [:head [:title "Clojart.io"]]
         [:body
          [:h1 "Clojart.io"]
          [:p "lorem ipsum"]]))

(defroutes app-routes
  (GET "/" [] index-page)
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
