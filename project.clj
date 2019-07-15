(defproject org.clojars.vladimirmarkovic86/mail-lib "0.1.2"
  :description "Mail library"
  :url "http://github.com/VladimirMarkovic86/mail-lib"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [javax.mail/mail "1.4.7"]
                 ]

  :min-lein-version "2.0.0"
  
  :source-paths ["src/clj"]
  :test-paths ["test/clj"]
  :java-source-paths ["src/java"]
  
  :jar-exclusions [#"README.md$"
                   #"LICENSE$"])

