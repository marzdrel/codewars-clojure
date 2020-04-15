(ns codewars-clojure.persistent-bugger-test
  (:require [clojure.test :refer :all]
            [codewars-clojure.persistent-bugger
             :refer [persistence]]))

(deftest initial-tests
  (testing "Initial Tests"
    (is (= (persistence 39) 3))
    (is (= (persistence 4) 0))
    (is (= (persistence 25) 2))
    (is (= (persistence 999) 4))))
