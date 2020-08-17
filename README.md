# Basic overview of Feign
This project demonstrates the basic functionality of [Feign client](https://github.com/OpenFeign/feign).

## Topics covered:
* Building client
* Encoder
* Decoder
* Error decoder
* Interceptors
* Logger
* Using own Target

No spring boot, no integration with other frameworks.

___
## How to use it

Ensure that [Maven](https://maven.apache.org/) and [Jetty](https://www.eclipse.org/jetty/) are installed.

### Server start
Execute **mvn jetty:run** command to build and start server. Now you can access it by *http://localhost:8090/feignapp/*
Available endpoints:
* GET 'product?name='
* POST 'product' with '{"name": "test","quantity": 10,"expirationDate": "2020-12-31"}' body

Use *header 'Client: Feign'* in requests for authorization. 

### Client usage
You can modify logic of client in *com.practice.client* folder. Execute main classes in *com.practice.client.main* to see result.
 