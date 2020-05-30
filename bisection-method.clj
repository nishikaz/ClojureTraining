;; 二分法で3の平方根を求める
(defn fx[x]
    (- (* x x) 3))

;; 解の探索区間は1(fx(1)=-2)から2(fx(2)=1)
(def x-range (atom [1 2]))

;; 探索区間がepsよりも小さくなるまで中点を繰り返し求める
(def eps 0.00000001)
(def y-mid (atom (double 0)))
(def mid-point (atom (double 0)))

(defn bisection []
    (reset! mid-point (/ (reduce + @x-range) 2))
    (reset! y-mid (fx @mid-point))

    (if (> @y-mid 0)
        (reset! x-range [(@x-range 0) @mid-point])
        (reset! x-range [@mid-point (@x-range 1)])
    )

    (if (> (Math/abs (double (reduce - @x-range))) eps)
        (bisection)
    )
)

;; 求めた近似解の出力
(bisection)
(println (double @mid-point))