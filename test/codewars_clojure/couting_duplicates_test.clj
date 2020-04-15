(ns codewars-clojure.couting-duplicates-test
  (:require [clojure.test :refer [deftest is testing]]
            [codewars-clojure.couting-duplicates
             :refer
             [duplicate-count]]))

(deftest sample-tests
  (testing "blank"
    (is (= 0 (duplicate-count ""))))
  (testing "abcde"
    (is (= 0 (duplicate-count "abcde"))))
  (testing "aabbcde"
    (is (= 2 (duplicate-count "aabbcde"))))
  (testing "ignore-case"
    (is (= 2 (duplicate-count "aabBcde"))))
  (testing "Indivisibility"
    (is (= 1 (duplicate-count "Indivisibility"))))
  (testing "non-adjacent"
    (is (= 2 (duplicate-count "Indivisibilities")))))
