(ns codewars-clojure.find-the-odd-int)

(defn find-odd [xs]
  (->> xs
       (group-by identity)
       (filter #(odd? (count (last %))))
       (ffirst)))

(find-odd '(2 2 2 3 3 4 4 4 4))
