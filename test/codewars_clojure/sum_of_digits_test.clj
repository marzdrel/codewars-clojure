(ns codewars-clojure.sum-of-digits-test
  (:require [clojure.test :refer :all]
            [codewars-clojure.sum-of-digits :refer :all]))

(deftest digital-root-example-test
  (is (= (digital-root 16) 7))
  (is (= (digital-root 456) 6)))
