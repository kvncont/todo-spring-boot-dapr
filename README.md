# Todo Application - Spring-Boot & Dapr

Run application with dapr sidecar
```bash
dapr run --app-id todo --app-port 8080 --dapr-http-port 3500 --components-path dapr/components ./mvnw spring-boot:run 
```
