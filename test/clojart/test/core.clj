(ns clojart.test.core
  (:require [clojure.test :refer :all]
            [bond.james :as bond]
            [clojart.core :refer [start-repl stop-repl]]))

(deftest test-repl
  (testing "start-repl"
    (bond/with-stub [clojure.tools.nrepl.server/start-server]
      (start-repl 5000)
      (let [calls (bond/calls clojure.tools.nrepl.server/start-server)]
        (is (= 1 (count calls)))
        (is (= (-> calls first :args) [:port 5000])))))
  (testing "stop-repl"
    (bond/with-stub [clojure.tools.nrepl.server/stop-server]
      (let [repl (Object.)]
        (stop-repl repl)
        (let [calls (bond/calls clojure.tools.nrepl.server/stop-server)]
          (is (= 1 (count calls)))
          (is (= (-> calls first :args first) repl)))))))
