(ns mail-lib.core-test
  (:require [clojure.test :refer :all]
            [mail-lib.core :refer :all]))

(deftest test-send-email
  
  (testing "Test send email"
    
    (let [password (System/getenv
                     "NO_REPLY_PASSWORD")]
      (is
        (send-email
          "markovic.vladimir86.no.reply@gmail.com"
          password
          "markovic.vladimir86@gmail.com"
          "Testing subject"
          "Testing content")
       )
     )
    
   )
  
 )

