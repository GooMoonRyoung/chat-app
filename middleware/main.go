package main

import (
	"fmt"
	"log"
	"net/http"
	"net/http/httputil" // We need this for the proxy
	"net/url"           // We need this to parse the backend URL
)

func setupCORS(w *http.ResponseWriter, r *http.Request) {
	(*w).Header().Set("Access-Control-Allow-Origin", "*") // Allow any origin
	(*w).Header().Set("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
	(*w).Header().Set("Access-Control-Allow-Headers", "Accept, Content-Type, Content-Length, Accept-Encoding, X-CSRF-Token, Authorization")
}

func main() {

	javaBackendURL, err := url.Parse("http://localhost:8081")
	if err != nil {
		log.Fatal(err)
	}

	proxy := httputil.NewSingleHostReverseProxy(javaBackendURL)

	http.HandleFunc("/api/users", func(w http.ResponseWriter, r *http.Request) {

		setupCORS(&w, r)

		if r.Method == "OPTIONS" {
			w.WriteHeader(200)
			return
		}

		fmt.Println("Received request, forwarding to Java Backend")
		proxy.ServeHTTP(w, r)
	})

	http.HandleFunc("/api/hello", func(w http.ResponseWriter, r *http.Request) {

		setupCORS(&w, r)

		if r.Method == "OPTIONS" {
			w.WriteHeader(200)
			return
		}

		fmt.Println("Received request, forwarding to Java Backend")
		proxy.ServeHTTP(w, r)
	})

	// Define a simple handler for the root path "/"
	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		fmt.Fprint(w, "Middleware has started up")
	})

	// Start the server on port 8080
	fmt.Println("Go server listening on http://localhost:8080")
	fmt.Println("Forwarding Requests Java backend listening on http://localhost:8081")
	if err := http.ListenAndServe(":8080", nil); err != nil {
		log.Fatal(err)
	}
}
