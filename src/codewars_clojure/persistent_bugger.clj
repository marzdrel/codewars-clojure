(ns codewars-clojure.persistent-bugger)

(defn digits [n]
  (when (pos? n)
    (concat (digits (quot n 10)) [(mod n 10)])))

(defn persistence [number]
  (reduce (fn [num index]
            (let [value (reduce * (digits num))]
              (if (< num 10) (reduced index) value)))
          number
          (range)))
