(ns cars-assemble)

(def base-rate 221.0)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (let [pph (* base-rate speed)]
    (cond
      (= 0 speed) 0.0
      (and (>= speed 1) (<= speed 4)) pph
      (and (>= speed 5) (<= speed 8)) (with-precision 1 (* pph 0.9))
      (= speed 9) (with-precision 1 (* pph 0.8))
      :else (with-precision 1 (* pph 0.77))))
  )

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60)))
