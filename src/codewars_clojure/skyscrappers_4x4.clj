(ns codewars-clojure.skyscrappers-4x4)

(use 'clojure.pprint)
(use '[clojure.string :only (join split)])

(defn edge-position [index]
  (condp > index
    4  index
    8  (+ 3 (* 4 (- index 4)))
    12 (- 15 (- index 8))
    16 (- 12 (* 4 (- index 12)))))

(defn edge-row [index]
  (let [start (edge-position index)
        mapr #(map % (range 4))]
    (condp > index
      4  (mapr #(+ start (* 4 %)))
      8  (mapr #(- start %))
      12 (mapr #(- start (* 4 %)))
      16 (mapr #(+ start %)))))

(defn edge-neighbours
  "Return list of horizontal and vertical neighbours of position"
  [index]
  (let [xs (- index (mod index 4))
        row (range xs (+ xs 4))
        col (edge-row (mod index 4))]
    (remove #{index} (concat row col))))

(defn throw-neighbours
  "Remove all pieces in expr from fields adjanced to boardindex"
  [boardindex expr data]
  (->> (edge-neighbours boardindex)
       (reduce (fn [d i] (assoc d i (remove expr (get d i))))
               data)))

(defn initial-pass [data index clue]
  (let [regenerate
        (fn [elem board] (assoc board (edge-position index) elem))
        without
        (fn [expr] (remove expr (get data (edge-position index))))]
    (case clue
      1 (->> data
             (throw-neighbours (edge-position index) #{4})
             (regenerate '(4)))
      2 (regenerate (without #{4}) data)
      3 (regenerate (without #{3 4}) data)
      data)))

(defn edge-piece-distance [state clueindex]
  (let [row (edge-row clueindex)
        distance
        ; (map (partial get state) row)
        (->> row
             (map (partial get state))
             (map-indexed (fn [index heights] [index heights]))
             (filter (fn [[index heights]] (= 1 (count heights))))
             (map (fn [[index heights]] [index (first heights)]))
             (first))]
    (if (some? distance) distance 0)))

(defn subsequent-pass [board index clue]
  (do (println (edge-piece-distance board index)) board))

(defn spot-loners [data index]
  (let [soloer (->> (edge-row index)
                    (map (partial get data))
                    (filter (fn [row] (> (count row) 1)))
                    (flatten)
                    (frequencies)
                    (filter (fn [[k v]] (= v 1)))
                    (ffirst))]
    (if (some? soloer)
      (reduce (fn [data pos]
                (if (some #{soloer} (get data pos))
                  (->> (assoc data pos (conj () soloer))
                       (throw-neighbours pos #{soloer})
                       reduced)
                  data))
              data
              (edge-row index))
      data)))

(defn- debug [list]
  (do (println (apply str (repeat 45 \-)))
      (->> list
           (map pr-str)
           (map (partial format "%9s"))
           (partition 4)
           (map (partial join " | "))
           (join "\n")
           (println))
      list))

(defn remove-loners [data]
  (let [soloize (fn [state] (reduce spot-loners state (range 8)))]
    (->> data
         ((fn [x]
            (let [result (soloize x)]
              (if (= result x)
                result
                (remove-loners result))))))))

(defn solve-puzzle [clues]
  (let [initial-state (vec (repeat 16 (range 1 5)))]
    (->> (vec clues)
         (reduce-kv initial-pass initial-state)
         remove-loners
         (#(reduce-kv subsequent-pass % (vec clues)))
         debug)))

(solve-puzzle '(2 2 1 3  2 2 3 1  1 2 2 3  3 2 1 3))
(solve-puzzle '(0 0 1 2  0 2 0 0  0 3 0 0  0 1 0 0))
