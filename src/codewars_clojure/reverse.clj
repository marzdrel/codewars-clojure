(ns codewars_clojure.reverse
  (:refer-clojure :exclude [reverse]))

; (ns reverse
;   (:refer-clojure :exclude [reverse]))

(defn reverse
  "Reverse a list"
  [lst]
  (reduce conj '() lst))

(comment
  (print (reverse '(1 2 3 4 4 3))))
