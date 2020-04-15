(ns codewars-clojure.playing-with-digits)

(defn digits [n]
  (when (pos? n)
    (concat (digits (quot n 10)) [(mod n 10)])))

(defn power [a b]
  (reduce * 1 (repeat b a)))

(defn dig-pow [n p]
  (->> (digits n)
       (map-indexed (fn [i val] (power val (+ i p))))
       (reduce +)
       ((fn [result]
          (if (pos? (mod result n))
            -1 (quot result n))))))

(comment
  (dig-pow 89 1)
  (dig-pow 92 1)
  (dig-pow 249 1)
  (dig-pow 695 2)
  (dig-pow 46288 3))
