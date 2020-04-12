(ns codewars-clojure.complementary-dna-test
  (:require
   [clojure.test :refer :all]
   [codewars-clojure.complementary-dna :refer [dna-strand]]))

(deftest sample-tests
  (is (= (dna-strand "ATCG") "TAGC")))
