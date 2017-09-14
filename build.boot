
(set-env!
  :resource-paths #{"src"}
  :dependencies '[])

(def +version+ "0.1.0-alpha3")

(deftask build []
  (comp
    (pom :project     'mvc-works/verbosely
         :version     +version+
         :description "A debugging macro to make function calling verbose"
         :url         "https://github.com/mvc-works/verbosely"
         :scm         {:url "https://github.com/mvc-works/verbosely"}
         :license     {"MIT" "http://opensource.org/licenses/mit-license.php"})
    (jar)
    (install)
    (target)))

(deftask deploy []
  (set-env! :repositories #(conj % ["clojars" {:url "https://clojars.org/repo/"}]))
  (comp
    (build)
    (push :repo "clojars" :gpg-sign (not (.endsWith +version+ "-SNAPSHOT")))))
