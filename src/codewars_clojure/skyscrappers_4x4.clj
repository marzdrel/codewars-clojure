(ns codewars-clojure.skyscrappers-4x4)

(defn solve-puzzle [clues]
  (->> 1
       (repeat 4)
       (repeat 4)))

(defn edge-map [index]
  0)

(defn debug [list]
  (map println list))

(debug (solve-puzzle '(0 0 1 2 0 2 0 0 0 3 0 0 0 1 0 0)))
(solve-puzzle '(2 2 1 3 2 2 3 1 1 2 2 3 3 2 1 3))
