(defproject clojart "0.1.0-SNAPSHOT"
  :description "Visualize code beautifully"
  :url "http://github.com/orchard-labs/clojart.io"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.2.0"]
                 [http-kit "2.1.16"]
                 [hiccup "1.0.5"]
                 [garden "1.2.1"]]
  :plugins [[lein-ring "0.8.12"]
            [lein-garden "0.2.1"]]
  :garden {:builds [{
                     :id "site"
                     :source-paths ["src/"]
                     :stylesheet clojart.styles.site/site
                     :compiler {
                                :output-to "resources/public/site.css"
                                :pretty-print? false}}]}
  :ring {:handler clojart.handler/app}
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]
                                  [bond "0.2.5"]]}
             :uberjar {:aot :all}}
  :main clojart.core)
