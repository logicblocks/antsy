(defproject io.logicblocks/antsy "0.0.9-SNAPSHOT"
  :description "Simple ANSI escape code library for Clojure."
  :url "https://github.com/logicblocks/antsy"

  :license {:name "The MIT License"
            :url  "https://opensource.org/licenses/MIT"}

  :plugins [[lein-cloverage "1.1.1"]
            [lein-shell "0.5.0"]
            [lein-ancient "0.6.15"]
            [lein-changelog "0.3.2"]
            [lein-eftest "0.5.8"]
            [lein-codox "0.10.7"]
            [lein-cljfmt "0.6.4"]]

  :profiles
  {:shared {:dependencies [[org.clojure/clojure "1.10.1"]
                           [eftest "0.5.8"]]}
   :dev    [:shared {:source-paths ["dev"]}]
   :test   [:shared]}

  :cloverage
  {:ns-exclude-regex [#"^user"]}

  :codox
  {:namespaces  [#"^antsy\."]
   :output-path "docs"
   :doc-paths ["docs"]
   :source-uri  "https://github.com/logicblocks/antsy/blob/{version}/{filepath}#L{line}"}

  :cljfmt {:indents ^:replace {#".*" [[:inner 0]]}}

  :deploy-repositories
  {"releases" {:url "https://repo.clojars.org" :creds :gpg}}

  :release-tasks
  [["shell" "git" "diff" "--exit-code"]
   ["change" "version" "leiningen.release/bump-version" "release"]
   ["codox"]
   ["changelog" "release"]
   ["shell" "sed" "-E" "-i" "s/\"[0-9]+\\.[0-9]+\\.[0-9]\"/\"%s\"/g" "README.md"]
   ["shell" "git" "add" "."]
   ["vcs" "commit"]
   ["vcs" "tag"]
   ["deploy"]
   ["change" "version" "leiningen.release/bump-version"]
   ["vcs" "commit"]
   ["vcs" "tag"]
   ["vcs" "push"]]

  :aliases {"test" ["with-profile" "test" "eftest" ":all"]})
