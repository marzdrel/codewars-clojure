(ns codewars-clojure.human-readable-time-format)

(defn formatDuration [secs]
  (case secs
    0 "now"
    (reduce
     (fn [x y]
       (if (pos? (/ x y)) (reduced x) (reduced y)))
     secs
     '(60 60 24 31 12))))

(formatDuration 0)
(formatDuration 5)
(formatDuration 62)
