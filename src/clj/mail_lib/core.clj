(ns mail-lib.core
  (:import [mail_lib MailAuthenticator]))

(defn send-email
  "Send e-mail"
  [from
   password
   to
   subject
   content]
  (let [username from
        props (java.util.Properties.)]
    (.put
      props
      "mail.smtp.auth"
      "true")
    (.put
      props
      "mail.smtp.starttls.enable"
      "true")
    (.put
      props
      "mail.smtp.host"
      "smtp.gmail.com")
    (.put
      props
      "mail.smtp.port"
      "587")
    (let [mail-authenticator (MailAuthenticator.
                               username
                               password)
          session (javax.mail.Session/getInstance
                    props
                    mail-authenticator)]
      (try
        (let [message (javax.mail.internet.MimeMessage.
                        session)]
          (.setFrom
            message
            (javax.mail.internet.InternetAddress.
              from))
          (.setRecipients
            message
            javax.mail.Message$RecipientType/TO
            (javax.mail.internet.InternetAddress/parse
              to))
          (.setSubject
            message
            subject)
          (.setText
            message
            content)
          (javax.mail.Transport/send
            message)
          true)
        (catch Exception e
          (println e)
          false))
     ))
 )

