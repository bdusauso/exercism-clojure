(ns bird-watcher)

(def last-week
  [0 2 5 3 7 8 4])

(defn today [birds]
  (last birds))

(defn inc-bird [birds]
  (assoc birds (dec (count birds)) (inc (today birds))))

(defn day-without-birds? [birds]
  (not (= 0 (count (filter #(= 0 %1) birds)))))

(defn n-days-count [birds n]
  (reduce
    #(+ %1 %2)
    (take n birds)))

(defn busy-days [birds]
  (count (filter #(>= %1 5) birds)))

(defn odd-week? [birds]
  (= birds [1 0 1 0 1 0 1]))
