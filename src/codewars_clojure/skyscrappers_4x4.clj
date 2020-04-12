(ns codewars-clojure.skyscrappers-4x4)

(defn solve-puzzle [clues]
  (->> 1
       (repeat 4)
       (repeat 4)))

(solve-puzzle '(0 0 1 2 0 2 0 0 0 3 0 0 0 1 0 0))
