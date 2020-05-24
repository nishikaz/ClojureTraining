;; 最初にその言語を触れるものは必ずこの呪文を唱えるようにと
;; 古事記でも謳われているので、今回もその慣習をならうもの。
(println "Hello, World!")

;; 四則演算
;; 加算（1+2=3）
(println (+ 1 2))
;; 減算（18-13=5）
(println (- 18 13))
;; 乗算（3*(2*3)=18）
(println (* 3 (* 2 3)))
;; 除算（(90/3)/2=15）
(println (/ (/ 90 3) 2))

;; 変数（イミュータブル：変更不可）
(def string-var "hogehoge")
(println string-var)

;; string-varには一見fugafugaが格納されているように見えるが、
;; fugafugaが格納された別メモリ領域を参照しているだけで、
;; まだ最初に定義したメモリ領域上に存在している（らしい）
(def string-var "fugafuga")
(println string-var)

;; 変数（ミュータブル：変更可能）
;; アトム値って呼ぶらしい
(def n (atom 0))
(println @n)

;; swap! は元々のアトム値を参照して
;; 何か処理するときに使うらしい
;; 今回は元々のnの値をインクリメントしている
(swap! n inc)
(println @n)

;; reset! は元々のアトム値を無視して
;; 何か処理するときに使うらしい
;; 今回はpiyopiyoの文字列を代入している
(reset! n "piyopiyo")
(println @n)
