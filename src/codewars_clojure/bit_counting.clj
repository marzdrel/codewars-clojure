; (ns clojure.bit-counting)
(ns codewars-clojure.bit-counting)

(use '[clojure.string :only (split)])

(defn count-bits [n]
  (count (filter (partial = "1")
                 (split (str (Integer/toBinaryString n))
                        #""))))
