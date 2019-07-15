(defproject org.clojars.vladimirmarkovic86/mail-lib "0.1.3"
  :description "Mail library"
  :url "http://github.com/VladimirMarkovic86/mail-lib"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.sun.mail/javax.mail "1.6.2"]
                 ]

  :min-lein-version "2.0.0"
  
  :source-paths ["src/clj"]
  :test-paths ["test/clj"]
  :java-source-paths ["src/java"])

