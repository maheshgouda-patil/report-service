# report-service

Spring boot application using H2 database

Set all the environment variables as mentioned below
set/export spring.datasource.url=jdbc:h2:mem:testdb
set/export spring.datasource.driverClassName=org.h2.Driver
set/export spring.datasource.username=sa
set/export spring.datasource.password=

Go to folder report-service
Docker build . -t report-service:latest 
Docker run -p 8080:8080 -d <image-id>

Check H2 Database console
http://localhost:8080/h2

Validate services 

File Upload : http://localhost:8080/service/upload (POST)
Sales report : http://localhost:8080/service/getSalesReport/{companyId} (GET)




