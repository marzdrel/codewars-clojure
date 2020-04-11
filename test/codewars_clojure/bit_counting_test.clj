(ns codewars-clojure.bit-counting-test
  (:require [clojure.test :refer :all]
            [codewars-clojure.bit-counting :refer :all]))

(deftest sample-tests
  (testing "0"
    (is (= 0 (count-bits 0))))
  (testing "1"
    (is (= 1 (count-bits 1))))
  (testing "10"
    (is (= 2 (count-bits 10))))
  (testing "14"
    (is (= 3 (count-bits 14))))
  (testing "30"
    (is (= 4 (count-bits 30)))))
