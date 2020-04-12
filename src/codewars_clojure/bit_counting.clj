; (ns clojure.bit-counting)
(ns codewars-clojure.bit-counting)

(use '[clojure.string :only (split)])

(defn count-bits [n]
  (->> (Integer/toBinaryString n)
       (#(split % #""))
       (filter (partial = "1"))
       (count)))

(comment
  (count-bits 123))
