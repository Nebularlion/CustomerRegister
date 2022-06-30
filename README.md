# Customer register

Example Spring Boot + Angular project with PostgreSQL

## Demo

![Alt Text](https://github.com/Nebularlion/CustomerRegister/blob/master/demo.gif?raw=true)

## Data example

Data example is generated from data showed in demo.

Csv:

```
firstName,lastName,address,companyName,companyPhoneNumber
Test,Tester,"Testroad 1","Test company",04412345678
Customer,Testcustomer,"Testroad 2","Another company",044987654321
Testing,Testing,"Testingroad 1","Test company",04412345678
"Test ",Customer,"Testing 1","Another company",044987654321
```
Json:
```
[{"id":1,"firstName":"Test","lastName":"Tester","address":"Testroad 1","companyName":"Test company","companyPhoneNumber":"04412345678"},{"id":2,"firstName":"Customer","lastName":"Testcustomer","address":"Testroad 2","companyName":"Another company","companyPhoneNumber":"044987654321"},{"id":3,"firstName":"Testing","lastName":"Testing","address":"Testingroad 1","companyName":"Test company","companyPhoneNumber":"04412345678"},{"id":4,"firstName":"Test ","lastName":"Customer","address":"Testing 1","companyName":"Another company","companyPhoneNumber":"044987654321"}]
```

## Prerequisities

In order to run this container you'll need Docker and Docker compose installed.

## Usage

From project root first build docker images by running

```./build-docker.sh``` 

(You might need to add execution right to the docker script `chmod +x build-docker.sh`)

You can launch the application by running

```docker-compose up```

This will launch Spring Boot Java application, PostgreSQL database and Angular client application.

Navigate to `localhost:4200` on your browser to see the application running


