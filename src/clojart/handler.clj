(ns clojart.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [hiccup.page :refer [html5]]))

;; <link rel="stylesheet" type="text/css" href="theme.css">

(def index-page
  (html5 [:head
          [:title "Clojart.io"]
          [:link {:rel "stylesheet" :type "text/css" :href "site.css"}]]
         [:body
          [:h1 "Clojart.io"]
          [:p "lorem ipsum"]]))

(defroutes app-routes
  (GET "/" [] index-page)
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
