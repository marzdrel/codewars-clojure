(ns codewars-clojure.multiples-of-three-five)
; (ns multiples)

(defn multiple-of-3-or-5? [n]
  (or (= 0 (mod n 3)) (= 0 (mod n 5))))

(defn solution [number]
  (->> (range number)
       (rest)
       (filter multiple-of-3-or-5?)
       (set)
       (reduce +)))

(solution 10)
