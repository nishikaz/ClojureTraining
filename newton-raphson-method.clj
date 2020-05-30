;; ニュートン法で3の平方根を求める
(defn fx [x]
    (- (* x x) 3))

(defn ffx [x]
    (* 3 x))

(defn get-x1 [x0]
    (- x0 (/ (fx x0) (ffx x0))))

;; 解を探索する初期値を設定する
(def x0 (atom 3))
(def x1 (atom 0))
(def x-range (atom []))

;; 探索区間がepsよりも小さくなるまで中点を繰り返し求める
(def eps 0.00000001)
(defn newton-raphson []
    (reset! x1 (get-x1 @x0))
    (reset! x-range [@x1 @x0])
    (reset! x0 @x1)

    (if (> (Math/abs (double (reduce - @x-range))) eps)
        (newton-raphson)
    )
)

;; 求めた近似解の出力
(newton-raphson)
(println (double @x1))