(ns codewars-clojure.playing-with-digits-test
  (:require [clojure.test :refer :all]
            [codewars-clojure.playing-with-digits :refer :all]))

(deftest a-test1
  (testing "Test1"
    (is (= (dig-pow 89 1) 1))))
(deftest a-test2
  (testing "Test2"
    (is (= (dig-pow 92 1) -1))))
