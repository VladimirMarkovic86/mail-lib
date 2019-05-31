(ns mail-lib.core
  (:import [mail_lib MailAuthenticator]))

(defn send-email
  "Send e-mail"
  [from
   password
   to
   subject
   content
   & [is-html
      from-contact-name]]
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
                        session)
              from (if (and from-contact-name
                            (string?
                              from-contact-name))
                     (str
                       from-contact-name
                       " <" from ">")
                     from)]
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
          (if is-html
            (do
              (.setContent
                message
                content
                "text/html; charset=utf-8")
              (.saveChanges
                message))
            (.setText
              message
              content))
          (javax.mail.Transport/send
            message)
          true)
        (catch Exception e
          (println e)
          false))
     ))
 )

