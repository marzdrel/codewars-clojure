(ns codewars-clojure.skyscrappers-4x4)

(use 'clojure.pprint)
(use '[clojure.string :only (join split)])

(defn- generate []
  (vec (repeat 16 (range 1 5))))

(defn edge-map [index]
  (condp > index
    4  index
    8  (+ 3 (* 4 (- index 4)))
    12 (- 15 (- index 8))
    16 (- 12 (* 4 (- index 12)))))

(defn edge-row [index]
  (let [start (edge-map index)
        mapr #(map % (range 4))]
    (condp > index
      4  (mapr #(+ start (* 4 %)))
      8  (mapr #(- start %))
      12 (mapr #(- start (* 4 %)))
      16 (mapr #(+ start %)))))

(defn regenerate-row-without [clue expr data]
  (->> (edge-row clue)
       (reduce (fn [d i] (assoc d i (remove expr (get d i))))
               data)))

(defn initial-pass [data index clue]
  (let [regenerate
        (fn [board elem] (assoc board (edge-map index) elem))
        without
        (fn [expr] (remove expr (get data index)))]
    (case clue
      1 (regenerate (regenerate-row-without 1 #{4} data) '(4))
      2 (regenerate data (without #{4}))
      3 (regenerate data (without #{3 4}))
      data)))

(defn solve-puzzle [clues]
  (->> (vec clues)
       (reduce-kv initial-pass (generate))))

(defn- debug [list]
  (->> list
       (map pr-str)
       (map (partial format "%9s"))
       (partition 4)
       (map (partial join " | "))
       (map println)))

; (comment (solve-puzzle '(2 2 1 3 2 2 3 1 1 2 2 3 3 2 1 3)))
(debug (solve-puzzle '(0 0 1 2 0 2 0 0 0 3 0 0 0 1 0 0)))
(edge-row 2)

(debug
 (->> (generate)
      (regenerate-row-without 2 #{4})
      (regenerate-row-without 15 #{2})
      (regenerate-row-without 5 #{4})))
