(ns codewars-clojure.complementary-dna)

(defn dna-strand [dna]
  (let [pairs (array-map \A \T \T \A \C \G \G \C)]
    (->>
     (seq dna)
     (map (partial get pairs))
     (apply str))))

(comment
  (dna-strand "ATCG"))
