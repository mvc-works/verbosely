
(ns verbosely.core
  (:require [clojure.string :as string]))

(defmacro verbosely! [f & args]
  (let [exp (str (cons f args))]
    `(let [~'result (~f ~@args)]
      (println "Calling:" ~exp)
      (println "With:" ~@args)
      (println "Returns:" ~'result)
      ~'result)))
