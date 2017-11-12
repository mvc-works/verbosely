
(defn read-password [guide]
  (String/valueOf (.readPassword (System/console) guide nil)))

(set-env!
  :resource-paths #{"src"}
  :dependencies '[]
  :repositories #(conj % ["clojars" {:url "https://clojars.org/repo/"
                                     :username "jiyinyiyong"
                                     :password (read-password "Clojars password: ")}]))

(def +version+ "0.1.1")

(deftask deploy []
  (comp
    (pom :project     'mvc-works/verbosely
         :version     +version+
         :description "A debugging macro to make function calling verbose"
         :url         "https://github.com/mvc-works/verbosely"
         :scm         {:url "https://github.com/mvc-works/verbosely"}
         :license     {"MIT" "http://opensource.org/licenses/mit-license.php"})
    (jar)
    (push :repo "clojars" :gpg-sign false)))
