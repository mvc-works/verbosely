
(ns verbosely.core
  (:require [clojure.string :as string]))

(defmacro verbosely! [f & args]
  (let [exp (str (cons f args))]
    `(let [result# (~f ~@args)]
      (println "Called:" ~exp)
      (println "..With:" ~@args)
      (println "...Got:" result#)
      result#)))
