Basic REST API for listing and deleting docker containers

To build
-pip install bottle docker

To run

-python main.py

Curl commands for testing:

-curl localhost:8080/api/conts

-curl -d "contid={id from GET command}" -X POST http://localhost:8080/api/delete
	Example contid: c12e2a94630e6724f3669a918c3b2adc516473567febb294c428299f9c0877f3
