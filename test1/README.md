Basic REST API for interacting with Docker containers

Requires at least docker container running on the same computer/vm as this server. 
Ideally, the containers should all have unique names, which will be displayed alongside the ID.

To run,
-Build using "mvn clean package"
-Run "cd target"
-Run "java -jar test-1.0.jar ."

A postman collection for both REST endpoints can be found within src/main/resources. Alternately, you a browser can be used (for the GET command at least),at 
http://localhost:8080/api/runningconts