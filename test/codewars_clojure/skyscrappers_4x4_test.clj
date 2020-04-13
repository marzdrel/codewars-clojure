(ns codewars-clojure.skyscrappers-4x4-test
  (:require [clojure.test :refer :all]
            [codewars-clojure.skyscrappers-4x4 :refer :all]))

; (comment
;   (deftest skyscrapers-example-test1
;     (let [clues '(2 2 1 3 2 2 3 1 1 2 2 3 3 2 1 3)
;           actual (solve-puzzle clues)]
;       (is (= (count actual) 4))
;       (is (= (nth actual 0) [1 3 4 2]))
;       (is (= (nth actual 1) [4 2 1 3]))
;       (is (= (nth actual 2) [3 4 2 1]))
;       (is (= (nth actual 3) [2 1 3 4]))))
;
;   (deftest skyscrapers-example-test2
;     (let [clues '(0 0 1 2 0 2 0 0 0 3 0 0 0 1 0 0)
;           actual (solve-puzzle clues)]
;       (is (= (count actual) 4))
;       (is (= (nth actual 0) '[2 1 4 3]))
;       (is (= (nth actual 1) '[3 4 1 2]))
;       (is (= (nth actual 2) '[4 2 3 1]))
;       (is (= (nth actual 3) '[1 3 2 4])))))

(deftest edge-neighbours-test
  (is (= (edge-neighbours 0) [1 2 3 4 8 12]))
  (is (= (edge-neighbours 10) [8 9 11 2 6 14])))

(deftest edge-map-test
  (is (= (edge-map 0) 0))
  (is (= (edge-map 1) 1))
  (is (= (edge-map 2) 2))
  (is (= (edge-map 3) 3))
  (is (= (edge-map 4) 3))
  (is (= (edge-map 5) 7))
  (is (= (edge-map 6) 11))
  (is (= (edge-map 7) 15))
  (is (= (edge-map 8) 15))
  (is (= (edge-map 9) 14))
  (is (= (edge-map 10) 13))
  (is (= (edge-map 11) 12))
  (is (= (edge-map 12) 12))
  (is (= (edge-map 13) 8))
  (is (= (edge-map 14) 4))
  (is (= (edge-map 15) 0)))
