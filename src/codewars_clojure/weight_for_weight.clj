(ns codewars-clojure.weight-for-weight)

(use '[clojure.string :only (split join)])

(defn order-weight [strng]
  (->> (split strng #"\s+")
       (sort-by
        (juxt (fn [x] (->> (split x #"")
                           (map read-string)
                           (apply +)))
              identity))
       (join " ")))

(comment (order-weight "122  2322  232 2"))
