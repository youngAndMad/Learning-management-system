package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"github.com/sloonz/go-mime-message"
	"github.com/sloonz/go-qprintable"
	"io/ioutil"
	"log"
	"net/http"
	"net/smtp"
	"os"
)

func main() {
	http.HandleFunc("/api/v1/sendmail", func(w http.ResponseWriter, r *http.Request) {
		body, err := ioutil.ReadAll(r.Body)
		if err != nil {
			http.Error(w, "Failed to read request body", http.StatusBadRequest)
			return
		}

		var requestBody map[string]string
		if err := json.Unmarshal(body, &requestBody); err != nil {
			http.Error(w, "Failed to parse JSON body", http.StatusBadRequest)
			return
		}

		emailMessage := requestBody["message"]
		receiverEmail := requestBody["receiver"]

// 		m := message.NewMultipartMessage("alternative", "")
// 		m.SetHeader("Subject", message.EncodeWord("test"))

// 		m1 := message.NewTextMessage(qprintable.UnixTextEncoding, bytes.NewBufferString(emailMessage))
// 		m1.SetHeader("Content-Type", "text/plain")
// 		m.AddPart(m1)

// 		m2 := message.NewBinaryMessage(bytes.NewBufferString("this is some text as attachment."))
// 		m2.SetHeader("Content-Type", "application/octet-stream")
// 		m.AddPart(m2)

		var buf bytes.Buffer
		buf.ReadFrom(m)

		SMTP_PASSWORD, ok := os.LookupEnv("SMTP_PASSWORD")
		if !ok {
			http.Error(w, "SMTP_PASSWORD environment variable not set", http.StatusInternalServerError)
			return
		}

		res := smtp.SendMail(
			"smtp.gmail.com:587",
			smtp.PlainAuth("", "kkraken2005@gmail.com", SMTP_PASSWORD, "smtp.gmail.com"),
			"lms@example.com",
			[]string{receiverEmail},
			buf.Bytes(),
		)

		if res != nil {
			log.Printf("Failed to send email: %v", res)
			http.Error(w, "Failed to send email", http.StatusInternalServerError)
			return
		}

		fmt.Fprintf(w, "Email sent successfully")
	})

	http.ListenAndServe(":8082", nil)
}
