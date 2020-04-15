(ns codewars-clojure.couting-duplicates)

(defn duplicate-count [text]
  (->> text
       clojure.string/lower-case
       seq
       frequencies
       (map last)
       (filter (partial < 1))
       count))

(duplicate-count "abcC")
