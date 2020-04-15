(ns codewars-clojure.sum-of-digits)

(defn digits [n]
  (when (pos? n)
    (concat (digits (quot n 10)) [(mod n 10)])))

(defn digital-root [n]
  (let [sum (reduce + (digits n))]
    (if (< sum 10) sum (digital-root sum))))

(digital-root 10023)
