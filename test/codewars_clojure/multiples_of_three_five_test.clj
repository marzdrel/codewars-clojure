(ns codewars-clojure.multiples-of-three-five-test
  (:require [clojure.test :refer :all]
            [codewars-clojure.multiples-of-three-five :refer :all]))

(deftest test-multiples-of-3-and-5
  (is (= 23 (solution 10))))
