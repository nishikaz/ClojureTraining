;; 第n項までのフィボナッチ数列を表示する
(def n 16)

;; 計算済みの項を格納するマップ
(def fibonacci-seq (atom (sorted-map 0 0 1 1)))

(defn fibonacci[n]
    (if (nil? (@fibonacci-seq n))
        (swap! fibonacci-seq assoc n (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))
    (@fibonacci-seq n))

(fibonacci (- n 1))
(println (vals @fibonacci-seq))
