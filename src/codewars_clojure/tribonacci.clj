(ns codewars-clojure.tribonacci)

(defn tribonacci [xs n]
  (if (< n 4)
    (vec (take n xs))
    (reduce (fn [i _] (conj (vec i)
                            (apply + (take-last 3 i))))
            xs
            (range (- n 3)))))

(comment (tribonacci [1 2 3] 0)
         (tribonacci [1 2 3] 1)
         (tribonacci [1 2 3] 2)
         (tribonacci [1 2 3] 3)
         (tribonacci [1 1 1] 10))
