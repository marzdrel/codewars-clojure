(ns codewars-clojure.skyscrappers-4x4)

(defn- generate []
  (vec (repeat 16 (range 1 5))))

(defn initial-pass [data index clue]
  (let
   [regenerate (partial assoc data (edge-map index))
    without (fn [expr] (remove expr (get data index)))]
    (case clue
      1 (regenerate '(4))
      2 (regenerate (without #{4}))
      3 (regenerate (without #{3 4}))
      data)))

(defn solve-puzzle [clues]
  (->> (vec clues)
       (reduce-kv initial-pass (generate))))

(defn edge-map [index]
  (condp > index
    4 index
    8 (+ 3 (* 4 (- index 4)))
    12 (- 15 (- index 8))
    16 (- 12 (* 4 (- index 12)))))

(defn- debug [list]
  (map println list))

(comment (solve-puzzle '(2 2 1 3 2 2 3 1 1 2 2 3 3 2 1 3)))

(debug (solve-puzzle '(0 0 1 2 0 2 0 0 0 3 0 0 0 1 0 0)))
