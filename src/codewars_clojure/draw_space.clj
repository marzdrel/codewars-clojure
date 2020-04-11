; (ns kata)
(ns codewars_clojure.draw_space)

(use '[clojure.string :only (join split)])

(defn draw-stairs [final]
  (join "\n"
        (map (fn [n]
               (apply str
                      (conj (vec (repeat n " "))
                            "I")))
             (range 0 final))))

(comment
  (draw-stairs 1)
  (draw-stairs 10))
