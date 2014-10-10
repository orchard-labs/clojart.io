(ns clojart.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [hiccup.page :refer [html5]]))

(def index-page
  (html5 [:head
          [:title "Clojart.io"]
          [:link {:rel "stylesheet" :type "text/css" :href "site.css"}]]
         [:body
          [:script {:src "http://fb.me/react-0.9.0.js"}] ;; Upgrade this, we should be on 0.11.0 by now!
          [:script {:src "js/out/goog/base.js" :type "text/javascript"}]
          [:script {:src "js/main.js" :type "text/javascript"}]
          [:script {:type "text/javascript"} "goog.require('clojart.core');"]
          [:h1 "Clojart.io"]
          [:p "lorem ipsum"]]))

(defroutes app-routes
  (GET "/" [] index-page)
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
