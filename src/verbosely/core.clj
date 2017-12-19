
(ns verbosely.core
  (:require [clojure.string :as string]))

(defmacro verbosely! [f & args]
  (let [exp (str (cons f args))]
    `(let [result# (~f ~@args)]
      (println "Called:" ~exp)
      (println "..With:" ~@args)
      (println "...Got:" result#)
      result#)))

(defmacro log! [& var-names]
  `(do
    (println (str "(log! " ~@(string/join " " (map pr-str var-names)) ")"))
    ~@(map
        (fn [var-name#]
          `(println (str ~(pr-str var-name#) ": " ~var-name#)))
        var-names)))
